package idealgas.transformations;

import java.util.HashMap;

import idealgas.TransformationType;

public class TransformationFactory {

    private HashMap<String, Float> initialData;
    private HashMap<String, Float> finalData;

    public TransformationFactory(HashMap<String, Float> initialData, 
        HashMap<String, Float> finalData) {

        this.initialData = initialData;
        this.finalData = finalData;
    }
    
    public TransformationStrategy createTransformation(
        TransformationType transformationType){

        switch (transformationType) {
            case ISOBARIC:
                return new IsobaricTransformation(initialData, finalData);
            case ISOVOLUMETRIC:
                return new IsovolumetricTransformation(initialData, finalData);
            case ISOTHERMAL:
                return new IsothermalTransformation(initialData, finalData);
            case ADIABATIC:
                return new AdiabaticTransformation(initialData, finalData);
            default:
                return null;
        }

    }
}
