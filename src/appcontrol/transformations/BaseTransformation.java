package appcontrol.transformations;

import java.util.HashMap;

import processing.core.PVector;

public abstract class BaseTransformation {
    
    protected float pressure0;
    protected float volume0;
    protected float temperature0;
    protected float nMoles;

    protected float pressure;
    protected float volume;
    protected float temperature;
    protected float heat;
    protected float internalEnergy;
    protected float work;

    protected PVector velocity;

    public BaseTransformation(HashMap<String, Float> initialData) {
        this.pressure0 = initialData.get("pressure");
        this.volume0 = initialData.get("volume");
        this.temperature0 = initialData.get("temperature");
        this.nMoles = initialData.get("n"); //Must be divided
    }

    protected PVector getVelocity(float temperature){
        return null;
    }

    protected void saveData() {
        // This will save the data and create a csv file
    }
}
