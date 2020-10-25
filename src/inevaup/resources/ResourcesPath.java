package inevaup.resources;

import java.io.File;

/**
 * Constantes que almacenan las rutas de cada recurso del programa
 */

public class ResourcesPath {
    
    public final static String BASE_PATH = "src/data";
    // public final static String BASE_PATH = "data";

    public final static String IMAGES_PATH = "/images";
    public final static String ICONS_PATH = "/icons";
    public final static String SOUNDS_PATH = "/sounds";
    public final static String JSON_RESOURCES_PATH = "/json_resources";
    public final static String STRINGS_PATH = "/json_resources/strings";
    public final static String THEMES_PATH = "/json_resources/themes";
    public final static String FONTS_PATH = "/fonts";

    /**
     * Constante que almacena en una String la ruta de las fuentes.
     */
    public final static String[] FONT_NAMES_PATH = {
        "/Roboto-Regular.ttf",
        "/Montserrat-Regular.ttf",
        "/Montserrat-Bold.ttf"
    };

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


    public static String getFullFontNamePath(String fontNamePath){
        return getConcatPath(getFullFontsPath(), fontNamePath);
    }

    /**
     * Concadena dos rutas: la ruta base y la ruta hija.
     * @param basePath Ruta base
     * @param childrenPath Ruta hija
     * @return Devuelve la ruta hija concadenada. 
     */
    public static String getConcatPath(String basePath, String childrenPath) {

        File baseFile = new File(basePath);
        File childrenFile = new File(baseFile, childrenPath);
        return childrenFile.getPath();

    }
    /**
     * Transforma el nombre de la fuente a un nombre que pueda ser leído por Java. 
     * @param fontName Nombre de la fuente 
     * @return Devuelve el nombre transformado en Java Ejemplo: Roboto-Regular convertida en roboto_regular. 
     */
    public static String fromFontNameToJavaName(String fontName){

        String fontNamePhase1 = fontName.toLowerCase().replace('-', '_');
        return fontNamePhase1.substring(1, fontNamePhase1.indexOf('.'));
    }
}
