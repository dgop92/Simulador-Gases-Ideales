package simulation;

import java.util.HashMap;

import idealgas.TransformationType;
import inevaup.resources.AppResources;

public class MainTestSimulation {
    
    public static void main(String[] args) {

        //Just for test
        AppResources.getAppResources().loadResources();
        
        SimulationWorkspace sm = new SimulationWorkspace();
        sm.run();

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

        //usando is running podras empezar la simulacion, si no se activa solo se dibujaran los componentes
        //no se actualizan
        sm.isRunning = true;


    }
}
