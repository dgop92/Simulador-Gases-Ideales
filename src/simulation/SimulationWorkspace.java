package simulation;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.HashMap;

import simulation.sketchs.Barometer;
import simulation.sketchs.Cylinder;
import simulation.sketchs.HeatSource;
import simulation.sketchs.PVGraph;
import simulation.sketchs.StatusBar;
import simulation.sketchs.Thermometer;

import idealgas.transformations.AdiabaticTransformation;
import idealgas.transformations.IsobaricTransformation;
import idealgas.transformations.IsothermalTransformation;
import idealgas.transformations.IsovolumetricTransformation;
import idealgas.transformations.TransformationStrategy;

import inevaup.resources.AppResources;
import inevaup.resources.R;
import idealgas.GasDataMap;
import idealgas.TransformationType;

public class SimulationWorkspace extends PApplet{

    private final int SKETCH_WIDTH = 800;
    private final int SKETCH_HEIGHT = 650;

    private StatusBar statusBar;
    private Thermometer thermometer;
    private Barometer barometer;
    private PVGraph pvGraph;
    private HeatSource heatSource;
    private Cylinder cylinder;

    private TransformationStrategy transformationStrategy;

    public boolean isRunning;
    public boolean isPaused;

    public PFont robotoFont;

    public String runErrorMessage;

    @Override
    public void settings() {
        size(SKETCH_WIDTH, SKETCH_HEIGHT);
    }

    @Override
    public void setup() {
        //frameRate(60);

        robotoFont = new PFont(
            AppResources.getAppResources().getFont(R.fonts.roboto_regular, 16), true);

        isRunning = false;
        isPaused = false;
        runErrorMessage = "";

        statusBar = new StatusBar(this, 0, 0, 600, 60);
        thermometer = new Thermometer(this, 600, 0, 200, 200);
        barometer = new Barometer(this, 600, 200, 200, 200);
        pvGraph = new PVGraph(this, 500, 400, 300, 250);
        cylinder = new Cylinder(this, 0, 60, 500, 480);
        heatSource = new HeatSource(this, 0, 540, 500, 650);

    }

    @Override
    public void draw() {
        background(0);

        if (isRunning && !isPaused){
            transformationStrategy.updateData();

            statusBar.setData(transformationStrategy.getData());
            cylinder.setPistonHeight(transformationStrategy.getData().get("fake_piston_height"));

            thermometer.setTemperature(transformationStrategy.getData().get("temperature"));
            barometer.setPressure(transformationStrategy.getData().get("pressure"));

            heatSource.setTemperature(transformationStrategy.getData().get("temperature"));
            heatSource.setLosingHeat(transformationStrategy.isLosingHeat());
            heatSource.setAbsorbingHeat(transformationStrategy.isAbsorbingHeat());

            statusBar.update();
            thermometer.update();
            barometer.update();
            pvGraph.update();

            cylinder.update();
            heatSource.update();

            pvGraph.setPoint(transformationStrategy.getData().get("pressure"),
                             transformationStrategy.getData().get("volume"));

            isRunning = !transformationStrategy.IsTheTransformationFinished();
        }else{
            statusBar.draw();
            thermometer.draw();
            barometer.draw();
            pvGraph.draw();
            cylinder.draw();
            heatSource.draw();
            line(10, 10, 100, 10);
        }

        drawSketchFragmentsDivisions();
        // delay(10);
    }

    public boolean requestStartOfSimulation(HashMap<String, Float> initialData,
        HashMap<String, Float> finalData, TransformationType transformationType){

        switch (transformationType) {
            case ISOBARIC:
                transformationStrategy = new IsobaricTransformation(initialData, finalData);
                break;
            case ISOVOLUMETRIC:
                transformationStrategy = new IsovolumetricTransformation(initialData, finalData);
                break;
            case ISOTHERMAL:
                transformationStrategy = new IsothermalTransformation(initialData, finalData);
                break;
            case ADIABATIC:
                transformationStrategy = new AdiabaticTransformation(initialData, finalData);
                break;
        }
        
        if(isMaxParticleReached(initialData.get("n"), transformationStrategy.getPVrange().minVolume)){
            return false;
        }
        
        pvGraph.setPVScale(transformationStrategy.getPVrange());
        cylinder.fillCylinder(initialData.get("volume"), 
                              initialData.get("n").intValue(), 
                              GasDataMap.MIN_FAKE_VELOCITY);
        isRunning = true;
        return isRunning;
    }

    @Override
    public void mouseClicked() {
        super.mouseClicked();

        
        //cylinder.fillCylinder(GasDataMap.MIN_PROCESS_VOLUME, 25, 0.5f);
        //cylinder.fillCylinder(GasDataMap.MAX_USER_VOLUME, 25, 0.5f);
        cylinder.fillCylinder(GasDataMap.MAX_PROCESS_VOLUME, 80, 0.5f);
    }

    public void run() {
        String[] processingArgs = { SimulationWorkspace.class.getName() };
        PApplet.runSketch(processingArgs, this);
    }

    private boolean isMaxParticleReached(float userParticles, float minVolume){
        
        float maxNumerOfParticles = map(minVolume, 
                                        GasDataMap.MIN_PROCESS_VOLUME, 
                                        GasDataMap.MAX_PROCESS_VOLUME, 
                                        GasDataMap.MIN_NUMBER_OF_PARTICLES, 
                                        GasDataMap.MAX_NUMBER_OF_PARTICLES);

        if (userParticles > maxNumerOfParticles){
            runErrorMessage = "El maximo numero de particulas para esta simulacion es de " +  (int)maxNumerOfParticles;
            return true;
        }
        
        return false;
    }

    private void drawSketchFragmentsDivisions(){
        statusBar.drawDivison();
        thermometer.drawDivison();
        barometer.drawDivison();
        pvGraph.drawDivison();
        cylinder.drawDivison();
        heatSource.drawDivison();
    }

}
