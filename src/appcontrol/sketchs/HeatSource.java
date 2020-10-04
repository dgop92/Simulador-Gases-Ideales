package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;
import processing.core.PImage;

public class HeatSource extends SketchFragment {

    private PImage heatArrowImage;
    private PImage flameImage;
    private float temperature;
    private boolean isLosingHeat;

    public HeatSource(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
    }
    
    @Override
    public void update() {
        
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    private void drawFlame() {

    }
    
    private void drawHeatArrows() {

    }

    private void setLosingHeat(boolean b){
        isLosingHeat = b;
    }
    
}
