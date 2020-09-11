package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class ResourcesLoader {

    private String errorMessage;

    public ResourcesLoader() {
        errorMessage = "";
    }

    private void checkFoldersExistence() throws ResourceNotFoundException {

        String[] paths = { AppResources.BASE_PATH, AppResources.getFullImagesPath(), AppResources.getFullImagesPath(),
                AppResources.getFullSoundsPath(), AppResources.getFullJsonResourcesPath(),
                AppResources.getFullStringsPath(), AppResources.getFullThemesPath(), AppResources.getFullFontsPath(), };

        for (String resourcPath : paths) {
            if (checkFileExistence(resourcPath)) {
                throw new ResourceNotFoundException(resourcPath);
            }
        }
    }

    private void checkJsonResourcesExistence() throws ResourceNotFoundException {

        String[] filesPath = { AppResources.getFullStringFilePath(), AppResources.getFullThemesFilePath(), };

        for (String jsonResourcePath : filesPath) {
            if (checkFileExistence(jsonResourcePath)) {
                throw new ResourceNotFoundException(jsonResourcePath);
            }
        }
    }

    private boolean checkFileExistence(String filePath) {
        return new File(filePath).exists();
    }

    public void loadStrings() {

        try {
            FileReader stringsFile = new FileReader(AppResources.getFullStringFilePath());
            JsonObject stringsJsonObject = (JsonObject) Jsoner.deserialize(stringsFile);
            stringsFile.close();
        } catch (FileNotFoundException e) {
        
        } catch (IOException e) {
            
        } catch (JsonException e) {

        }
    }

    public void mytest(){
        //File f = new File(IMAGES_PATH);
        //f.mkdirs();
        //System.out.println(getClass().getResource(IMAGES_PATH));
        /* File f = new File(IMAGES_PATH + "/" + "bug.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        } */

    }
    
}
