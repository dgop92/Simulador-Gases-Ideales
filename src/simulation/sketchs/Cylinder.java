package simulation.sketchs;

import simulation.SimulationWorkspace;
import processing.core.PImage;
import processing.core.PVector;

public class Cylinder extends SketchFragment {

    private float volume;

    private PImage cylinderImage;
    private PImage pistonImage;

    private Particle[] particles;

    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

    }

    @Override
    public void update() {

        //updateParticles();
    }

    public void fillCylinder(int nParticle, float v) {
        particles = new Particle[nParticle];
        particles[0] = new Particle(getRandomPos(), new PVector(v, v));
        for (int i = 1; i < particles.length; i++) {
            particles[i] = new Particle(getAvaliablePos(i), new PVector(v, v));
        }
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void drawCylinder() {

    }

    public void drawPiston() {

    }

    private void updateParticles() {
        analizeCollisions();
        for (Particle particle : particles) {
            particle.update();
        }
    }

    public void drawParticles(){
        for (Particle particle : particles) {
            particle.draw();
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
        
        float fromX = x + Particle.RADIUS;
        float toWidth = fragmentWidth - Particle.RADIUS;

        float fromY = y + Particle.RADIUS;
        float toHeight =  y + fragmentHeight - Particle.RADIUS;

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
            draw();
            position.x += velocity.x;
            position.y += velocity.y;
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

            if(position.x - RADIUS <= x || position.x + RADIUS >= x + fragmentWidth){
                this.velocity.x *= -1;
            }
    
            if(position.y - RADIUS <= y || position.y + RADIUS >= y + fragmentHeight){
                this.velocity.y *= -1;
            }
        }
        
    }

}
