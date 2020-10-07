package appcontrol.transformations;

import java.util.HashMap;

public class AdiabaticTransformation extends BaseTransformation implements TransformationStrategy {

    public AdiabaticTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

    }

    @Override
    public void updateData() {

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

    @Override
    public boolean IsTheTransformationFinished() {
        return false;
    }

    
    
}
