package interfaces.forms;

import java.util.HashMap;

import idealgas.GasDataMap;
import inevaup.resources.AppResources;
import inevaup.resources.R;

public class InitialDataForm extends DataForm {

    private String p1, v1, t1;
    private String n;
    
    public String error_messages;

    private boolean isDataValid;

    private float initialPressure, initialVolume, initialTemperature , initialn;

    public InitialDataForm(String p1, String v1, String t1, String n) {
        this.p1 = p1;
        this.v1 = v1;
        this.t1 = t1;
        this.n = n;

        isDataValid = false;

    }

    public void validate() {

        try {
            validateEmtytextfield();
            validateTransformation();
            validaterange();
            
            isDataValid = true;
        } catch (ValidationError e) {
            error_messages = e.toString();
        }
    }


    public HashMap<String, Float> getValidatedData(){
        HashMap<String, Float> data = new HashMap<>();
        data.put("pressure", initialPressure);
        data.put("volume", initialVolume);
        data.put("temperature", initialTemperature);
        data.put("n",initialn);
        return data;
    }

    // Example
    private void validateTransformation() throws ValidationError {

        try {
            Float.parseFloat(v1);
            Float.parseFloat(t1);
            Float.parseFloat(p1);

        } catch (Exception e) {
            throw new ValidationError(AppResources.getAppResources().getString(R.strings.iv_invalid_data));
        }
    }

    private void validateEmtytextfield() throws ValidationError {
        if (p1.isEmpty() || t1.isEmpty() || v1.isEmpty() || n.isEmpty()) {
            throw new ValidationError(AppResources.getAppResources().getString(R.strings.iv_empty_fields));

        }

    }

    private void validaterange() throws ValidationError {
        
        initialPressure= Float.parseFloat(p1);
        initialTemperature= Float.parseFloat(t1);
        initialVolume= Float.parseFloat(v1);
        initialn=Float.parseFloat(n);

        ValidationError vError = new ValidationError(AppResources.getAppResources().getString(R.strings.iv_invalid_range));

        if (initialVolume< GasDataMap.MIN_USER_VOLUME || initialVolume > GasDataMap.MAX_USER_VOLUME ) {
            throw vError;
        }
        if(initialPressure < GasDataMap.MIN_USER_PRESSURE || initialPressure> GasDataMap.MAX_USER_PRESSURE){
            throw vError;
        }
        if(initialTemperature < GasDataMap.MIN_USER_TEMPERATURE || initialTemperature > GasDataMap.MAX_USER_TEMPERATURE){
            throw vError;
        }
        if(initialn <= 0){
            throw new ValidationError(AppResources.getAppResources().getString(R.strings.iv_negative_particles));
        }

    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
