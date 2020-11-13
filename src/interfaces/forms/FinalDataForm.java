package interfaces.forms;

import java.util.HashMap;

import idealgas.GasDataMap;
import idealgas.TransformationType;
import inevaup.resources.AppResources;
import inevaup.resources.R;

public class FinalDataForm extends DataForm {
    
    public String errorMessages;

    private String p2, v2, t2;
    private TransformationType transformationType;

    private boolean isDataValid;

    private boolean isPressureUsed, isVolumeUsed;

    private float finalPressure, finalVolume, finalTemperature;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;

        isDataValid = false;
        errorMessages = "";
    }

    public void validate() {

        try {
            validateTypesOfTransformation();
            validateData();
            validateRange();

            isDataValid = true;
        } catch (ValidationError e) {
            errorMessages = e.toString() + ".";
        }
    }

    public boolean isDataValid() {
        return isDataValid;
    }

    public HashMap<String, Float> getValidatedData(){
        HashMap<String, Float> data = new HashMap<>();
        data.put("pressure", finalPressure);
        data.put("volume", finalVolume);
        data.put("temperature", finalTemperature);
        return data;
    }

    private void validateTypesOfTransformation() throws ValidationError {

        switch (transformationType) {
            case ISOBARIC:

                if (!(isJustOneEmpty(v2, t2) && p2.isEmpty())) {
                    throw new ValidationError(
                        AppResources.getResources().getString(R.strings.fv_isobaric_input_error));
                }

                break;

            case ISOTHERMAL:

                if (!(isJustOneEmpty(v2, p2) && t2.isEmpty())) {
                    throw new ValidationError(
                        AppResources.getResources().getString(R.strings.fv_isothermal_input_error));
                }
                break;

            case ISOVOLUMETRIC:

                if (!(isJustOneEmpty(t2, p2) && v2.isEmpty())) {
                    throw new ValidationError(
                        AppResources.getResources().getString(R.strings.fv_isovolumetric_input_error));
                }
                break;

            case ADIABATIC:

                if (!isJustOneEmpty(t2, p2, v2)) {
                    throw new ValidationError(
                        AppResources.getResources().getString(R.strings.fv_adiabatic_input_error));
                }
                break;
        }

    }

    private void validateData() throws ValidationError {

        try {

            if (!p2.isEmpty()) {
                finalPressure = Float.parseFloat(p2);
                isPressureUsed = true;
            } else if (!v2.isEmpty()) {
                finalVolume = Float.parseFloat(v2);
                isVolumeUsed = true;
            } else {
                finalTemperature = Float.parseFloat(t2);
            }

        } catch (Exception e) {
            throw new ValidationError(AppResources.getResources().getString(R.strings.fv_invalid_data));
        }
    }

    //Este metodo debe ser remplazado por los rangos originales, ver clase GasDataMap.java
    private void validateRange() throws ValidationError{

        ValidationError vError = 
            new ValidationError(AppResources.getResources().getString(R.strings.fv_invalid_range));

        if(isPressureUsed){
            if (finalPressure < GasDataMap.MIN_USER_PRESSURE || finalPressure > GasDataMap.MAX_USER_PRESSURE){
                throw vError;
            }
        }else if(isVolumeUsed){
            if (finalVolume < GasDataMap.MIN_USER_VOLUME || finalVolume > GasDataMap.MAX_USER_VOLUME) {
                throw vError;
            }
        }else{
            if (finalTemperature < GasDataMap.MIN_USER_TEMPERATURE || finalTemperature > GasDataMap.MAX_USER_TEMPERATURE) {
                throw vError;
            }    
        }
    }

    private boolean isJustOneEmpty(String text1, String text2) {
        return text1.isEmpty() ^ text2.isEmpty();
    }

    private boolean isJustOneEmpty(String text1, String text2, String text3) {
        
        if (!text1.isEmpty() && !text2.isEmpty() && !text3.isEmpty()){
            return false;
        }

        return !(text1.isEmpty() ^ text2.isEmpty() ^ text3.isEmpty());
    }
}
