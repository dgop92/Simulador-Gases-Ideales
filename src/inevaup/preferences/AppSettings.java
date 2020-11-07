package inevaup.preferences;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class AppSettings {

    public final static String BASE_PATH = "src/data";
    // public final static String BASE_PATH = "data";
    public final static String SETTINGS_PATH = "/settings.json";
    public boolean isSettingsLoaded;

    private static AppSettings settings = null;
    private String errorMessage;
    private JsonObject jsonSettings;

    public static AppSettings getSettings() {
        if (settings == null) {
            settings = new AppSettings();
        }
        return settings;
    }

    public void loadSettings() {

        errorMessage = "";
        isSettingsLoaded = true;

        loadJsonSettings(BASE_PATH + SETTINGS_PATH);
        if (jsonSettings == null) {
            setDefaultSettings();
        }

        if(!saveSettings()){
            isSettingsLoaded = false;
        }

    }

    public Object getSetting(String key){
        return jsonSettings.get(key);
    }

    public void updateSetting(String key, Object value){
        jsonSettings.replace(key, value);
    }

    public boolean saveSettings(){
        try {
            FileWriter fileWriter = new FileWriter(BASE_PATH +  SETTINGS_PATH);
            fileWriter.write(Jsoner.prettyPrint(jsonSettings.toJson()));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private void loadJsonSettings(String path){

        try {
            FileReader fileReader = new FileReader(path);
            jsonSettings = (JsonObject) Jsoner.deserialize(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            jsonSettings = null;
            errorMessage = "settings could not be found";
        } catch (IOException e) {
            jsonSettings = null;
            errorMessage = "An unexpected error occurred";
        } catch (JsonException e) {
            jsonSettings = null;
            errorMessage = "A parse error occurred, please make sure the json file is written properly";
        }

    }

    private void setDefaultSettings(){
        jsonSettings = new JsonObject();
        jsonSettings.put("language", MySettings.DEFAULT_STRINGS_NAME);
        jsonSettings.put("theme", MySettings.DEFAULT_THEME_NAME);
        jsonSettings.put("fps", MySettings.DEFAULT_FPS);
        jsonSettings.put("simulation_time", MySettings.DEFAULT_SIMULATION_TIME);
        jsonSettings.put("collisions", MySettings.DEFAULT_CHECK_COLLISIONS);

        jsonSettings.put("save_data", MySettings.DEFAULT_SAVE_DATA);
        jsonSettings.put("save_history_data", MySettings.DEFAULT_SAVE_HISTORY);
    }

}
