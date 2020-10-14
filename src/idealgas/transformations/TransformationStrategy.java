package idealgas.transformations;

import java.util.HashMap;

import idealgas.GasPVRange;

public interface TransformationStrategy {
    
    public void updateData();

    public boolean isAbsorbingHeat();

    public boolean isLosingHeat();

    public boolean isGasBeingExpanded();

    public boolean isGasBeingCompressed();

    public HashMap<String, Float> getData();

    public boolean IsTheTransformationFinished();

    public GasPVRange getPVrange();
    
}
