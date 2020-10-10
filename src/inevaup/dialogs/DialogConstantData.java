package inevaup.dialogs;

import java.awt.Font;
import java.awt.Color;
/**
 * Crea constantes para definir los colores de los diálogos, el fondo, el texto del título, el texto del contenido, y asocia las rutas de los iconos de cada diálogo. 
 */
public class DialogConstantData {

    //Info dialog
    public static Color INFO_DIALOG_COLOR = new Color(0, 98, 204);
    public static String INFO_DIALOG_ICON_PATH = "/icons/icons8-info-24.png";

    public static Color SUCCESS_DIALOG_COLOR = new Color(32, 134, 55);
    public static String SUCCESS_DIALOG_ICON_PATH = "/icons/icons8-ok-24.png";

    public static Color ERROR_DIALOG_COLOR = new Color(165, 29, 42);
    public static String ERROR_DIALOG_ICON_PATH = "/icons/icons8-cancel-white-24.png";

    //Warning dialog
    public static Color WARNING_DIALOG_COLOR = new Color(200, 150, 0);
    public static String WARNING_DIALOG_ICON_PATH = "/icons/icons8-warning-24.png";
    
    //Base Dialog 
    public static Font TITLE_FONT = new Font("Tahoma", Font.BOLD, 16);
    public static Font CONTENT_FONT = new Font("Tahoma", Font.PLAIN, 14);
    
    public static Color BACKGROUND_COLOR = new Color(247, 249, 249);
    public static Color FOREGROUND_COLOR = new Color(33, 33, 33);
    public static Color FOREGROUND_COLOR_2 = new Color(255, 255, 255);
    
}