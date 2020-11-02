package interfaces.forms;

import java.util.HashMap;

import idealgas.GasDataMap;

public class InitialDataForm extends DataForm {

    private String p1, v1, t1;
    private String n;

    private boolean isDataValid;

    private float initialPressure, initialVolume, initialTemperature , initialn;

    public InitialDataForm(String p1, String v1, String t1, String n) {
        this.p1 = p1;
        this.v1 = v1;
        this.t1 = t1;
        this.n = n;

        isDataValid = false;

        validate();
    }

    private void validate() {

        try {
            validateEmtytextfield();
            validateTransformation();
            validaterange();
            validateWrongnumber();
            

            isDataValid = true;
        } catch (ValidationError e) {
            //System.out.println(e);
        }
    }


    public HashMap<String, Float> getValidatedData(){
        HashMap<String, Float> data = new HashMap<>();
        data.put("pressure", initialPressure);
        data.put("volume", initialVolume);
        data.put("temperature", initialTemperature);
        data.put("N",initialn);
        return data;
    }

    // Example
    private void validateTransformation() throws ValidationError {

        try {
            Float.parseFloat(v1);
            Float.parseFloat(t1);
            Float.parseFloat(p1);

        } catch (Exception e) {
            throw new ValidationError("Valores invalidos");
        }
    }

    private void validateEmtytextfield() throws ValidationError {
        if (p1.isEmpty() || t1.isEmpty() || v1.isEmpty() || n.isEmpty()) {
            throw new ValidationError("Por Favor ingrese los datos");

        }

    }

    private void validaterange() throws ValidationError {
        
        initialPressure= Float.parseFloat(p1);
        initialTemperature= Float.parseFloat(t1);
        initialVolume= Float.parseFloat(v1);
        initialn=Float.parseFloat(n);

        if (initialVolume< GasDataMap.MIN_USER_VOLUME || initialVolume > GasDataMap.MAX_USER_VOLUME ) {
            throw new ValidationError("Los datos no pueden pasar del rango establecido");
        }
        if(initialPressure < GasDataMap.MIN_USER_PRESSURE || initialPressure> GasDataMap.MAX_USER_PRESSURE){
            throw new ValidationError("Los datos no pueden pasar del rango establecido");
        }
        if(initialTemperature < GasDataMap.MIN_USER_TEMPERATURE || initialTemperature > GasDataMap.MAX_USER_TEMPERATURE){
            throw new ValidationError("Los datos no pueden pasar del rango establecido");
        }
        if(initialn <=0){
            throw new ValidationError("Valores invalidos");



        }


    }

    private void validateWrongnumber() throws ValidationError {
        try {
            Float.parseFloat(p1);
            Float.parseFloat(t1);
            Float.parseFloat(v1);

        } catch (Exception e) {
            throw new ValidationError("Valores invalidos");
        }

    }

    

    public boolean isDataValid() {
        return isDataValid;
    }
}
