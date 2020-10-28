package idealgas.datarecorder;

import java.io.File;
import java.io.FileNotFoundException;
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
import inevaup.preferences.SaveException;

public class HistoryManager {

    public static final String HISTORY_PATH = "smdata/history";

    public HistoryManager() {

    }

    public void saveInputData(HashMap<String, Float> initialData, HashMap<String, Float> finalData,
            TransformationType transformationType) throws SaveException {

        createSMDataFolder();

        DateTimeFormatter dateFileNameFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String fileName = "smgas_" + LocalDateTime.now().format(dateFileNameFormatter) + ".json";

        JsonObject jsonHistoryData = getHistoryJsonObject(initialData, finalData, transformationType);

        try {
            FileWriter fileWriter = new FileWriter(HISTORY_PATH + "/" + fileName);
            fileWriter.write(Jsoner.prettyPrint(jsonHistoryData.toJson()));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new SaveException("No se puedo guardar los datos en el historial");
        } catch (Exception e){
            throw new SaveException("No se puedo guardar en el historial");
        }
    }

    //has to be change in order to check for erros
    public HistoryItem[] getHistoryItems(){

        File smdataFolder = new File(HistoryManager.HISTORY_PATH);
        File[] historyFiles = smdataFolder.listFiles();

        HistoryItem[] historyItems = new HistoryItem[historyFiles.length];

        int i = 0;
        for (File historyFile : historyFiles) {
            JsonObject jsonHistory = getHistoryJsonObjectFromFile(historyFile);
            String date = (String) jsonHistory.get("date");
            HashMap<String, Float> initialData = (HashMap<String, Float>) jsonHistory.get("initial_data");
            HashMap<String, Float> finalData = (HashMap<String, Float>) jsonHistory.get("final_data");
            TransformationType transformationType = 
                TransformationType.valueOf((String)jsonHistory.get("transformation_type"));

            historyItems[i] = new HistoryItem(initialData, finalData, transformationType, date);
            i++;
        }

        return historyItems;
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
            System.out.println(smdataFolder.mkdirs());
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
