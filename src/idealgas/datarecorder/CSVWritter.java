package idealgas.datarecorder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class CSVWritter {

    public static final String CSV_DATA_PATH = "smdata/data_csv";

    private StringBuilder csvData;

    public CSVWritter() {
        createSMDataFolder();
        csvData = new StringBuilder();
    }

    public void putRow(HashMap<String, Float> gasData) {

        String pressure = getFormatedGasFloatData(gasData.get("pressure"));
        String volume = getFormatedGasFloatData(gasData.get("volume"));
        String temperature = getFormatedGasFloatData(gasData.get("temperature"));

        String internalEnergy = getFormatedGasFloatData(gasData.get("internalEnergy"));
        String heat = getFormatedGasFloatData(gasData.get("heat"));
        String work = getFormatedGasFloatData(gasData.get("work"));

        String velocity = getFormatedGasFloatData(gasData.get("velocity"));

        String row = pressure + "," + volume + "," + temperature + "," + internalEnergy + "," + heat + "," + work + ","
                + velocity + ";\n";

        csvData.append(row);
    }

    public boolean saveData(){
        DateTimeFormatter dateFileNameFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String fileName = "data" + LocalDateTime.now().format(dateFileNameFormatter) + ".txt";

        try {
            FileWriter writer = new FileWriter(CSV_DATA_PATH + "/" + fileName, true);
            writer.append(csvData);
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private void createSMDataFolder(){

        File smdataFolder = new File(CSV_DATA_PATH);
        if (!smdataFolder.exists()){
            smdataFolder.mkdirs();
        }
    }

    private String getFormatedGasFloatData(float n){
        return String.format("%.2f", n).replace(',', '.');
    }
}
