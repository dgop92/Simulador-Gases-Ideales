package inevaup.dialogs;

import java.awt.Frame;
/**
 * 
 */
public class WarningDialog extends BaseDialog implements DialogActions{
    
    private final String title;
    private final String message;
    private boolean warningAccepted;
    /**
     * Construye e inicializa la ventana de diálogo de advertencia con su respectivo contenido.
     * @param parent:
     * @param title:
     * @param message: 
     */
    public WarningDialog(Frame parent, String title, String message) {
        super(parent, true);
        
        this.title = title; 
        this.message = message;
        warningAccepted = false;

        initDialog();
    }
   
    private void initDialog(){
        
        this.setActionInterface(this);
        this.setDialogTitle(title);
        this.setDialogMessage(message);

        this.setDialogIcon(DialogConstantData.WARNING_DIALOG_ICON_PATH);
        this.setDialogHeaderColor(DialogConstantData.WARNING_DIALOG_COLOR);
    }

    @Override
    public void onAcceptAction() {
        warningAccepted = true;
        this.dispose();
    }

    @Override
    public void onCacelAction() {
        this.dispose();
    }

    public boolean IsWarningAccepted(){
        return warningAccepted;
    }
}