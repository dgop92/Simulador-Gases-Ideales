package appcontrol;

import processing.core.PApplet;

public class SimulationWorkSpace extends PApplet{
    
    @Override
    public void settings() {
        size(800, 600);
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
        String[] processingArgs = { SimulationWorkSpace.class.getName() };
        PApplet.runSketch(processingArgs, this);
    }

}
