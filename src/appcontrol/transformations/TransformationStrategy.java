package appcontrol.transformations;

import java.util.HashMap;

public interface TransformationStrategy {
    
    public void updateData();

    public boolean isAbsorbingHeat();

    public boolean isLosingHeat();

    public boolean isGasBeingExpanded();

    public boolean isGasBeingCompressed();

    public HashMap<String, Float> getData();
    
}
