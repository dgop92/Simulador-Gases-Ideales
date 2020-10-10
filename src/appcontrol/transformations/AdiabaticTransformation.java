package appcontrol.transformations;

import java.util.HashMap;

public class AdiabaticTransformation extends BaseTransformation implements TransformationStrategy {

    public AdiabaticTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

        pressure = pressure0;
        volume = volume0;
        temperature = temperature0;

        setTemperatureDeltaSign();

    }

    @Override
    public void updateData() {

        volume = volume0 * (float) Math.pow(temperature0 / temperature, 1 / (GasConstants.Y_ADIABATIC - 1));
        pressure = pressure0 * (float) Math.pow(volume0 / volume, GasConstants.Y_ADIABATIC);

        work = (1 / (GasConstants.Y_ADIABATIC - 1)) * (pressure0 * volume0 - pressure0 * volume);
        internalEnergy = - work;

        temperature += deltaT;
        
        this.updateVelocity(temperature);
        this.updateGasData();
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

        float finalTemperature = finalData.get("temperature");
        float finalVolume = finalData.get("volume");
        float finalPressure = finalData.get("pressure");

        if (deltaT <= 0){
            // Temperatura bajando, volumen subiendo, presion bajando

            if (finalTemperature != 0){
                return temperature < finalTemperature;
            }else if (finalVolume != 0){
                return volume > finalVolume;
            }else{
                return pressure < finalPressure;
            }

        }else{
            // Temperatura subiendo, volumen bajando, presion subiendo

            if (finalTemperature != 0){
                return temperature > finalTemperature;
            }else if (finalVolume != 0){
                return volume < finalVolume;
            }else{
                return pressure > finalPressure;
            }
            
        }

    }

    private void setTemperatureDeltaSign(){

        float finalTemperature = finalData.get("temperature");
        if (temperature0 > finalTemperature && finalTemperature != 0){
            deltaT *= -1;
        }

        float finalVolume = finalData.get("volume");
        if (volume0 < finalVolume && finalVolume != 0){
            deltaT *= -1;
        }

        float finalPressure = finalData.get("pressure");
        if (pressure0 > finalPressure && finalPressure != 0){
            deltaT *= -1;
        }

    }
    
}
