package simulation.sketchs;

import java.util.HashMap;

import inevaup.resources.AppResources;
import inevaup.resources.R;

import java.text.DecimalFormat;

import simulation.SimulationWorkspace;

public class StatusBar extends SketchFragment {

    private HashMap<String, Float> currentGasData;
    boolean isGasBeingExpanded;
    boolean isGasBeingCompressed;

    public StatusBar(SimulationWorkspace sketch, float x, float y, float 
        fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
    }

    @Override
    public void update() {
        draw();
    }
    
    @Override
    public void draw(){
        DecimalFormat roundFormat = new DecimalFormat("#.##");
        
        if (currentGasData != null){      
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

            if (isGasBeingCompressed){
                sketch.text(AppResources.getResources().getString(R.strings.status_gas_compressed), 
                        x + 300, 
                        y + 40);
            }

            if (isGasBeingExpanded){
                sketch.text(AppResources.getResources().getString(R.strings.status_gas_expanded), 
                        x + 300, 
                        y + 40);
            }

            
        }

        sketch.fill(255);   
        sketch.textFont(sketch.robotoFont);
        sketch.textSize(14);
        drawSimulationStatus();
         
    }

    public void setGasExpandedCompressed(boolean isBeingExpanded, boolean isBeingCompressed){
        this.isGasBeingExpanded = isBeingExpanded;
        this.isGasBeingCompressed = isBeingCompressed;
    }
    
    public void setData(HashMap<String, Float> currentGasData){
        this.currentGasData = currentGasData;
    }

    private void drawSimulationStatus(){
        
        sketch.text("Running: " + sketch.isRunning, 
                    x + 450, 
                    y + 20);
        
        sketch.text("Paused: " + sketch.isPaused, 
                    x + 450, 
                    y + 40);

        sketch.text("FPS: " + sketch.frameRate, 
                    x + 450, 
                    y + 60);
        
    }
    
}
