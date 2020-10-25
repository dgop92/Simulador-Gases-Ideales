package idealgas.transformations;

import idealgas.GasDataMap;
import idealgas.GasConstants;
import java.util.HashMap;

import processing.core.PApplet;

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

    protected float deltaT;
    protected float deltaV;
    protected float deltaVel;

    protected float velocity;

    protected HashMap<String, Float> finalData;
    protected HashMap<String, Float> gasData;

    public static final float MOLAR_MASS = 0.032f; 

    public BaseTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        this.pressure0 = initialData.get("pressure");
        this.volume0 = initialData.get("volume");
        this.temperature0 = initialData.get("temperature");
        this.nMoles = initialData.get("n") * GasDataMap.MOLES_PER_PARTICLE;

        this.finalData = finalData;

        //A 60FPS
        deltaT = 0.06491f;
        deltaV = 0.02091f; 
        deltaVel = 0.001f;

        initGasDataHashMap();
    }

    public static float getInitialFakeVelocity(float temperature){
        float initialVelocity = (float) Math.sqrt( 3 * GasConstants.R * temperature / MOLAR_MASS);
        return PApplet.map(initialVelocity, 
                           GasDataMap.MIN_REAL_VELOCITY, GasDataMap.MAX_REAL_VELOCITY, 
                           GasDataMap.MIN_FAKE_VELOCITY, GasDataMap.MAX_FAKE_VELOCITY);
    }
    
    private void initGasDataHashMap(){
        gasData = new HashMap<>();
        
        gasData.put("pressure", pressure0);
        gasData.put("volume", volume0);
        gasData.put("temperature", temperature0);

        gasData.put("work", work);
        gasData.put("heat", heat);
        gasData.put("internalEnergy", internalEnergy);

        gasData.put("velocity", velocity);

        gasData.put("deltaVel", deltaVel);
        gasData.put("fake_piston_height", GasDataMap.MIN_PISTON_HEIGHT);

        //moles and mass
    }

    protected void updateGasData(){
        gasData.replace("pressure", pressure);
        gasData.replace("volume", volume);
        gasData.replace("temperature", temperature);

        gasData.replace("work", work);
        gasData.replace("internalEnergy", internalEnergy);
        gasData.replace("heat", heat);

        gasData.replace("velocity", velocity);
 
        float fakePistonHeight = PApplet.map(volume, 
            GasDataMap.MIN_PROCESS_VOLUME, GasDataMap.MAX_PROCESS_VOLUME, 
            GasDataMap.MAX_PISTON_HEIGHT, GasDataMap.MIN_PISTON_HEIGHT);

        gasData.replace("deltaVel", deltaVel);
        gasData.replace("fake_piston_height", fakePistonHeight);

        //here you put fake vel and fake volume as well the real ones
    }

    protected void updateVelocity(float temperature){
        velocity = (float) Math.sqrt( 3 * GasConstants.R * temperature / MOLAR_MASS);
    }
    
    protected void saveData() {
        // This will save the data and create a csv file
    }
}
