package forms;

public class FinalDataForm {
    
    private String p2, v2, t2;
    private TransformationType transformationType;

    public FinalDataForm(String p2, String v2, String t2, TransformationType transformationType) {
        this.p2 = p2;
        this.v2 = v2;
        this.t2 = t2;
        this.transformationType = transformationType;
        
    }

    //Example
    private void exampleOfEnum(){

        if(transformationType == TransformationType.ISOTHERMAL){
            //Do sth
        }
    }




}
