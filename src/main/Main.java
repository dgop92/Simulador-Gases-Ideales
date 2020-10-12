package main;

import interfaces.mainmenu.MainMenuInterface;
import inevaup.dialogs.InfoDialog;
import inevaup.dialogs.InfoDialog.TypeInfoDialog;
import inevaup.preferences.Settings;
import inevaup.resources.AppResources;

public class Main {

    public static void main(String[] args) {

        Settings settings = Settings.getSettings();
        settings.loadSettings();

        if (!settings.isSettingsLoaded){
            InfoDialog errInfoDialog = new InfoDialog(null, "Settings Error",
                settings.getErrorMessage(), TypeInfoDialog.ERROR_DIALOG);
            errInfoDialog.setVisible(true);
        }

        AppResources appResources = AppResources.getAppResources();
        appResources.loadResources();

        if (appResources.AreAllResourcesLoaded()) {
            MainMenuInterface mainMenuInterface = new MainMenuInterface();
            mainMenuInterface.setVisible(true);
        } else {
            InfoDialog errInfoDialog = new InfoDialog(null, "Resources Error",
                appResources.getErrorMessage(), TypeInfoDialog.ERROR_DIALOG);
            errInfoDialog.setVisible(true);
        }
        
    }
    
}
