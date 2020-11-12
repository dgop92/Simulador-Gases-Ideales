package idealgas.transformations;

import idealgas.GasConstants;
import idealgas.GasPVRange;

import java.util.HashMap;

public class IsovolumetricTransformation extends BaseTransformation implements TransformationStrategy {

    public IsovolumetricTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

        volume = volume0;

        pressure = pressure0;
        temperature = temperature0;

        setTemperatureVelocityDeltaSign();
    }

    @Override
    public void updateData() {

        pressure = pressure0 * temperature / temperature0;

        heat = nMoles * GasConstants.CVM * (temperature0 - temperature);
        internalEnergy = Math.abs(heat);

        temperature += deltaT;

        this.updateVelocity(temperature);
        this.updateGasData();
    }

    @Override
    public boolean isAbsorbingHeat() {
        return heat > 0;
    }

    @Override
    public boolean isLosingHeat() {
        return heat < 0;
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
        return gasData;
    }

    @Override
    public boolean IsTheTransformationFinished() {
        float finalTemperature = finalData.get("temperature");
        float finalPressure = finalData.get("pressure");

        if (deltaT <= 0) {
            // Temperatura bajando, presion tambien

            if (finalTemperature != 0) {
                return temperature < finalTemperature;
            }

            if (finalPressure != 0) {
                return pressure < finalPressure;
            }

        } else {
            // Temperatura subiendo, presion tambien

            if (finalTemperature != 0) {
                return temperature > finalTemperature;
            }

            if (finalPressure != 0) {
                return pressure > finalPressure;
            }
        }

        return false;
    }

    private void setTemperatureVelocityDeltaSign() {

        float finalTemperature = finalData.get("temperature");
        if (temperature0 > finalTemperature && finalTemperature != 0) {
            deltaT *= -1;
            deltaVel *= -1;
        }

        float finalPressure = finalData.get("pressure");
        if (pressure0 > finalPressure && finalPressure != 0) {
            deltaT *= -1;
            deltaVel *= -1;
        }

    }

    @Override
    public GasPVRange getPVrange() {

        float finalTemperature = finalData.get("temperature");
        float finalPressure = finalData.get("pressure");

        float deltaPressure = 1000;
        float deltaVolume = 10;

        float minPressure, maxPressure; 

        if (finalPressure != 0){
            minPressure = Math.min(pressure0, finalPressure);
            maxPressure = Math.max(pressure0, finalPressure);
        }else{
            minPressure = Math.min(pressure0, pressure0 * finalTemperature / temperature0);
            maxPressure = Math.max(pressure0, pressure0 * finalTemperature / temperature0);
        }

        GasPVRange gasPVRange = new GasPVRange(minPressure - deltaPressure, maxPressure + deltaPressure, 
            volume0 - deltaVolume, volume0 + deltaVolume);

        return gasPVRange;
    }
    
    
}
