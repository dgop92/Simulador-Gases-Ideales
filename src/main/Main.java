package main;

import mainmenu.MainMenuInterface;
import resources.AppResources;

public class Main {

    public static void main(String[] args) {

        
        AppResources appResources = AppResources.getAppResources();
        appResources.loadResources();

        if (appResources.AreAllResourcesLoaded()) {
            MainMenuInterface mainMenuInterface = new MainMenuInterface();
            mainMenuInterface.setVisible(true);
        } else {
            System.out.println(appResources.getErrorMessage());
        }
        
    }
    
}
