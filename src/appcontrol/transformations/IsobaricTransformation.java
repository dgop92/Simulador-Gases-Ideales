package appcontrol.transformations;

import java.util.HashMap;

public class IsobaricTransformation extends BaseTransformation implements TransformationStrategy {

    public IsobaricTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

        pressure = pressure0;

        volume = volume0;
        temperature = temperature0;

        setTemperatureDeltaSign();
    }

    @Override
    public void updateData() {
        volume = volume0*temperature / temperature0;

        work = pressure0 * (volume - volume0);
        internalEnergy = nMoles * GasConstants.CPM * (temperature0 - temperature);

        heat = internalEnergy + work;

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

        if (deltaT <= 0){
            // Temperatura bajando, volumen tambien

            if (finalTemperature != 0){
                return temperature < finalTemperature;
            }

            if (finalVolume != 0){
                return volume < finalVolume;
            }

        }else{
            // Temperatura subiendo, volumen subiendo

            if (finalTemperature != 0){
                return temperature > finalTemperature;
            }

            if (finalVolume != 0){
                return volume > finalVolume;
            }
        }

        return false;
    }

    private void setTemperatureDeltaSign(){

        float finalTemperature = finalData.get("temperature");
        if (temperature0 > finalTemperature && finalTemperature != 0){
            deltaT *= -1;
        }

        float finalVolume = finalData.get("volume");
        if (volume0 > finalVolume && finalVolume != 0){
            deltaT *= -1;
        }

    }
    
}
