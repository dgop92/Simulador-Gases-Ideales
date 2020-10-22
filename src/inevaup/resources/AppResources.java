package inevaup.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import inevaup.resources.R.colors;
import inevaup.resources.R.fonts;
import inevaup.resources.R.strings;

/**
 * Appresources carga y da acesso a los recursos usados por la app.  
 */
public class AppResources {

    private static AppResources appResources = null;

    private String errorMessage;
    private boolean areAllResourcesLoaded;

    private JsonObject stringsJsonObject;
    private JsonObject themeJsonObject;
    private HashMap<String, Font> customFonts;

    /**
     * Obtener la intancia de AppResources 
     * 
     * @return intancia de appResources 
     */
    public static AppResources getAppResources() {
        if (appResources == null) {
            appResources = new AppResources();
        }
        return appResources;
    }

    private AppResources() {

        errorMessage = "";
        areAllResourcesLoaded = false;

    }

    /**
     * Carga los recursos de la app 
     */
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

    /**
     * Obtener el mensaje de error si los recursos no se lograron cargar 
     * 
     * @return un String con la razon de porque los recursos no se cargaron 
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Verifica si los recursos están cargados.
     * 
     * @return true si los recursos se cargaron exitosamente- 
     */
    public boolean AreAllResourcesLoaded() {
        return areAllResourcesLoaded;
    }
  
    private void checkFoldersExistence() throws ResourceNotFoundException {

        String[] paths = { ResourcesPath.BASE_PATH, ResourcesPath.getFullImagesPath(),
                ResourcesPath.getFullImagesPath(), ResourcesPath.getFullSoundsPath(),
                ResourcesPath.getFullJsonResourcesPath(), ResourcesPath.getFullStringsPath(),
                ResourcesPath.getFullThemesPath(), ResourcesPath.getFullFontsPath(), };

        for (String resourcePath : paths) {
            if (!checkFileExistence(resourcePath)) {
                throw new ResourceNotFoundException(resourcePath);
            }
        }
    }
    
    private void loadStrings() throws ResourceNotLoadedException, ResourceNotFoundException {

        String stringsPath = ResourcesPath.getFullStringFilePath();

        try {
            FileReader stringsFile = new FileReader(stringsPath);
            stringsJsonObject = (JsonObject) Jsoner.deserialize(stringsFile);
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

        String themesPath = ResourcesPath.getFullThemesFilePath();

        try {
            FileReader themeFile = new FileReader(themesPath);
            themeJsonObject = (JsonObject) Jsoner.deserialize(themeFile);
            themeFile.close();
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException(themesPath);
        } catch (IOException e) {
            throw new ResourceNotLoadedException(themesPath);
        } catch (JsonException e) {
            throw new ResourceNotLoadedException(themesPath, "Couldn't parse the theme json file");
        }
    }

    private boolean checkFileExistence(String filePath) {
        return new File(filePath).exists();
    }
   
    private void loadFonts() throws ResourceNotLoadedException, ResourceNotFoundException {

        customFonts = new HashMap<>();

        for (String fontNamePath : ResourcesPath.FONT_NAMES_PATH) {
            String fullFontNamePath = ResourcesPath.getFullFontNamePath(fontNamePath);
            File fontFile = new File(fullFontNamePath);

            if (!fontFile.exists()) {
                throw new ResourceNotFoundException(fullFontNamePath);
            }

            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
                String javaFontName = ResourcesPath.fromFontNameToJavaName(fontNamePath);
                customFonts.put(javaFontName, font);
            } catch (FontFormatException | IOException e) {
                throw new ResourceNotLoadedException(fullFontNamePath, "Couldn't read the font");
            }

        }

    }

    // Note: Check the type of the object to avoid execptions

    /**
     * Metodo para acceder a los strings de la app 
     * 
     * @param key La llave del string a obtener
     * @return El string relacionado a la llave 
     */
    public String getString(strings key) {
        return (String) stringsJsonObject.getOrDefault((String) key.name(), "None");
    }

    /**
     * Metodo para acceder a los colores de la app 
     * 
     * @param colorKey la llave del color a obtener 
     * @return El color relacionado a la llave
     */
    public Color getColor(colors colorKey) {
        String hexColor = (String) themeJsonObject.getOrDefault((String) colorKey.name(), "#FFFFFF");
        try {
            return Color.decode(hexColor);
        } catch (NumberFormatException e) {
            return new Color(255, 0, 255);
        }
    }

    /**
     * Metodo para acceder a los iconos de la app 
     * 
     * @param iconName La llave del icono a obtener 
     * @return: El icono relacionado a la llave 
     */
    public ImageIcon getIcon(String iconName) {
        String iconPath = ResourcesPath.getConcatPath(ResourcesPath.getFullIconsPath(), iconName);
        return new ImageIcon(iconPath);
    }

    /**
     * Metodo para acceder a las imagenes de la app en java swing
     *  
     * @param imageName: La llave de la imagen a obtener.
     * @return: la imagen relacionado a la llave 
     */
    public ImageIcon getImage(String imageName) {
        String imagePath = ResourcesPath.getConcatPath(ResourcesPath.getFullImagesPath(), imageName);
        return new ImageIcon(imagePath);
    }

    /**
     * Metodo para acceder a las imagenes de la app en processing
     *  
     * @param imageName: La llave de la imagen a obtener.
     * @return: la ruta de la imagen relacionda a la llave 
     */
    public String getImageP(String imageName) {
        String imagesPath = ResourcesPath.getFullImagesPath();
        if (ResourcesPath.BASE_PATH.equals("data")){
            return ResourcesPath.getConcatPath(ResourcesPath.IMAGES_PATH, imageName);
        }else{
            return ResourcesPath.getConcatPath(imagesPath, imageName);
        }
    }

    /**
     * Metodo para acceder a los sonidos de la app en processing
     *  
     * @param soundName: La llave del sonido a obtener
     * @return: la ruta del sonido relacionda a la llave 
     */
    public String getSoundP(String soundName) {
        String soundsPath = ResourcesPath.getFullSoundsPath();
        String soundsPathReduceOneLevel = soundsPath.substring(soundsPath.indexOf('\\') + 1);
        String soundPath = ResourcesPath.getConcatPath(soundsPathReduceOneLevel, soundName);
        return soundPath;
    }

    /**
     * Metodo para acceder a las fuentes de la app 
     * 
     * @param fontName Nombre de la fuente
     * @param fontSize Tamaño de la fuente
     * @return La fuente relacionada al nombre
     */
    public Font getFont(fonts fontName, float fontSize) {
        Font baseFont = customFonts.getOrDefault(fontName.name(), new Font("Tahoma", Font.PLAIN, 16));
        return baseFont.deriveFont(fontSize);
    }

    /**
     * Metodo para acceder a las fuentes de la app 
     * 
     * @param fontName Nombre de la fuente
     * @param fontSize Tamaño de la fuente
     * @param fontStyle Estilo de la fuente
     * @return La fuente relacionada al nombre
     */
    public Font getFont(fonts fontName, float fontSize, int fontStyle) {
        Font baseFont = customFonts.getOrDefault(fontName.name(), new Font("Tahoma", Font.PLAIN, 16));
        return baseFont.deriveFont(fontStyle, fontSize);
    }


    public JsonObject getStringsJsonObject() {
        return stringsJsonObject;
    }

    public JsonObject getThemeJsonObject() {
        return themeJsonObject;
    }

    public HashMap<String, Font> getCustomFonts() {
        return customFonts;
    }
    
}
