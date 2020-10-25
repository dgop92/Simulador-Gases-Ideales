package idealgas.transformations;

import idealgas.GasConstants;
import idealgas.GasPVRange;

import java.util.HashMap;

public class IsothermalTransformation extends BaseTransformation implements TransformationStrategy {

    public IsothermalTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

        temperature = temperature0;

        pressure = pressure0;
        volume = volume0;

        setVolumeVelocityDeltaSign();

    }

    @Override
    public void updateData() {

        pressure = pressure0 * volume0 / volume;

        if (deltaV < 0) {
            work = nMoles * GasConstants.R * temperature0 * (float) Math.log(volume / volume0);
        } else {
            work = nMoles * GasConstants.R * temperature0 * (float) Math.log(volume0 / volume);
        }
        heat = work;

        volume += deltaV;

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
        return work > 0;
    }

    @Override
    public boolean isGasBeingCompressed() {
        return work < 0;
    }

    @Override
    public HashMap<String, Float> getData() {
        return gasData;
    }

    @Override
    public boolean IsTheTransformationFinished() {
        float finalPressure = finalData.get("pressure");
        float finalVolume = finalData.get("volume");

        if (deltaV <= 0) {
            // Volumen bajando, presion subiendo

            if (finalPressure != 0) {
                return pressure > finalPressure;
            }

            if (finalVolume != 0) {
                return volume < finalVolume;
            }

        } else {
            // Volumen subiendo, presion bajando

            if (finalPressure != 0) {
                return pressure < finalPressure;
            }

            if (finalVolume != 0) {
                return volume > finalVolume;
            }
        }

        return false;
    }

    private void setVolumeVelocityDeltaSign() {

        float finalVolume = finalData.get("volume");
        if (volume0 > finalVolume && finalVolume != 0) {
            deltaV *= -1;
        }

        float finalPressure = finalData.get("pressure");
        if (pressure0 < finalPressure && finalPressure != 0) {
            deltaV *= -1;
        }
        
        deltaVel = 0f;

    }

    @Override
    public GasPVRange getPVrange() {
        float finalPressure = finalData.get("pressure");
        float finalVolume = finalData.get("volume");

        float deltaPressure = 1000;
        float deltaVolume = 10;

        float minPressure, maxPressure, minVolume, maxVolume; 

        if (finalVolume != 0){
            minPressure = Math.min(pressure0, pressure0 * volume0 / finalVolume);
            maxPressure = Math.max(pressure0, pressure0 * volume0 / finalVolume);

            minVolume = Math.min(volume0, finalVolume);
            maxVolume = Math.max(volume0, finalVolume);
        }else{
            minVolume = Math.min(volume0, pressure0 * volume0 / finalPressure);
            maxVolume = Math.max(volume0, pressure0 * volume0 / finalPressure);

            minPressure = Math.min(pressure0, finalPressure);
            maxPressure = Math.max(pressure0, finalPressure);
        }

        GasPVRange gasPVRange = new GasPVRange(minPressure - deltaPressure, 
            maxPressure + deltaPressure, minVolume - deltaVolume, maxVolume + deltaVolume);

        return gasPVRange;
    }
    
}
