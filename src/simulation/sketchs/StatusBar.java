package simulation.sketchs;

import java.util.HashMap;

import java.text.DecimalFormat;

import simulation.SimulationWorkspace;

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
        DecimalFormat roundFormat = new DecimalFormat("#.##");
        if (sketch.isRunning){      
            sketch.fill(255);   
            sketch.textFont(sketch.robotoFont);
            sketch.textSize(16);       
            sketch.text("Volumen " + roundFormat.format(currentGasData.get("volume")) + "  litros", x + 20, y + 20); 
            sketch.text("Presión  " + roundFormat.format(currentGasData.get("pressure"))+ "  atm", x + 20, y + 40); 
            sketch.text("Temperatura  " + roundFormat.format(currentGasData.get("temperature"))+ "  Kelvin", x + 20, y + 60); 
            sketch.text("                    Velocidad  " +roundFormat.format(currentGasData.get("velocity"))+ "  mts/segs", x + 150, y + 60);
        }
         
    }
    
    public void setData(HashMap<String, Float> currentGasData){
        this.currentGasData = currentGasData;
    }
    
}
