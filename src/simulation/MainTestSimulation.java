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
        initialData.put("pressure", 60000f);
        initialData.put("volume", 128f);
        initialData.put("temperature", 400f);
        initialData.put("n", 1.5f);

        HashMap<String, Float> finalData = new HashMap<String, Float>();
        finalData.put("pressure", 0f);
        finalData.put("volume", 0f);
        finalData.put("temperature", 283.15f);

        //esto tambien inicia la trasnformacion
        sm.setGasTransformation(initialData, finalData, TransformationType.ISOVOLUMETRIC);
        System.out.println(sm.isRunning);

    }
}
