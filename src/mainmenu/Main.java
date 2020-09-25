
package mainmenu;

import resources.AppResources;

public class Main {
    
    public static void main(String[] args) {

        //Run this class to run the mainmenu
        
        AppResources appResources = AppResources.getAppResources();
        appResources.loadResources();

        if(appResources.AreAllResourcesLoaded()){
            MainMenuInterface mainMenuInterface = new MainMenuInterface();
            mainMenuInterface.setVisible(true);
        }else{
            System.out.println(appResources.getErrorMessage());
        }

    }
}
