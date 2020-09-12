package resources;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;

import com.github.cliftonlabs.json_simple.JsonObject;

import resources.R.colors;
import resources.R.strings;

public class AppResources {
    
    public final static String BASE_PATH = "src/data";
    // public final static String BASE_PATH = "data";

    public final static String IMAGES_PATH = "/images";
    public final static String ICONS_PATH = "/icons";
    public final static String SOUNDS_PATH = "/sounds";
    public final static String JSON_RESOURCES_PATH = "/json_resources";
    public final static String STRINGS_PATH = "/json_resources/strings";
    public final static String THEMES_PATH = "/json_resources/themes";
    public final static String FONTS_PATH = "/fonts";

    private final static String DEFAULT_STRINGS_NAME = "strings_es.json";
    private final static String DEFAULT_THEME_NAME = "default_theme.json";

    public static JsonObject stringsJsonObject = null;
    public static JsonObject themeJsonObject = null;

    // ---------- Paths ----------- //

    public static String getFullImagesPath(){
        return getConcatPath(BASE_PATH, IMAGES_PATH);
    }

    public static String getFullIconsPath(){
        return getConcatPath(BASE_PATH, ICONS_PATH);
    }

    public static String getFullSoundsPath() {
        return getConcatPath(BASE_PATH, SOUNDS_PATH);
    }

    public static String getFullJsonResourcesPath() {
        return getConcatPath(BASE_PATH, JSON_RESOURCES_PATH);
    }

    public static String getFullStringsPath() {
        return getConcatPath(BASE_PATH, STRINGS_PATH);
    }

    public static String getFullThemesPath() {
        return getConcatPath(BASE_PATH, THEMES_PATH);
    }

    public static String getFullFontsPath() {
        return getConcatPath(BASE_PATH, FONTS_PATH);
    }

    public static String getFullStringFilePath() {
        return getConcatPath(getFullStringsPath(), DEFAULT_STRINGS_NAME);
    }
    
    public static String getFullThemesFilePath() {
        return getConcatPath(getFullThemesPath(), DEFAULT_THEME_NAME);
    }

    // ---------- Resources Getters ----------- //

    //Note: Check the type of the object to avoid execptions

    public static String getString(strings key){
        return (String)stringsJsonObject.getOrDefault((String) key.name(), "None");
    }

    public static Color getColor(colors colorKey) {
        String hexColor = (String)themeJsonObject.getOrDefault((String) colorKey.name(), "#FFFFFF");
        System.out.println(hexColor);
        try{
            return Color.decode(hexColor);
        }catch(NumberFormatException e){
            return new Color(255, 0, 255);
        }
    }

    public static ImageIcon getIcon(String iconName){
        String stringPath = getConcatPath(getFullIconsPath(), iconName);
        return new ImageIcon(stringPath);
    }

    public static String getConcatPath(String basePath, String childrenPath) {

        File baseFile = new File(basePath);
        File childrenFile = new File(baseFile, childrenPath);
        return childrenFile.getPath();

    }
}
