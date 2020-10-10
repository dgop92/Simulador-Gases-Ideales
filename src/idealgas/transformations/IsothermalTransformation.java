package idealgas.transformations;

import idealgas.GasConstants;
import java.util.HashMap;

public class IsothermalTransformation extends BaseTransformation implements TransformationStrategy {

    public IsothermalTransformation(HashMap<String, Float> initialData, HashMap<String, Float> finalData) {
        super(initialData, finalData);

        temperature = temperature0;
        
        pressure = pressure0;
        volume = volume0;

        setVolumeDeltaSign();
        
    }

    @Override
    public void updateData() {

        pressure = pressure0 * volume0 / volume;

        if (deltaV < 0){
            work = nMoles * GasConstants.R * temperature0 * (float) Math.log(volume / volume0);
        }else{
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

        if (deltaV <= 0){
            // Volumen bajando, presion subiendo

            if (finalPressure != 0){
                return pressure > finalPressure;
            }

            if (finalVolume != 0){
                return volume < finalVolume;
            }

        }else{
            // Volumen subiendo, presion bajando

            if (finalPressure != 0){
                return pressure < finalPressure;
            }

            if (finalVolume != 0){
                return volume > finalVolume;
            }
        }

        return false;
    }

    private void setVolumeDeltaSign(){

        float finalVolume = finalData.get("volume");
        if (volume0 > finalVolume && finalVolume != 0){
            deltaV *= -1;
        }

        float finalPressure = finalData.get("pressure");
        if (pressure0 < finalPressure && finalPressure != 0){
            deltaV *= -1;
        }

    }
    
}
