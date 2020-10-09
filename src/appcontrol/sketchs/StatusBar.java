package appcontrol.sketchs;

import java.util.HashMap;

import appcontrol.SimulationWorkspace;

public class StatusBar extends SketchFragment {

    HashMap<String, Float> currentGasData;

    public StatusBar(SimulationWorkspace sketch, float x, float y, float 
        fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
    }

    @Override
    public void update() {
        draw();
    }

    public void draw(){
        sketch.textSize(16);
        sketch.fill(255);
        sketch.text("V  " + currentGasData.get("volume"), x + 20, y + 20); 
        sketch.text("P  " + currentGasData.get("pressure"), x + 20, y + 40); 
        sketch.text("T  " + currentGasData.get("temperature"), x + 20, y + 60); 

        sketch.text("FV  " + currentGasData.get("fake_velocity"), x + 150, y + 20); 
        sketch.text("FVol  " +currentGasData.get("fake_volume"), x + 150, y + 40); 
        sketch.text("Vel  " +currentGasData.get("velocity"), x + 150, y + 60); 
    }
    
    public void setData(HashMap<String, Float> currentGasData){
        this.currentGasData = currentGasData;
    }
    
}
