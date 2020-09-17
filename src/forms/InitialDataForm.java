package forms;

public class InitialDataForm extends DataForm {

    private String p1, v1, t1;
    private String n;
    

    public InitialDataForm(String p1, String v1, String t1, String n) {
        this.p1 = p1;
        this.v1 = v1;
        this.t1 = t1;
        this.n = n;
        

        validate();
    }

    private void validate() {

        try {
            validateEmtytextfield();
            validateTransformation();
            validatenegative();
            // validation3();
            // validation4();

            // at the end isDataValid = true
        } catch (ValidationError e) {
            System.out.println(e);
        }
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
        if ( p1.isEmpty() ||  t1.isEmpty() ||  v1.isEmpty()) {
            throw new ValidationError("Valores invalidos");

        }
        
        

    }
    private void validatenegative() throws ValidationError{
        if (Float.parseFloat(v1)<0 || Float.parseFloat(t1)<0 || Float.parseFloat(p1)<0) {
            throw new ValidationError("Valores invalidos");

        }

    }
}
