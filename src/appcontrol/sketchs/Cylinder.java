package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;
import processing.core.PImage;
import processing.core.PVector;

public class Cylinder extends SketchFragment {

    private float volume;

    private PImage cylinderImage;
    private PImage pistonImage;

    private Particle[] particles;
    private PVector particleVelocity;

    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        particleVelocity = new PVector(0.9f, 0.9f);
    }

    @Override
    public void update() {

        updateParticles();
    }

    public void fillCylinder(int nParticle) {
        particles = new Particle[nParticle];
        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle();
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

    private void analizeCollisions() {
        for (int i = 0; i < particles.length; i++) {
            particles[i].checkBorderCollision();
            for (int j = 0; j < particles.length; j++) {
                if (i != j) {
                    particles[i].checkParticleCollision(particles[j]);
                }
            }
        }
    }

    class Particle{

        public PVector position;
        public byte directionX;
        public byte directionY;

        public static final float RADIUS = 10;
        
        public Particle() {
            generateRandomPos();

            directionX = (Math.random() > 0.5) ? (byte)-1 : 1;  
            directionY = (Math.random() > 0.5) ? (byte)-1 : 1;
        }

        public void draw(){
            sketch.fill(255);
            sketch.circle(position.x, position.y, RADIUS);
        }

        public void update(){
            draw();
            position.x += particleVelocity.x * directionX;
            position.y += particleVelocity.y * directionY;
        }

        private void generateRandomPos(){

            float fromX = x + RADIUS;
            float toWidth = fragmentWidth - RADIUS;

            float fromY = y + RADIUS;
            float toHeight = fragmentHeight - RADIUS;

            float posX = (float) Math.random()*(toWidth - fromX) + fromX;
            float posY = (float) Math.random()*(toHeight - fromY) + fromY;

            position = new PVector(posX, posY);
        }

        public void checkParticleCollision(Particle p){
            float dist = position.dist(p.position);
            if(dist <= 2 * (RADIUS- 5)){
                directionX *= -1;
                directionY *= -1;
                /* p.directionX *= -1;
                p.directionY *= -1; */
            }
        }

        public void checkBorderCollision(){

            if(position.x <= x || position.x >= x + fragmentWidth){
                directionX *= -1;
            }
    
            if(position.y <= y || position.y >= y + fragmentHeight){
                directionY *= -1;
            }
        }
        
    }

}
