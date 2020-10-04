package appcontrol.transformations;

import java.util.HashMap;

public class IsobaricTransformation extends BaseTransformation implements TransformationStrategy {

    private float deltaT;

    public IsobaricTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData);

        pressure = pressure0;

        volume = volume0;
        temperature = temperature0;

        deltaT = 10;
    }

    @Override
    public void updateData() {
        volume = volume0*temperature / temperature0;

        work = pressure0 * (volume - volume0);
        

        temperature += deltaT; 
    }

    @Override
    public boolean isAbsorbingHeat() {
        return false;
    }

    @Override
    public boolean isLosingHeat() {
        return false;
    }

    @Override
    public boolean isGasBeingExpanded() {
        return false;
    }

    @Override
    public boolean isGasBeingCompressed() {
        return false;
    }

    @Override
    public HashMap<String, Float> getData() {
        return null;
    }
    
}
