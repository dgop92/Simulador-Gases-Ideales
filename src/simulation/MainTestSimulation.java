package simulation;

import java.util.HashMap;

import idealgas.TransformationType;
import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;
import inevaup.resources.AppResources;

public class MainTestSimulation {
    
    public static void main(String[] args) {

        //Just for test
        AppResources.getAppResources().loadResources();
        
        SimulationWorkspace sm = new SimulationWorkspace();
        sm.run();

        HashMap<String, Float> initialData = new HashMap<>();
        initialData.put("pressure", 60000f);
        initialData.put("volume", 91f);
        initialData.put("temperature", 283f);
        initialData.put("n", 100f);

        HashMap<String, Float> finalData = new HashMap<>();
        finalData.put("pressure", 0f);
        finalData.put("volume", 0f);
        finalData.put("temperature", 400f);

        //esto tambien inicia la trasnformacion
        boolean isRunning = sm.requestStartOfSimulation(initialData, finalData, TransformationType.ISOBARIC);
        if (!isRunning){
            InfoDialog infoDialog = new InfoDialog(null, "Numero de particles exedidas", 
                                                   sm.runErrorMessage, TypeInfoDialog.ERROR_DIALOG);
        }
        //System.out.println(sm.isRunning);

    }
}
