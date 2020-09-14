package resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class ClassBuilder {

    private String className;
    private String packageName;
    private String classPath;

    private String generatedClassText;

    public ClassBuilder(String packageName, String className, String classPath) {
        this.className = className;
        this.classPath = classPath;
        this.packageName = packageName;

        generatedClassText = "";
    }

    public void generateClass(){

        try {
            generateText();
            writeTextToClass();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeTextToClass() throws IOException {

        FileWriter fileWriter = new FileWriter(classPath);
        fileWriter.write(generatedClassText);
        fileWriter.close();

    }

    private void generateText(){

        String comment = "// This class is auto generated";
        String base = 
            String.format("package %s;\n\n%s\n\npublic class %s {\n", packageName, comment , className);
        
        String stringEnum = createEnum("strings ", AppResources.stringsJsonObject.keySet());
        String colorEnum = createEnum("colors ", AppResources.themeJsonObject.keySet());
        String fontsEnum = createEnum("fonts", AppResources.customFonts.keySet());

        String imagesClass = createStaticResource("images", new File(AppResources.getFullImagesPath()));
        String iconsClass = createStaticResource("icons", new File(AppResources.getFullIconsPath()));
        String soundsClass = createStaticResource("sounds", new File(AppResources.getFullSoundsPath()));
        
        String close = "\n}"; 

        generatedClassText = 
            base + stringEnum + colorEnum + fontsEnum +
            imagesClass + iconsClass + soundsClass + close;

    }

    private String createEnum(String enumName, Set<String> keySet){

        String start = String.format("public enum %s {\n", enumName);
        String enumContent = "";

        String nextLine = ",\n";

        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            enumContent += keySetIterator.next();

            if (keySetIterator.hasNext()){
                enumContent += nextLine;
            }
        }

        String close = "\n}"; 
        
        return start + enumContent + close;
    }

    private String createStaticResource(String className, File resourceFile){

        String start = String.format("public static class %s {\n", className);
        String classContent = "";
        
        File[] resourcefiles = resourceFile.listFiles();
        for (File resourcefile : resourcefiles) {
            String fileName = fromFontNameToJavaName(resourcefile.getName());
            String filePath = "/" + resourcefile.getName();

            classContent += generateRField(fileName, filePath);
        }

        String close = "\n}";

        return start + classContent + close;
    }


    private String fromFontNameToJavaName(String fontName) {

        String fontNamePhase1 = fontName.toLowerCase().replace('-', '_');
        return fontNamePhase1.substring(0, fontNamePhase1.indexOf('.'));
    }

    private String generateRField(String name, String content){

        return String.format("public final static String %s = \"%s\";\n", name, content);
        
    }
    
    

}
