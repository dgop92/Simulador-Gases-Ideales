package forms;

public class FinalDataForm extends DataForm {

    private String p2, v2, t2;
    private TransformationType transformationType;

    private boolean isDataValid;

    private boolean isPressureUsed;
    private boolean isVolumeUsed;
    private boolean isTemperatureUsed;

    private float finalPressure, finalVolumen, finalTemperature;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;

        isDataValid = false;
 
        validate();
    }

    private void validate() {

        try {
            validateTypesOfTransformation();
            validateData();
            validateRange();

            isDataValid = true;
        } catch (ValidationError e) {
            System.out.println(e);
        }
    }

    private void validateTypesOfTransformation() throws ValidationError {

        switch (transformationType) {
            case ISOBARIC:

                if (!(isJustOneEmpty(v2, t2) && p2.isBlank())) {
                    throw new ValidationError("Wrong inputs");
                }

                break;

            case ISOTHERMAL:

                if (!(isJustOneEmpty(v2, p2) && t2.isBlank())) {
                    throw new ValidationError("Wrong inputs");
                }
                break;

            case ISOVOLUMETRIC:

                if (!(isJustOneEmpty(t2, p2) && v2.isBlank())) {
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

            if (!p2.isBlank()) {
                finalPressure = Float.parseFloat(p2);
                isPressureUsed = true;
            } else if (!v2.isBlank()) {
                finalVolumen = Float.parseFloat(v2);
                isVolumeUsed = true;
            } else {
                finalTemperature = Float.parseFloat(t2);
                isTemperatureUsed = true;
            }

        } catch (Exception e) {
            throw new ValidationError("Datos Invalidos");
        }
    }

    private void validateRange() throws ValidationError{
        if(isPressureUsed){
            if (finalPressure <= 0){
                throw new ValidationError("Rango Invalido");
            }
        }else if(isVolumeUsed){
            if (finalVolumen <= 0) {
                throw new ValidationError("Rango Invalido");
            }
        }else{
            if (finalTemperature <= 0) {
                throw new ValidationError("Rango Invalido");
            }    
        }
    }

    private boolean isJustOneEmpty(String text1, String text2) {
        return text1.isBlank() ^ text2.isBlank();
    }

    private boolean isJustOneEmpty(String text1, String text2, String text3) {
        return text1.isBlank() ^ text2.isBlank() ^ text3.isBlank();
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
