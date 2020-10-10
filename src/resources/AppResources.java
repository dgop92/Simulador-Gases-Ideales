package resources;

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

import resources.R.colors;
import resources.R.fonts;
import resources.R.strings;
/**
 * 
 */
public class AppResources {

    private static AppResources appResources = null;

    private String errorMessage;
    private boolean areAllResourcesLoaded;

    private JsonObject stringsJsonObject;
    private JsonObject themeJsonObject;
    private HashMap<String, Font> customFonts;
    /**
     * 
     * @return
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
     * Controla las excepciones que se pueden presentar en la ejecución del programa. 
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
     * Genera un mensaje de error. 
     * @return Devuelve el mensaje de error. 
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    /**
     * Verifica si los recursos están cargados.
     * @return Devuelve los recursos cargados- 
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

    // ---------- Resources Getters ----------- //

    // Note: Check the type of the object to avoid execptions
    /**
     * Obtiene las strings de su ruta de acceso.
     * @param key String
     * @return Devuelve la string. 
     */
    public String getString(strings key) {
        return (String) stringsJsonObject.getOrDefault((String) key.name(), "None");
    }
    /**
     * Controla las excepciones que presenten los colores.
     * @param colorKey Valor del color. 
     * @return Devuelve el color decodificado o un nuevo color. 
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
     * Obtiene el ícono de su ruta de acceso. 
     * @param iconName: Parámetro del nombre del ícono.
     * @return: Devuelve la ruta del ícono. 
     */
    public ImageIcon getIcon(String iconName) {
        String iconPath = ResourcesPath.getConcatPath(ResourcesPath.getFullIconsPath(), iconName);
        return new ImageIcon(iconPath);
    }
    /**
     * Obtiene la imagen de su ruta de acceso 
     * @param imageName: Parámetro de la imagen.  
     * @return: Devuelve la ruta del ícono. 
     */
    public ImageIcon getImage(String imageName) {
        String imagePath = ResourcesPath.getConcatPath(ResourcesPath.getFullIconsPath(), imageName);
        return new ImageIcon(imagePath);
    }
    /**
     * 
     * @param fontName
     * @param fontSize
     * @return
     */
    public Font getFont(fonts fontName, float fontSize) {
        Font baseFont = customFonts.getOrDefault(fontName.name(), new Font("Tahoma", Font.PLAIN, 16));
        return baseFont.deriveFont(fontSize);
    }
    /**
     * Crea la base de las fuentes para el programa. 
     * @param fontName Parámetro del nombre de la fuente.
     * @param fontSize Parámetro del tamaño de la fuente.
     * @param fontStyle Párametro del estilo o tipo de fuente. 
     * @return Devuelve el estilo o tipo de la fuente y el tamaño de esta. 
     */
    public Font getFont(fonts fontName, float fontSize, int fontStyle) {
        Font baseFont = customFonts.getOrDefault(fontName.name(), new Font("Tahoma", Font.PLAIN, 16));
        return baseFont.deriveFont(fontStyle, fontSize);
    }
    /**
     * Obtiene las strings del programa.
     * @return Devuelve las strings.
     */
    public JsonObject getStringsJsonObject() {
        return stringsJsonObject;
    }
    /**
     * Obtiene los temas o colores del programa. 
     * @return Devuelve los colores o temas. 
     */
    public JsonObject getThemeJsonObject() {
        return themeJsonObject;
    }
    /**
     * Obtiene las fuentes custom del programa
     * @return Devuelve las fuentes customs. 
     */
    public HashMap<String, Font> getCustomFonts() {
        return customFonts;
    }
    
}
