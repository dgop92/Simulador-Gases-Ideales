package idealgas.datarecorder;

import java.util.HashMap;

import idealgas.TransformationType;

public class HistoryItem {
    
    private final HashMap<String, Float> initialData;
    private final HashMap<String, Float> finalData;
    private final TransformationType transformationType;

    private final String date;

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
            String.format("DI: ( %.2f - %.2f - %.2f - %.2f)", 
                          initialData.get("volume"), 
                          initialData.get("temperature"),
                          initialData.get("pressure"),
                          initialData.get("n"));
            
        String finalDataString = 
            String.format("DF: ( %.2f - %.2f - %.2f )", 
                          finalData.get("volume"), 
                          finalData.get("temperature"),
                          finalData.get("pressure"));
        
        String transformationTypeString = "T: " + transformationType.name();
        
        
        return String.format("<html> %s <br> %s <br> %s <br> %s </html>",
            date, initialDataString, finalDataString, transformationTypeString);
    }
}
