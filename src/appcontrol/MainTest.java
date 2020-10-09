package appcontrol;

import java.util.HashMap;

import forms.TransformationType;

public class MainTest {
    
    public static void main(String[] args) {
        
        SimulationWorkspace sm = new SimulationWorkspace();

        HashMap<String, Float> initialData = new HashMap<String, Float>();
        initialData.put("pressure", 50662.5f);
        initialData.put("volume", 100f);
        initialData.put("temperature", 283.15f);
        initialData.put("n", 1.5f);

        HashMap<String, Float> finalData = new HashMap<String, Float>();
        finalData.put("pressure", 48000f);
        finalData.put("volume", 0f);
        finalData.put("temperature", 0f);

        sm.setGasTransformation(initialData, finalData, TransformationType.ISOTHERMAL);

        sm.run(); 
    }
    
}
