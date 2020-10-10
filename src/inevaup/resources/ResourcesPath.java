package inevaup.resources;

import java.io.File;
/**
 * Crea constantes que almacena las rutas de cada recurso del programa en una String, para que estén todo el tiempo disponibles para este. 
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

    private final static String DEFAULT_STRINGS_NAME = "strings_es.json";
    private final static String DEFAULT_THEME_NAME = "default_theme.json";

    // ---------- Paths ----------- //
    /**
     * Obtiene la ruta de todas las imágenes usadas en el programa.
     * @return Devuelve la ruta de las imágenes isadas en el programa. 
     */
    public static String getFullImagesPath(){
        return getConcatPath(BASE_PATH, IMAGES_PATH);
    }
    /**
     * Obtiene las ruta de todos los íconos usados en el programa.
     * @return Devuelve la ruta de los íconos usados en el programa. 
     */
    public static String getFullIconsPath(){
        return getConcatPath(BASE_PATH, ICONS_PATH);
    }
    /**
     * Obtiene la ruta de todos los sonidos usados en el programa  programa.
     * @return Devuelve laruta de todos los sonidos usados en el programa.
     */
    public static String getFullSoundsPath() {
        return getConcatPath(BASE_PATH, SOUNDS_PATH);
    }
    /**
     * Obtiene la ruta de todos los recursos JSON usados en el programa. 
     * @return Devuelve la ruta de los recurso JSON usados en el programa. 
     */
    public static String getFullJsonResourcesPath() {
        return getConcatPath(BASE_PATH, JSON_RESOURCES_PATH);
    }
    /**
     * Obtiene la ruta de todos los recursos String usados en el programa.
     * @return Devuelve la ruta de todos los recursos String usados en el programa.
     */
    public static String getFullStringsPath() {
        return getConcatPath(BASE_PATH, STRINGS_PATH);
    }
    /**
     * Obtiene la ruta de todos los temas usados en el programa.
     * @return Devuelve la ruta de todos los temas usados en el programa.
     */
    public static String getFullThemesPath() {
        return getConcatPath(BASE_PATH, THEMES_PATH);
    }
    /**
     * Obtiene la ruta de todas las fuentes usadas en el programa.
     * @return Devuelve la ruta de todas las fuentes usdas en el programa.
     */
    public static String getFullFontsPath() {
        return getConcatPath(BASE_PATH, FONTS_PATH);
    }
    /**
     * Obtiene la ruta de los nombres de las fuentes usadas en el programa.
     * @param fontNamePath Nombre delas fuentes. 
     * @return Devuelve la ruta de los nombres de las fuentes usadas en el programa.
     */
    public static String getFullFontNamePath(String fontNamePath){
        return getConcatPath(getFullFontsPath(), fontNamePath);
    }
    /**
     * Obtiene la ruta del archivo de las Strings usados en el programa. 
     * @return Devuelve la ruta del archivos de las Strings usados en el programa.
     */
    public static String getFullStringFilePath() {
        return getConcatPath(getFullStringsPath(), DEFAULT_STRINGS_NAME);
    }
    /**
     * Obtiene la ruta del archivo de los temas usados en el programa.
     * @return Devuelve la ruta del archivo de los temas usados en el programa.
     */  
    public static String getFullThemesFilePath() {
        return getConcatPath(getFullThemesPath(), DEFAULT_THEME_NAME);
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
