package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;
import processing.core.PImage;
import processing.core.PVector;

public class Cylinder extends SketchFragment {

    private float volume;

    private PImage cylinderImage;
    private PImage pistonImage;

    private int nParticle;

    public static PVector particleVelocity;
    private Particle[] particles;

    public Cylinder(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
    }

    @Override
    public void update() {

    }

    public void setVolume(float volume){
        this.volume = volume; 
    }

    public void fillCylinder(int nParticle){
        
    }

    private void drawCylinder(){

    }
    
    private void drawPiston(){

    }

}
