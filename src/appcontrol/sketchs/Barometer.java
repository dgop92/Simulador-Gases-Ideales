package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;
import processing.core.PImage;

public class Barometer extends SketchFragment {

    private float pressure;
    private PImage thermotherImage;

    public Barometer(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

    }

    @Override
    public void update() {
        
    }

    public void setTemperature(float pressure) {
        this.pressure = pressure;
    }

    private void draw() {

    }
}