package idealgas.datarecorder;

import java.util.HashMap;

import interfaces.control.HistoryDialog;

public class TestData {

    public static void main(String[] args) {

        HashMap<String, Float> initialData = new HashMap<>();
        initialData.put("pressure", 60000f);
        initialData.put("volume", 91f);
        initialData.put("temperature", 283f);
        initialData.put("n", 100f);

        HashMap<String, Float> finalData = new HashMap<>();
        finalData.put("pressure", 0f);
        finalData.put("volume", 0f);
        finalData.put("temperature", 400f);

        HistoryManager historyManager = new HistoryManager();

        HistoryDialog historyDialog = new HistoryDialog(null, true, historyManager.getHistoryDefaultModel());
        historyDialog.setVisible(true);

        if(historyDialog.isItemSelected){
            System.out.println(historyDialog.getSelectedHistoryItem());
        }
    
    }
}
