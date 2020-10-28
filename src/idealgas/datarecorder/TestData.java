package idealgas.datarecorder;

import java.util.HashMap;

import idealgas.TransformationType;
import inevaup.preferences.SaveException;

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
        historyManager.getHistoryItems();
        HistoryItem[] items = historyManager.getHistoryItems();
        System.out.println(items[1]);
        /* try {
            historyManager.saveInputData(initialData, finalData, TransformationType.ISOBARIC);
        } catch (SaveException e) {
            System.out.println(e);
        } */

        /* HistoryItem ht = new HistoryItem(initialData, finalData, TransformationType.ISOBARIC, "mié. oct. 28 2020 09:47:20");
        System.out.println(ht); */

    }
}
