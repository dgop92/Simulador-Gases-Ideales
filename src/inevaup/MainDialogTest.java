package inevaup;

import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;

public class MainDialogTest {
    
    public static void main(String[] args) {
        
        InfoDialog info = new InfoDialog(null, 
            "Mi Titulo", "This is a long message,", TypeInfoDialog.INFO_DIALOG);
        info.setVisible(true);

    }
}
