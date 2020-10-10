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
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }

    }

    @Test
    public void testWrongIsobaric(){

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b"};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a"};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm("", parameters[i], parameters2[i], TransformationType.ISOBARIC);
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testWrongIsothermal(){

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b"};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a"};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm(parameters[i], parameters2[i], "", TransformationType.ISOTHERMAL);
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testWrongIsoVolumetric(){

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = false;

        String[] parameters = {"", "a", "", "0", "", "20", "-70", "", "b"};
        String[] parameters2 = {"", "", "a", "", "0", "30", "", "-10", "a"};
        
        for (int i = 0; i < parameters.length; i++) {

            System.out.println("Test: " + i + "  " + parameters[i] + " " + parameters2[i]);

            finalDataForm = new 
                FinalDataForm(parameters[i], "", parameters2[i], TransformationType.ISOTHERMAL);
            result = finalDataForm.isDataValid();

            assertEquals(expected, result);

        }
        

    }

    @Test
    public void testValidIsobaric(){ 

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "450", "", TransformationType.ISOBARIC);
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("", "", "123.5", TransformationType.ISOBARIC);
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }

    @Test
    public void testValidIsothermal(){ 

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "450", "", TransformationType.ISOTHERMAL);
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("123.5", "", "", TransformationType.ISOTHERMAL);
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);
    }

    @Test
    public void testValidIsovolumetric(){ 

        FinalDataForm finalDataForm;
        boolean result;
        boolean expected = true;

        finalDataForm = new 
            FinalDataForm("", "", "102", TransformationType.ISOVOLUMETRIC);
        result = finalDataForm.isDataValid();

        assertEquals(expected, result);

        finalDataForm = new 
            FinalDataForm("13.52", "", "", TransformationType.ISOVOLUMETRIC);
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
