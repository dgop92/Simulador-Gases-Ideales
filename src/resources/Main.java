package resources;

import java.util.Scanner;

//Json Simple dependency: https://cliftonlabs.github.io/json-simple/target/json-simple-3.1.1.jar

public class Main {
    
    public static void main(String[] args) {
        
        ResourcesLoader resourcesLoader = new ResourcesLoader();
        resourcesLoader.loadResources();

        if(resourcesLoader.AreAllResourcesLoaded()){
            System.out.println(AppResources.getString(R.strings.app_name));
            TestInterface testInterface = new TestInterface();
            testInterface.setVisible(true);
        }else{
            System.out.println(resourcesLoader.getErrorMessage());
        }

        /* Scanner sc = new Scanner(System.in);
        JsonResourceBuilder jsonResourceBuilder = new JsonResourceBuilder();
        System.out.println("1: Create String Json file, 2: Themes: ");
        System.out.print("Ingrese:   ");
        int option = sc.nextInt();
        if(option == 1){
            jsonResourceBuilder.createStringJson();
            System.out.println("Json String");
        }else if(option == 2){
            jsonResourceBuilder.createThemeJson();
            System.out.println("Json Theme");
        }else{
            System.out.println("Bye");
        }
        sc.close(); */

    }
}
