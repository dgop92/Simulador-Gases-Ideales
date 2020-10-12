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

        statusBar = new StatusBar(this, 0, 0, 600, 60);
        thermometer = new Thermometer(this, 600, 0, 200, 200);
        barometer = new Barometer(this, 600, 200, 200, 200);
        pvGraph = new PVGraph(this, 500, 400, 300, 250);
        cylinder = new Cylinder(this, 0, 60, 500, 480);
        heatSource = new HeatSource(this, 0, 540, 500, 650);
        
        //cylinder.fillCylinder(55, 0.5f);
    }

    @Override
    public void draw() {
        background(0);
        
        if (isRunning && !isPaused){
            transformationStrategy.updateData();

            statusBar.setData(transformationStrategy.getData());
            cylinder.setVolume(transformationStrategy.getData().get("volume"));
            
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
            //cylinder.drawParticles();
            pvGraph.draw();
            line(10, 10, 100, 10);
        }

        drawSketchFragmentsDivisions();
    }

    public void startSimulation(){
        isRunning = true;
    }

    public void setGasTransformation(HashMap<String, Float> initialData, 
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
    }

    public void run() {
        String[] processingArgs = { SimulationWorkspace.class.getName() };
        PApplet.runSketch(processingArgs, this);
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
