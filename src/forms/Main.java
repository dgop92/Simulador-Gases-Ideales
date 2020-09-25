package forms;

public class Main {

    //Test here your code
    
    public static void main(String[] args) {
        
        //InitialDataForm initialDataForm = new InitialDataForm("0", "1", "10", "2");
        FinalDataForm finalDataForm = new FinalDataForm("", "", "123.5", TransformationType.ISOBARIC);
        System.out.println(finalDataForm.isDataValid());

        
        
        
    }


}
