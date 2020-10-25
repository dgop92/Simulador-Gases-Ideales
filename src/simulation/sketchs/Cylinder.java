package simulation.sketchs;

import simulation.SimulationWorkspace;
import idealgas.GasDataMap;
import inevaup.resources.AppResources;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import inevaup.resources.R;

import java.awt.Rectangle;

public class Cylinder extends SketchFragment {

    private float pistonHeight;

    private PImage cylinderImage;
    private PImage pistonImage;
    private PImage pistonEngineImage; 

    private Particle[] particles;

    private Rectangle cylinderDimension;
    private boolean isCylinderFull;

    private float dvel;

    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        cylinderImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.cylinder)); 
        pistonImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.piston1));
        pistonEngineImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.pistonengine));

        pistonHeight = GasDataMap.MIN_PISTON_HEIGHT;
        cylinderDimension = new Rectangle();

        isCylinderFull = false;
    }

    @Override
    public void update() {

        cylinderDimension.setRect(x + 68, y + pistonHeight + 20, 366, fragmentHeight - 44 - pistonHeight - 20);
        draw();
        updateParticles();

    }

    public void draw() {

        drawCylinder();
        drawPiston();

        drawParticles();

    }

    public void setPistonHeight(float pistonHeight) {
        this.pistonHeight = pistonHeight;
    }

    public void increaseVelocity(float dvel){
        this.dvel = dvel;
    }

    public void fillCylinder(float initialVolume, int nParticle, float v) {

        float initialPistonHeight = PApplet.map(initialVolume, 
            GasDataMap.MIN_PROCESS_VOLUME, GasDataMap.MAX_PROCESS_VOLUME, 
            GasDataMap.MAX_PISTON_HEIGHT, GasDataMap.MIN_PISTON_HEIGHT);
            
        for (int i = (int)pistonHeight; i < initialPistonHeight; i += 3) {
            pistonHeight += 3;
            sketch.delay(64);
        }

        cylinderDimension.setRect(x + 68, y + initialPistonHeight + 20, 366, fragmentHeight - 44 - initialPistonHeight);

        particles = new Particle[nParticle];
        particles[0] = new Particle(getRandomPos(), v);
        for (int i = 1; i < particles.length; i++) {
            particles[i] = new Particle(getAvaliablePos(i), v);
        }

        sketch.delay(1000);
        isCylinderFull = true;
    }

    private void drawParticles(){
        if (isCylinderFull){
            for (Particle particle : particles) {
                particle.draw();
            }
        }
    }

    private void analizeCollisions() {
        for (int i = 0; i < particles.length; i++) {
            particles[i].checkBorderCollision();
            if (i == 0){
                sketch.textSize(18);
                sketch.fill(255);
                sketch.text("VELOCIDAD  "+ particles[i].velocity, 20, 100);
            }
            /* for (int j = 0; j < particles.length; j++) {
                if (i != j) {
                    particles[i].checkParticleCollision(particles[j]);
                }
            } */
        }
    }

    private void updateParticles() {
        analizeCollisions();
        for (Particle particle : particles) {
            particle.update();
            particle.increaseVelocity(dvel);
        }
    }

    private void drawCylinder() {
        sketch.image(cylinderImage, x, y, fragmentWidth, fragmentHeight);
    }

    private void drawPiston() {
        sketch.image(pistonEngineImage, x + 226, y + 5, 45, pistonHeight); 
        sketch.image(pistonImage, x + 68, y + pistonHeight, 366, 20);

    }

    private PVector getAvaliablePos(int nParticles){

        PVector tempPosition;
        boolean isPositionSafe;
        //para evitar un infinite loop
        int nTries = 0;
        int i;

        boolean keepSearching = true;

        //Esta pos se usa si no se logro encontrar ninguna posicion segura
        tempPosition = getRandomPos();
        while(keepSearching && nTries < 50){
            tempPosition = getRandomPos();
            isPositionSafe = true;
            i = 0;
            while (i < nParticles && isPositionSafe){
                float dist = tempPosition.dist(particles[i].position);
                isPositionSafe = dist >= 2 * Particle.RADIUS;
                i++;
            }

            keepSearching = !isPositionSafe;
            nTries++;
        }
        
        return tempPosition;
    }

    private PVector getRandomPos(){
        
        float yVariation = 15f; 

        float fromX = cylinderDimension.x + Particle.RADIUS;
        float toWidth = cylinderDimension.x + cylinderDimension.width - Particle.RADIUS;

        float fromY = cylinderDimension.y + Particle.RADIUS;
        float toHeight =  cylinderDimension.y + cylinderDimension.height - Particle.RADIUS - yVariation;

        float posX = (float) Math.random()*(toWidth - fromX) + fromX;
        float posY = (float) Math.random()*(toHeight - fromY) + fromY;

        return new PVector(posX, posY);

    }

    class Particle{

        public PVector position;
        public PVector velocity;

        public static final float RADIUS = 10;
        
        public Particle(PVector position, float initialVelocity) {
            this.position = position;
            this.velocity = PVector.random2D();
            this.velocity.mult(initialVelocity);
        }

        public void draw(){
            sketch.fill(0);
            sketch.stroke(255);
            sketch.strokeWeight(1);
            sketch.circle(position.x, position.y, RADIUS);
        }

        public void update(){
            position.x += velocity.x;
            position.y += velocity.y;
            draw();
        }

        public void increaseVelocity(float dvel){
            PVector unitVector = extractUnitVector(this.velocity);
            this.velocity.add(dvel, dvel);

            checkMaxAndMinVelocity();
            
            this.velocity.x *= unitVector.x;
            this.velocity.y *= unitVector.y;
        }

        public void checkParticleCollision(Particle p){

            //TO DO
        }

        public void checkBorderCollision(){

            if(position.x - RADIUS <= cylinderDimension.x || position.x + RADIUS >= cylinderDimension.x + cylinderDimension.width){
                this.velocity.x *= -1;
            }
    
            if(position.y - RADIUS <= cylinderDimension.y || position.y + RADIUS >= cylinderDimension.y + cylinderDimension.height){
                this.velocity.y *= -1;
            }
        }

        private PVector extractUnitVector(PVector p){
            PVector unitVector = new PVector(Math.signum(p.x), Math.signum(p.y));
            p.x = Math.abs(p.x);
            p.y = Math.abs(p.y);
            return unitVector;
        }

        //Limit adiabatic and issues
        private void checkMaxAndMinVelocity(){

            if (velocity.x <= GasDataMap.MIN_PROCESS_VELOCITY){
                velocity.x = GasDataMap.MIN_PROCESS_VELOCITY;
            }

            if (velocity.y <= GasDataMap.MIN_PROCESS_VELOCITY){
                velocity.y = GasDataMap.MIN_PROCESS_VELOCITY;
            }

            if (velocity.x >= GasDataMap.MAX_PROCESS_VELOCITY){
                velocity.x = GasDataMap.MAX_PROCESS_VELOCITY;
            }

            if (velocity.y >= GasDataMap.MAX_PROCESS_VELOCITY){
                velocity.y = GasDataMap.MAX_PROCESS_VELOCITY;
            }
            
        }
        
    }

}
