package tests.forms;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import interfaces.forms.FinalDataForm;
import idealgas.TransformationType;
import junit.framework.TestCase;

public class TestFinalDataForm extends TestCase{
    
    private int NUMBER_OF_TEST = 50;

    @Test
    public void testInvalidEmptyData(){

        System.out.println("---  testInvalidEmptyData --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"a", "10", "5", "", "c", "..12", "h"};

        for (int n = 0; n < NUMBER_OF_TEST; n++) {

            shuffleParameterArray(parameters);
            TransformationType[] transformationTypes = getRandomTransformationType();

            System.out.println("Test: " + n + "  " + 
                Arrays.toString(parameters) + "  " + transformationTypes[0]);

            finalDataForm = new 
                FinalDataForm(parameters[0], parameters[1], parameters[2], transformationTypes[0]);
            finalDataForm.validate();
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }

    }

    @Test
    public void testWrongIsobaric(){

        System.out.println("---  testWrongIsobaric --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b", "", "", "40", "180"};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a", "100", "800", "", ""};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm("", parameters[i], parameters2[i], TransformationType.ISOBARIC);
            finalDataForm.validate();
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testWrongIsothermal(){

        System.out.println("---  testWrongIsothermal --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b", "50", "90000", "", ""};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a", "", "", "40", "180"};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm(parameters[i], parameters2[i], "", TransformationType.ISOTHERMAL);
            finalDataForm.validate();
            result = finalDataForm.isDataValid();
            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testWrongIsovolumetric(){

        System.out.println("---  testWrongIsovolumetric --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b", "", "", "50", "90000"};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a", "100", "800", "", ""};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm(parameters[i], "", parameters2[i], TransformationType.ISOTHERMAL);
            finalDataForm.validate();
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testWrongAdiabatic(){

        System.out.println("---  testWrongAdiabatic --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[][] listOfparameters = {
                                    {"a", "", ""},
                                    {"b", "8d.2", "c"},

                                    {"", "", ""},
                                    {"60000", "100", "800"},

                                    {"50", "", ""},
                                    {"80000", "", ""},

                                    {"", "4", ""},
                                    {"", "500", ""},

                                    {"", "", "100"},
                                    {"", "", "600.5"},
                                };

        int n = 1;
        for (String[] parameters: listOfparameters) {

            System.out.println("Test: " + n + "  " + Arrays.toString(parameters));
            finalDataForm = 
                new FinalDataForm(parameters[0], parameters[1], parameters[2], TransformationType.ADIABATIC);
            finalDataForm.validate();
            result = finalDataForm.isDataValid();
            assertEquals(expected, result);

            n ++;
        }
    }

    @Test
    public void testValidIsobaric(){ 

        System.out.println("---  testValidIsobaric --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "100", "", TransformationType.ISOBARIC);
        finalDataForm.validate();
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("", "", "293.5", TransformationType.ISOBARIC);
        finalDataForm.validate();
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }

    @Test
    public void testValidIsothermal(){ 

        System.out.println("---  testValidIsothermal --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "95", "", TransformationType.ISOTHERMAL);
        finalDataForm.validate();  
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("55030.523", "", "", TransformationType.ISOTHERMAL);
        finalDataForm.validate();    
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }

    @Test
    public void testValidIsovolumetric(){ 

        System.out.println("---  testValidIsovolumetric --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "", "343.5", TransformationType.ISOVOLUMETRIC);
        finalDataForm.validate();  
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("67000", "", "", TransformationType.ISOVOLUMETRIC);
        finalDataForm.validate();    
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }

    @Test
    public void testValidAdiabatic(){ 

        System.out.println("---  testValidAdiabatic --");

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "", "343.5", TransformationType.ADIABATIC);
        finalDataForm.validate();      
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("", "100.2", "", TransformationType.ADIABATIC);
        finalDataForm.validate();  
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("67000", "", "", TransformationType.ADIABATIC);
        finalDataForm.validate();    
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }
    
    private TransformationType[] getRandomTransformationType(){

        TransformationType[] transformationTypes = 
            {
                TransformationType.ISOVOLUMETRIC,
                TransformationType.ISOBARIC,
                TransformationType.ISOTHERMAL,
                TransformationType.ISOBARIC

            };
        
        Random rand = new Random();
        
        for (int i = 0; i < transformationTypes.length; i++) {
            int randomIndexToSwap = rand.nextInt(transformationTypes.length);
            TransformationType temp = transformationTypes[randomIndexToSwap];
            transformationTypes[randomIndexToSwap] = transformationTypes[i];
            transformationTypes[i] = temp;
        }

        return transformationTypes;
        
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
