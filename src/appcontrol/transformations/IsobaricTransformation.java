package appcontrol.transformations;

import java.util.HashMap;

public class IsobaricTransformation extends BaseTransformation implements TransformationStrategy {

    public IsobaricTransformation(HashMap<String, Float> initialData) {
        super(initialData);
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
    
}
