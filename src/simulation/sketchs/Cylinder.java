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


    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        cylinderImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.cylinder)); 
        pistonImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.piston1));
        pistonEngineImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.pistonengine));

        pistonHeight = GasDataMap.MIN_PISTON_HEIGHT;
        cylinderDimension = new Rectangle();

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
        particles[0] = new Particle(getRandomPos(), new PVector(v, v));
        for (int i = 1; i < particles.length; i++) {
            particles[i] = new Particle(getAvaliablePos(i), new PVector(v, v));
        }

        sketch.delay(1000);
    }

    private void drawParticles(){
        if (particles != null){
            for (Particle particle : particles) {
                particle.draw();
            }
        }
    }

    private void analizeCollisions() {
        for (int i = 0; i < particles.length; i++) {
            particles[i].checkBorderCollision();
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
        public byte directionX;
        public byte directionY;

        public static final float RADIUS = 10;
        
        public Particle(PVector position, PVector velocity) {
            this.position = position;
            this.velocity = velocity;
            
            //directionX = (Math.random() > 0.5) ? (byte)-1 : 1;  
            //directionY = (Math.random() > 0.5) ? (byte)-1 : 1;
        }

        public void draw(){
            sketch.fill(0);
            sketch.stroke(255);
            sketch.circle(position.x, position.y, RADIUS);
        }

        public void update(){
            position.x += velocity.x;
            position.y += velocity.y;
            draw();
        }

        public void checkParticleCollision(Particle p){

            float xVelocityDiff = this.velocity.x - p.velocity.x;
            float yVelocityDiff = this.velocity.y - p.velocity.y;

            float xDist = p.position.x - this.position.x;
            float yDist = p.position.y - this.position.y;

            ////float dist = this.position.dist(p.position);
            //xVelocityDiff * xDist + yVelocityDiff * yDist >= 0

            if (xVelocityDiff * xDist + yVelocityDiff * yDist >= 0) {



                /* float angle = (float) -Math.atan2(yDist, xDist);

                float m1 = 1, m2 = 1;

                PVector u1 = this.velocity.rotate(angle);
                PVector u2 = p.velocity.rotate(angle);

                float v1x = u1.x * (m1 - m2) / (m1 + m2)  + 2 * m2 * u2.x / (m1 + m2);
                float v1y = u1.y;

                float v2x = u2.x * (m1 - m2) / (m1 + m2)  + 2 * m2 * u1.x / (m1 + m2);
                float v2y = u2.y;

                PVector v1final = new PVector(v1x, v1y);
                v1final.rotate(-angle);
                PVector v2final = new PVector(v2x, v2y);
                v2final.rotate(-angle);

                this.velocity.x = v1final.x;
                this.velocity.y = v1final.y;

                p.velocity.x = v2final.x;
                p.velocity.y = v2final.y; */

            }
        }

        public void checkBorderCollision(){

            if(position.x - RADIUS <= cylinderDimension.x || position.x + RADIUS >= cylinderDimension.x + cylinderDimension.width){
                this.velocity.x *= -1;
            }
    
            if(position.y - RADIUS <= cylinderDimension.y || position.y + RADIUS >= cylinderDimension.y + cylinderDimension.height){
                this.velocity.y *= -1;
            }
        }
        
    }

}
