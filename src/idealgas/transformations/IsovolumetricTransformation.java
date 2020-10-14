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

        setTemperatureDeltaSign();
    }

    @Override
    public void updateData() {

        pressure = pressure0 * temperature / temperature0;

        internalEnergy = nMoles * GasConstants.CVM * (temperature0 - temperature);
        heat = internalEnergy;

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

    private void setTemperatureDeltaSign() {

        float finalTemperature = finalData.get("temperature");
        if (temperature0 > finalTemperature && finalTemperature != 0) {
            deltaT *= -1;
        }

        float finalPressure = finalData.get("pressure");
        if (pressure0 > finalPressure && finalPressure != 0) {
            deltaT *= -1;
        }

    }

    @Override
    public GasPVRange getPVrange() {
        return null;
    }
    
    
}
