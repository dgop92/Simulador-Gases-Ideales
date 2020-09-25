package tests;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import forms.InitialDataForm;
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
