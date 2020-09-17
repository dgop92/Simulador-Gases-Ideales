package forms;

public class FinalDataForm extends DataForm {

    private String p2, v2, t2;
    private TransformationType transformationType;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;
        validatef();

    }

    private void validatef() {

        try {
            validateEmtytextfieldf();
            transformation();
            
            validatenegativef();
            // validation4();

            // at the end isDataValid = true
        } catch (ValidationError e) {
            System.out.println(e);
        }
    }

    private void transformation() throws ValidationError {
        try {
            if (transformationType == TransformationType.ISOBARIC) {
                Float.parseFloat(v2);
                Float.parseFloat(t2);
            }
            if (transformationType == TransformationType.ISOVOLUMETRIC) {
                Float.parseFloat(p2);
                Float.parseFloat(t2);
            }
            if (transformationType == TransformationType.ISOTHERMAL) {
                Float.parseFloat(v2);
                Float.parseFloat(p2);
            }
            if (transformationType == TransformationType.ADIABATIC) {
                Float.parseFloat(v2);
                Float.parseFloat(t2);
                Float.parseFloat(p2);

            }

        } catch (Exception e) {

            throw new ValidationError("Valores invalidos");

        }

    }

    private void validateEmtytextfieldf() throws ValidationError {
        if (transformationType == TransformationType.ISOBARIC) {
            if (v2 == null || v2.isEmpty() || t2 == null || t2.isEmpty()) {
                throw new ValidationError("Valores invalidos");

            }
        if (transformationType == TransformationType.ISOVOLUMETRIC) {
            if (p2 == null || p2.isEmpty() || t2 == null || t2.isEmpty()) {
                throw new ValidationError("Valores invalidos");

                }
            }
        if (transformationType == TransformationType.ISOTHERMAL) {
            if (p2 == null || p2.isEmpty() || v2 == null || v2.isEmpty()) {
                throw new ValidationError("Valores invalidos");

                }
            }
        if (transformationType == TransformationType.ADIABATIC) {
            if (p2 == null || p2.isEmpty() || t2 == null || t2.isEmpty() || v2 == null || v2.isEmpty()) {
                throw new ValidationError("Valores invalidos");

                }
            }
        }
    }
    private void validatenegativef() throws ValidationError{
        if (transformationType == TransformationType.ISOBARIC) {
            if (Float.parseFloat(v2)< 0  || Float.parseFloat(t2) <0) {
                throw new ValidationError("Valores invalidos");

            }
        if (transformationType == TransformationType.ISOVOLUMETRIC) {
            if (Float.parseFloat(p2)< 0  || Float.parseFloat(t2) <0){
                throw new ValidationError("Valores invalidos");

                }
            }
        if (transformationType == TransformationType.ISOTHERMAL) {
            if (Float.parseFloat(v2)< 0  || Float.parseFloat(p2) <0){
                throw new ValidationError("Valores invalidos");

                }
            }
        if (transformationType == TransformationType.ADIABATIC) {
            if (Float.parseFloat(v2)< 0  || Float.parseFloat(t2) <0  || Float.parseFloat(p2)<0 ){
                throw new ValidationError("Valores invalidos");

                }
            }
        }

    }
}
