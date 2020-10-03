package appcontrol;

import processing.core.PApplet;

public class SimulationWorkspace extends PApplet{

    private final int SKETCH_WIDTH = 800;
    private final int SKETCH_HEIGHT = 600;
    
    @Override
    public void settings() {
        size(SKETCH_WIDTH, SKETCH_HEIGHT);
    }

    @Override
    public void setup() {
        //frameRate(30);
        
    }

    @Override
    public void draw() {
        background(0);
        stroke(255);
        line(0, 0, width, height);
    }


    public void run() {
        String[] processingArgs = { SimulationWorkspace.class.getName() };
        PApplet.runSketch(processingArgs, this);
    }

}
