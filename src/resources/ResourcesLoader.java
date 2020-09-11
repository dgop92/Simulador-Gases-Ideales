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
    private boolean areAllResourcesLoaded;

    public ResourcesLoader() {

        errorMessage = "";
        areAllResourcesLoaded = false;

    }

    public void loadResources() {

        try {

            checkFoldersExistence();
            loadStrings();
            loadTheme();

            areAllResourcesLoaded = true;
        } catch (ResourceNotFoundException e) {
            errorMessage = e.toString();
        } catch (ResourceNotLoadedException e) {
            errorMessage = e.toString();
        }
    }

    private void checkFoldersExistence() throws ResourceNotFoundException {

        String[] paths = { 
            AppResources.BASE_PATH, 
            AppResources.getFullImagesPath(), 
            AppResources.getFullImagesPath(),
            AppResources.getFullSoundsPath(), 
            AppResources.getFullJsonResourcesPath(),
            AppResources.getFullStringsPath(), 
            AppResources.getFullThemesPath(), 
            AppResources.getFullFontsPath(),
        };

        for (String resourcePath : paths) {
            if (!checkFileExistence(resourcePath)) {
                throw new ResourceNotFoundException(resourcePath);
            }
        }
    }

    private boolean checkFileExistence(String filePath) {
        return new File(filePath).exists();
    }

    //Check emptyness may help
    public void loadStrings() throws ResourceNotLoadedException, ResourceNotFoundException{

        String stringsPath = AppResources.getFullStringFilePath();

        try {
            FileReader stringsFile = new FileReader(stringsPath);
            JsonObject stringsJsonObject = (JsonObject) Jsoner.deserialize(stringsFile);
            AppResources.stringsJsonObject = stringsJsonObject;
            stringsFile.close();
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException(stringsPath);
        } catch (IOException e) {
            throw new ResourceNotLoadedException(stringsPath, "");
        } catch (JsonException e) {
            throw new ResourceNotLoadedException(stringsPath, "Couldn't parse the string json file");
        }
    }

    public void loadTheme() throws ResourceNotLoadedException, ResourceNotFoundException{

        String themesPath = AppResources.getFullThemesFilePath();

        try {
            FileReader themeFile = new FileReader(themesPath);
            JsonObject themeJsonObject = (JsonObject) Jsoner.deserialize(themeFile);
            AppResources.themeJsonObject = themeJsonObject;
            themeFile.close();
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException(themesPath);
        } catch (IOException e) {
            throw new ResourceNotLoadedException(themesPath, "");
        } catch (JsonException e) {
            throw new ResourceNotLoadedException(themesPath, "Couldn't parse the theme json file");
        }
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public boolean AreAllResourcesLoaded() {
        return areAllResourcesLoaded;
    }

}
