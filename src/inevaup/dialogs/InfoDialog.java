
package inevaup.dialogs;

import java.awt.Frame;

public class InfoDialog extends BaseDialog implements DialogActions{

    public enum TypeInfoDialog {
        INFO_DIALOG, SUCCESS_DIALOG, ERROR_DIALOG
    }
    
    private final String title; 
    private final String message;
    private final TypeInfoDialog type;
    
    public InfoDialog(Frame parent, String title, String message, TypeInfoDialog type) {
        super(parent, true);
        
        this.title = title; 
        this.message = message; 
        this.type = type; 
        
        initDialog();
    }
    
    private void initDialog(){
        
        this.setActionInterface(this);
        this.setDialogTitle(title);
        this.setDialogMessage(message);
        this.setCancelButtonVisibility(false);
    
        switch (type) {
            case INFO_DIALOG:
                initInfoDialog();
                break;
            case SUCCESS_DIALOG:
                initSuccessDialog();
                break;
            case ERROR_DIALOG:
                initErrorDialog();
                break;
            default:
                initInfoDialog();
        }
    }

    private void initInfoDialog(){
        this.setDialogIcon(DialogConstantData.INFO_DIALOG_ICON_PATH);
        this.setDialogHeaderColor(DialogConstantData.INFO_DIALOG_COLOR);
    }

    private void initSuccessDialog(){
        this.setDialogIcon(DialogConstantData.SUCCESS_DIALOG_ICON_PATH);
        this.setDialogHeaderColor(DialogConstantData.SUCCESS_DIALOG_COLOR);
    }

    private void initErrorDialog() {
        this.setDialogIcon(DialogConstantData.ERROR_DIALOG_ICON_PATH);
        this.setDialogHeaderColor(DialogConstantData.ERROR_DIALOG_COLOR);
    }

    @Override
    public void onAcceptAction() {
        this.dispose();
    }

    @Override
    public void onCacelAction() {
        this.dispose();
    }
    
    
}