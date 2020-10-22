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
            sketch.textSize(14); 

            // Primera Colunma

            String internalEnergy = roundFormat.format(currentGasData.get("internalEnergy")).toString();
            String heat = roundFormat.format(currentGasData.get("heat")).toString();
            String work = roundFormat.format(currentGasData.get("work")).toString();
            
            sketch.text(String.format("U: %s J", internalEnergy), 
                        x + 20, 
                        y + 20);

            sketch.text(String.format("Q: %s J", heat), 
                        x + 20, 
                        y + 40);

            // Segunda Colunma

            String volume = roundFormat.format(currentGasData.get("volume")).toString();

            sketch.text(String.format("V: %s m^3", volume), 
                        x + 150, 
                        y + 20);

            sketch.text(String.format("W: %s J", work), 
                        x + 150, 
                        y + 40);

            // Tercera Colunma

            String velocity = roundFormat.format(currentGasData.get("velocity")).toString();

            sketch.text(String.format("Vel: %s m/s", velocity), 
                        x + 300, 
                        y + 20);

        }
         
    }
    
    public void setData(HashMap<String, Float> currentGasData){
        this.currentGasData = currentGasData;
    }
    
}
