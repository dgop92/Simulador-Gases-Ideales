package resources;

import java.io.File;

import resources.R.strings;

public class JsonResourceBuilder {
    
    private String STRINGS_FOLDER_PATH = "/data/resources/strings/";
    private String THEMES_FOLDER_PATH = "/data/resources/themes/";

    public JsonResourceBuilder() {
        
        readStringEnum();
    }

    private void readStringEnum(){

        strings stringsData[] = strings.values();
        for(strings string: stringsData) {
            System.out.println(string);
        } 
    }

    private boolean checkStringFolderExistence(){
        
        File stringFolder = new File(STRINGS_FOLDER_PATH);
        return stringFolder.exists();

    }
}
