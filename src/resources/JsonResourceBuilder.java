package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import resources.R.colors;
import resources.R.strings;

public class JsonResourceBuilder {

    
    public JsonResourceBuilder() {

        createResourcesFolder();
    }

    private void createResourcesFolder() {
        
        File stringFolder = new File(AppResources.getFullStringsPath());
        File themesFolder = new File(AppResources.getFullThemesPath());

        stringFolder.mkdirs();
        themesFolder.mkdirs();
    }

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

    
    public void createStringJson(){

        String fileStringPath = AppResources.getFullStringFilePath();

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

    public void createThemeJson(){

        String fileThemePath = AppResources.getFullThemesFilePath();

        try {
            JsonObject themeJsonObject = getOldJsonObject(fileThemePath);
            FileWriter fileWriter = new FileWriter(fileThemePath);

            colors colorsKeys[] = colors.values();
            for (colors color : colorsKeys) {
                String colorName = color.name();
                if (!themeJsonObject.containsKey(colorName)){
                    themeJsonObject.put(colorName, "value");
                }
            }

            fileWriter.write(Jsoner.prettyPrint(themeJsonObject.toJson()));
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("An unexpected error occurred");
        } catch (Exception e){
            System.out.println(e);
        }

    }

}
