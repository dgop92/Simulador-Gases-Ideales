package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;
import processing.core.PImage;

public class Thermometer extends SketchFragment {

    private PImage thermotherImage;
    private float temperature;

    public Thermometer(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
        
    }

    @Override
    public void update() {

    }
    
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    private void draw(){

    }
}
