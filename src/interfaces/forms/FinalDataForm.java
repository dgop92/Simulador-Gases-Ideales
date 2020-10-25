package interfaces.forms;

import java.util.HashMap;

import idealgas.TransformationType;

public class FinalDataForm extends DataForm {

    private String p2, v2, t2;
    private TransformationType transformationType;

    private boolean isDataValid;

    private boolean isPressureUsed, isVolumeUsed, isTemperatureUsed;

    private float finalPressure, finalVolume, finalTemperature;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;

        isDataValid = false;
 
        validate();
    }

    public void validate() {

        try {
            validateTypesOfTransformation();
            validateData();
            validateRange();

            isDataValid = true;
        } catch (ValidationError e) {
            //System.out.println(e);
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
                    throw new ValidationError("Wrong inputs");
                }

                break;

            case ISOTHERMAL:

                if (!(isJustOneEmpty(v2, p2) && t2.isEmpty())) {
                    throw new ValidationError("Wrong inputs");
                }
                break;

            case ISOVOLUMETRIC:

                if (!(isJustOneEmpty(t2, p2) && v2.isEmpty())) {
                    throw new ValidationError("Wrong inputs");
                }
                break;

            case ADIABATIC:

                if (!isJustOneEmpty(t2, p2, v2)) {
                    throw new ValidationError("Wrong inputs");
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
                isTemperatureUsed = true;
            }

        } catch (Exception e) {
            throw new ValidationError("Datos Invalidos");
        }
    }

    //Este metodo debe ser remplazado por los rangos originales, ver clase GasDataMap.java
    private void validateRange() throws ValidationError{
        if(isPressureUsed){
            if (finalPressure <= 0){
                throw new ValidationError("Rango Invalido");
            }
        }else if(isVolumeUsed){
            if (finalVolume <= 0) {
                throw new ValidationError("Rango Invalido");
            }
        }else{
            if (finalTemperature <= 0) {
                throw new ValidationError("Rango Invalido");
            }    
        }
    }

    private boolean isJustOneEmpty(String text1, String text2) {
        return text1.isEmpty() ^ text2.isEmpty();
    }

    private boolean isJustOneEmpty(String text1, String text2, String text3) {
        return !(text1.isEmpty() ^ text2.isEmpty() ^ text3.isEmpty());
    }
}
