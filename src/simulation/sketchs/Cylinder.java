package simulation.sketchs;

import simulation.SimulationWorkspace;
import idealgas.GasDataMap;
import inevaup.preferences.AppSettings;
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
    private boolean userNeedCollisions;

    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        cylinderImage = sketch.loadImage(AppResources.getResources().getImageP(R.images.cylinder)); 
        pistonImage = sketch.loadImage(AppResources.getResources().getImageP(R.images.piston1));
        pistonEngineImage = sketch.loadImage(AppResources.getResources().getImageP(R.images.pistonengine));

        pistonHeight = GasDataMap.MIN_PISTON_HEIGHT;
        cylinderDimension = new Rectangle();

        isCylinderFull = false;
        userNeedCollisions = (boolean) AppSettings.getSettings().getSetting("collisions");
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
            if (userNeedCollisions){
                for (int j = 0; j < particles.length; j++) {
                    if (i != j) {
                        particles[i].checkParticleCollision(particles[j]);
                    }
                }
            }
        }
    }

    private void updateParticles() {
        for (Particle particle : particles) {
            particle.update();
            particle.increaseVelocity(dvel);
        }
        analizeCollisions();
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

        private int color;
        
        public Particle(PVector position, float initialVelocity) {
            this.position = position;
            this.velocity = PVector.random2D();
            this.velocity.mult(initialVelocity);
            color = (int) Math.random() * 255;
        }

        public void draw(){
            sketch.fill(color);
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

            PVector distanceVect = PVector.sub(p.position, position);
            // Calculate magnitude of the vector separating the balls
            float distanceVectMag = distanceVect.mag();

            // Minimum distance before they are touching
            float minDistance = 2*RADIUS;

            if (distanceVectMag < minDistance) {

                /* float distanceCorrection = (minDistance-distanceVectMag) / 2f;
                PVector d = distanceVect.copy();
                PVector correctionVector = d.normalize().mult(distanceCorrection);
                p.position.add(correctionVector);
                position.sub(correctionVector); */

                // get angle of distanceVect
                float theta  = distanceVect.heading();
                // precalculate trig values
                float sine = PApplet.sin(theta);
                float cosine = PApplet.cos(theta);

                /* bTemp will hold rotated ball positions. You 
                just need to worry about bTemp[1] position*/
                PVector[] bTemp = {
                    new PVector(), new PVector()
                };

                /* this ball's position is relative to the other
                so you can use the vector between them (bVect) as the 
                reference point in the rotation expressions.
                bTemp[0].position.x and bTemp[0].position.y will initialize
                automatically to 0.0, which is what you want
                since b[1] will rotate around b[0] */
                bTemp[1].x  = cosine * distanceVect.x + sine * distanceVect.y;
                bTemp[1].y  = cosine * distanceVect.y - sine * distanceVect.x;

                // rotate Temporary velocities
                PVector[] vTemp = {
                    new PVector(), new PVector()
                };

                vTemp[0].x  = cosine * velocity.x + sine * velocity.y;
                vTemp[0].y  = cosine * velocity.y - sine * velocity.x;
                vTemp[1].x  = cosine * p.velocity.x + sine * p.velocity.y;
                vTemp[1].y  = cosine * p.velocity.y - sine * p.velocity.x;

                /* Now that velocities are rotated, you can use 1D
                conservation of momentum equations to calculate 
                the final velocity along the x-axis. */
                PVector[] vFinal = {  
                    new PVector(), new PVector()
                };

                // final rotated velocity for b[0]
                vFinal[0].x = vTemp[1].x;
                vFinal[0].y = vTemp[0].y;

                // final rotated velocity for b[0]
                vFinal[1].x = vTemp[0].x;
                vFinal[1].y = vTemp[1].y;

                // hack to avoid clumping
                bTemp[0].x += vFinal[0].x;
                bTemp[1].x += vFinal[1].x;

                /* Rotate ball positions and velocities back
                Reverse signs in trig expressions to rotate 
                in the opposite direction */
                // rotate balls
                PVector[] bFinal = { 
                    new PVector(), new PVector()
                };

                bFinal[0].x = cosine * bTemp[0].x - sine * bTemp[0].y;
                bFinal[0].y = cosine * bTemp[0].y + sine * bTemp[0].x;
                bFinal[1].x = cosine * bTemp[1].x - sine * bTemp[1].y;
                bFinal[1].y = cosine * bTemp[1].y + sine * bTemp[1].x;

                // update balls to screen position
                p.position.x = position.x + bFinal[1].x;
                p.position.y = position.y + bFinal[1].y;

                position.add(bFinal[0]);

                // update velocities
                velocity.x = cosine * vFinal[0].x - sine * vFinal[0].y;
                velocity.y = cosine * vFinal[0].y + sine * vFinal[0].x;
                p.velocity.x = cosine * vFinal[1].x - sine * vFinal[1].y;
                p.velocity.y = cosine * vFinal[1].y + sine * vFinal[1].x;
            }

        }

        public void checkBorderCollision(){
             
            if(position.x - RADIUS <= cylinderDimension.x){
                position.x = cylinderDimension.x + RADIUS;
                velocity.x = PApplet.abs(velocity.x);
            }

            if(position.x + RADIUS >= cylinderDimension.x + cylinderDimension.width){
                position.x = cylinderDimension.x + cylinderDimension.width - RADIUS;
                velocity.x = -1 * PApplet.abs(velocity.x);
            }

            if(position.y - RADIUS <= cylinderDimension.y){
                position.y = cylinderDimension.y + RADIUS;
                velocity.y = PApplet.abs(velocity.y);
            }

            if(position.y + RADIUS >= cylinderDimension.y + cylinderDimension.height){
                position.y = cylinderDimension.y + cylinderDimension.height - RADIUS;
                velocity.y = -1 * PApplet.abs(velocity.y);
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
