package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.awt.Font;
import java.awt.FontFormatException;

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
            loadFonts();
            
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

    // Check emptyness may help
    private void loadStrings() throws ResourceNotLoadedException, ResourceNotFoundException {

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

    private void loadTheme() throws ResourceNotLoadedException, ResourceNotFoundException {

        String themesPath = AppResources.getFullThemesFilePath();

        try {
            FileReader themeFile = new FileReader(themesPath);
            JsonObject themeJsonObject = (JsonObject) Jsoner.deserialize(themeFile);
            AppResources.themeJsonObject = themeJsonObject;
            themeFile.close();
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException(themesPath);
        } catch (IOException e) {
            throw new ResourceNotLoadedException(themesPath);
        } catch (JsonException e) {
            throw new ResourceNotLoadedException(themesPath, "Couldn't parse the theme json file");
        }
    }

    private void loadFonts() throws ResourceNotLoadedException, ResourceNotFoundException{

        HashMap<String, Font> customFonts = new HashMap<>();

        for (String fontNamePath: AppResources.FONT_NAMES_PATH){
            String fullFontNamePath = AppResources.getFullFontNamePath(fontNamePath);
            System.out.println(fullFontNamePath);
            File fontFile = new File(fullFontNamePath);

            if (!fontFile.exists()){
                throw new ResourceNotFoundException(fullFontNamePath);
            }

            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
                String javaFontName = fromFontNameToJavaName(fontNamePath);
                customFonts.put(javaFontName, font);
            } catch (FontFormatException | IOException e) {
                throw new ResourceNotLoadedException(fullFontNamePath, "Couldn't read the font");
            }

        }

        AppResources.customFonts = customFonts;

    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public boolean AreAllResourcesLoaded() {
        return areAllResourcesLoaded;
    }

    public String fromFontNameToJavaName(String fontName){

        String fontNamePhase1 = fontName.toLowerCase().replace('-', '_');
        return fontNamePhase1.substring(1, fontNamePhase1.indexOf('.'));
    }
}
