package forms;

public class FinalDataForm extends DataForm {

    private String p2, v2, t2;
    private TransformationType transformationType;

    private boolean isDataValid;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;

        isDataValid = false;

        validatef();

    }

    private void validatef() {

        try {
            //validateEmtytextfieldf();
            //validatexor();
            //transformation();
            //validatenegativef();
            validateIsobaric();
            // validation4();
            
            isDataValid = true;
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

    private void validateIsobaric() throws ValidationError{

        if(transformationType == TransformationType.ISOBARIC){

            if(!((t2.isEmpty() ^ v2.isEmpty() ) && p2.isEmpty())){
                throw new ValidationError("Invalid data");
            }

        }

    }

    // TODO: Creo que ese es el condicional ( a.isEmpty() ^ b.isEmpty() ) && c.isEmpty()
    private void validatexor() throws ValidationError{
        if(transformationType == TransformationType.ISOBARIC){
            boolean data1= v2.isEmpty();
            boolean data2= t2.isEmpty();
            boolean data3= data1 ^ data2;
            if(data3 == false){
                throw new ValidationError("Ingresar solo un valor");


            }
            if((!v2.isEmpty() || !t2.isEmpty()) && (p2.isEmpty())){
                isDataValid = true;


            }

        }
        if (transformationType == TransformationType.ISOVOLUMETRIC) {
            boolean data1= t2.isEmpty();
            boolean data2= p2.isEmpty();
            boolean data3= data1 ^ data2;
            if(data3 == false){
                throw new ValidationError("Ingresar solo un valor");


            }
            if((!p2.isEmpty() || !t2.isEmpty()) && (v2.isEmpty())){
                isDataValid = true;


            }
            
        }
        if (transformationType == TransformationType.ISOTHERMAL) {
            boolean data1= v2.isEmpty();
            boolean data2= p2.isEmpty();
            boolean data3= data1 ^ data2;
            if(data3 == false){
                throw new ValidationError("Ingresar solo un valor");


            }
            if((!p2.isEmpty() || !v2.isEmpty()) && (t2.isEmpty())){
                isDataValid = true;


            }
        }
        if (transformationType == TransformationType.ADIABATIC) {
            boolean data1= v2.isEmpty();
            boolean data2= p2.isEmpty();
            boolean data3= t2.isEmpty();
            boolean data4= data1 ^ data2 ^ data3;
            if(data4 == false){
                throw new ValidationError("Ingresar solo un valor");


            }
            
        }


    }
    //this comment is for testing live shared extension
    public boolean isDataValid(){
        return isDataValid;
    }
}
