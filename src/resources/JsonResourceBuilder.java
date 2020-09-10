package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import resources.R.strings;

public class JsonResourceBuilder {

    private final String STRINGS_FOLDER_PATH = "src/data/resources/strings";
    private final String THEMES_FOLDER_PATH = "src/data/resources/themes";

    private final String DEFAULT_STRINGS_NAME = "strings_es.json";
    private final String DEFAULT_THEME_NAME = "default_theme.json";

    public JsonResourceBuilder() {

        createResourcesFolder();
    }

    private void createResourcesFolder() {

        File stringFolder = new File(STRINGS_FOLDER_PATH);
        File themesFolder = new File(THEMES_FOLDER_PATH);

        stringFolder.mkdirs();
        themesFolder.mkdirs();
    }

    public void readStringEnum() {

        strings stringsData[] = strings.values();
        for (strings string : stringsData) {
            System.out.println(string);
        }
    }

    // strings stringsData[] = strings.values();

    public JsonObject getOldJsonObject(String resourcePath) throws Exception {

        JsonObject oldJsonObject;

        try {
            FileReader fileReader = new FileReader(resourcePath);
            oldJsonObject = (JsonObject) Jsoner.deserialize(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            oldJsonObject = new JsonObject();
        } catch (IOException e) {
            oldJsonObject = null;
            throw new Exception("An unexpected error occurred");
        } catch (JsonException e) {
            oldJsonObject = null;
            throw new Exception("A parse error occurred " + "please make sure the json file is written properly");
        }

        return oldJsonObject;

    }

    public void testOld() {
        String fileStringPath = STRINGS_FOLDER_PATH + "/" + DEFAULT_STRINGS_NAME;

        try {
            JsonObject stringJsonObject = getOldJsonObject(fileStringPath);
            System.out.println((String)stringJsonObject.get(R.strings.app_name.name()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createStringJson(){

        String fileStringPath = STRINGS_FOLDER_PATH + "/" + DEFAULT_STRINGS_NAME; 

        try {
            JsonObject stringJsonObject = getOldJsonObject(fileStringPath);
            FileWriter fileWriter = new FileWriter(fileStringPath);

            strings stringsKeys[] = strings.values();
            for (strings string : stringsKeys) {
                String stringKey = string.name();
                if (!stringJsonObject.containsKey(stringKey)){
                    stringJsonObject.put(stringKey, "value");
                }
            }
            //fileWriter.write(stringJsonObject.toJSONString());
            //stringJsonObject.toJson(fileWriter);
            fileWriter.write(Jsoner.prettyPrint(stringJsonObject.toJson()));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // log error as well
            System.out.println("An unexpected error occurred");
        } catch (Exception e){
            //log error as well
            System.out.println(e);
        }

    }

}
