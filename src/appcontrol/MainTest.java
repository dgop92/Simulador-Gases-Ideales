package appcontrol;

import java.util.HashMap;

import appcontrol.transformations.TransformationStrategy;
import forms.TransformationType;
import processing.core.PVector;

public class MainTest {
    
    public static void main(String[] args) {
        
        SimulationWorkspace sm = new SimulationWorkspace();

        HashMap<String, Float> initialData = new HashMap<String, Float>();
        initialData.put("pressure", 50662.5f);
        initialData.put("volume", 100f);
        initialData.put("temperature", 350f);
        initialData.put("n", 1.5f);

        HashMap<String, Float> finalData = new HashMap<String, Float>();
        finalData.put("pressure", 0f);
        finalData.put("volume", 0f);
        finalData.put("temperature", 380f);

        sm.setGasTransformation(initialData, finalData, TransformationType.ISOBARIC);

        sm.run();
        
        /* PVector p = new PVector(10, 20);
        System.out.println(p.toString());
        p.rotate((float)Math.PI);
        System.out.println(p.toString()); */
        
    }
    
}
