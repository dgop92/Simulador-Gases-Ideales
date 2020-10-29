package idealgas.datarecorder;

import java.util.HashMap;

import idealgas.TransformationType;

public class HistoryItem {
    
    private HashMap<String, Float> initialData;
    private HashMap<String, Float> finalData;
    private TransformationType transformationType;

    private String date;

    public HistoryItem(HashMap<String, Float> initialData, HashMap<String, Float> finalData,
            TransformationType transformationType, String date) {
        this.initialData = initialData;
        this.finalData = finalData;
        this.transformationType = transformationType;
        this.date = date;
    }

    public HashMap<String, Float> getInitialData() {
        return initialData;
    }

    public HashMap<String, Float> getFinalData() {
        return finalData;
    }

    public TransformationType getTransformationType() {
        return transformationType;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString(){

        String initialDataString =  
            String.format("DI: ( %.2f %.2f %.2f - %.2f)", 
                          initialData.get("pressure"), 
                          initialData.get("volume"),
                          initialData.get("temperature"),
                          initialData.get("n"));
            
        String finalDataString = 
            String.format("DF: ( %.2f %.2f %.2f )", 
                          finalData.get("pressure"), 
                          finalData.get("volume"),
                          finalData.get("temperature"));
        
        String transformationTypeString = "T: " + transformationType.name();
        
        
        return String.format("<html> %s <br> %s <br> %s <br> %s </html>",
            date, initialDataString, finalDataString, transformationTypeString);
    }
}
