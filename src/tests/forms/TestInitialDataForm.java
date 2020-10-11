package tests.forms;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import interfaces.forms.InitialDataForm;
import junit.framework.TestCase;

// Dependency: https://search.maven.org/remotecontent?filepath=junit/junit/4.13/junit-4.13.jar

public class TestInitialDataForm extends TestCase{

    private int NUMBER_OF_TEST = 50;
    
    @Test
    public void testInvalidEmptyData(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"a", "10", "5", "b", "c", "..12", "h"};
    
        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);

            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));

            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);
        }

    }

    @Test
    public void testNegativeNumbers(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"1.2", "-10", "-12", "5", "-6.7", "-90"};

        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));

            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);
            
        }
    }

    @Test
    public void testZeroNumber(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"0", "0", "19", "0", "23", "100"};

        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));

            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);
            
        }
    }

    @Test
    public void testWrongNumber(){

        //n can't be float

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"1.2", "9.3", "0.5", "9.8", "1.5", "10.5"};

        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));

            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);
            
        }
    }


    @Test
    public void testValidData(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = true;

        String[] parameters = {"100", "50", "5", "900"};

        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));

            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);
            
        }

    }

    @Test
    public void testInvalidRangeGasData(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = false;

        String[][] listOfparameters = {
                                {"60000", "50", "400", "10"},
                                {"60000", "200", "400", "10"},

                                {"60000", "100", "100", "10"},
                                {"60000", "100", "800", "10"},

                                {"10", "100", "350", "10"},
                                {"130000", "100", "350", "10"},
                                };
        int n = 1;
        for (String[] parameters: listOfparameters) {
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));
            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);

            n ++;
        }

    }

    @Test
    public void testValidRangeGasData(){

        InitialDataForm initialDataForm;
        boolean result;
        boolean expected = true;

        String[][] listOfparameters = {
                                {"60000", "95", "350", "10"},
                                {"58000", "110", "290", "10"},

                                {"65000.40", "290.67", "125.3", "10"},
                                {"54324.5", "380.15", "95.3", "10"},
                                };
        int n = 1;
        for (String[] parameters: listOfparameters) {
            
            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));
            initialDataForm = 
                new InitialDataForm(parameters[0], parameters[1], parameters[2], parameters[3]);
            
            result = initialDataForm.isDataValid();
            assertEquals(expected, result);

            n ++;
        }

    }
    

    private void shuffleParameterArray(String[] parameters){

        Random rand = new Random();

        for (int i = 0; i < parameters.length; i++) {
            int randomIndexToSwap = rand.nextInt(parameters.length);
            String temp = parameters[randomIndexToSwap];
            parameters[randomIndexToSwap] = parameters[i];
            parameters[i] = temp;
        }

    }

}
