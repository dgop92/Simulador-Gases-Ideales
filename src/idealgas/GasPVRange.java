package idealgas;

public class GasPVRange {
    
    public final float minPressure; 
    public final float maxPressure; 

    public final float minVolume; 
    public final float maxVolume;

    public GasPVRange(float minPressure, float maxPressure, 
                      float minVolume, float maxVolume) {
        
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

}
