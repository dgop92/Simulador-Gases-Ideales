package interfaces.forms;

import idealgas.TransformationType;

public class Main {

    //Test here your code
    
    public static void main(String[] args) {
        
        //InitialDataForm initialDataForm = new InitialDataForm("65000.40", "290.67", "125.3", "10");
        //initialDataForm.validate();
        FinalDataForm finalDataForm = new FinalDataForm("", "", "123.5", TransformationType.ADIABATIC);
        finalDataForm.validate();
        System.out.println(finalDataForm.isDataValid());

        
        
        
    }


}
