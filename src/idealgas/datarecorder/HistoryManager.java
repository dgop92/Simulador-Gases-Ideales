package idealgas.datarecorder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import idealgas.TransformationType;

import javax.swing.DefaultListModel;

public class HistoryManager {

    public static final String HISTORY_PATH = "smdata/history";

    public HistoryManager() {

    }

    public boolean saveInputData(HashMap<String, Float> initialData, HashMap<String, Float> finalData,
            TransformationType transformationType){

        createSMDataFolder();

        DateTimeFormatter dateFileNameFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String fileName = "smgas_" + LocalDateTime.now().format(dateFileNameFormatter) + ".json";

        JsonObject jsonHistoryData = getHistoryJsonObject(initialData, finalData, transformationType);

        try {
            FileWriter fileWriter = new FileWriter(HISTORY_PATH + "/" + fileName);
            fileWriter.write(Jsoner.prettyPrint(jsonHistoryData.toJson()));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public DefaultListModel<HistoryItem> getHistoryDefaultModel(){

        DefaultListModel<HistoryItem> historyModel = new DefaultListModel<>();

        File smdataFolder = new File(HistoryManager.HISTORY_PATH);
        File[] historyFiles = smdataFolder.listFiles();

        for (File historyFile : historyFiles) {
            JsonObject jsonHistory = getHistoryJsonObjectFromFile(historyFile);

            if (jsonHistory != null){
                String date = (String) jsonHistory.get("date");
                HashMap<String, Float> initialData = (HashMap<String, Float>) jsonHistory.get("initial_data");
                HashMap<String, Float> finalData = (HashMap<String, Float>) jsonHistory.get("final_data");
                TransformationType transformationType = 
                    TransformationType.valueOf((String)jsonHistory.get("transformation_type"));

                historyModel.addElement(new HistoryItem(initialData, finalData, transformationType, date));
            }
        }

        return historyModel;

    }

    private JsonObject getHistoryJsonObjectFromFile(File file){

        JsonObject jsonHistory;

        try {
            FileReader jsonHistoryFileReader = new FileReader(file);
            jsonHistory = (JsonObject) Jsoner.deserialize(jsonHistoryFileReader);
            jsonHistoryFileReader.close();
        } catch (IOException | JsonException e) {
            jsonHistory = null;
        }

        return jsonHistory;
    }

    private void createSMDataFolder(){

        File smdataFolder = new File(HistoryManager.HISTORY_PATH);
        if (!smdataFolder.exists()){
            smdataFolder.mkdirs();
        }
    }

    private JsonObject getHistoryJsonObject(HashMap<String, Float> initialData, HashMap<String, Float> finalData,
            TransformationType transformationType) {
        
        DateTimeFormatter dateJsonFieldFormatter = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss");
        String dateField = LocalDateTime.now().format(dateJsonFieldFormatter);

        JsonObject jsonHistory = new JsonObject();

        JsonObject initialJsonData = new JsonObject();
        initialJsonData.putAll(initialData);

        JsonObject finalJsonData = new JsonObject();
        finalJsonData.putAll(finalData);

        jsonHistory.put("date", dateField);
        jsonHistory.put("initial_data", initialJsonData);
        jsonHistory.put("final_data", finalJsonData);
        jsonHistory.put("transformation_type", transformationType.name());

        return jsonHistory;
    }
}
