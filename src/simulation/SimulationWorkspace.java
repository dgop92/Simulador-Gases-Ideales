package simulation;

import java.util.HashMap;

import idealgas.GasDataMap;
import idealgas.TransformationType;
import idealgas.datarecorder.CSVWritter;
import idealgas.transformations.BaseTransformation;
import idealgas.transformations.TransformationFactory;
import inevaup.preferences.AppSettings;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import processing.core.PApplet;
import processing.core.PFont;
import simulation.sketchs.Barometer;
import simulation.sketchs.Cylinder;
import simulation.sketchs.HeatSource;
import simulation.sketchs.PVGraph;
import simulation.sketchs.StatusBar;
import simulation.sketchs.Thermometer;

public class SimulationWorkspace extends PApplet{

    public static final int SKETCH_WIDTH = 800;
    public static final int SKETCH_HEIGHT = 650;

    private StatusBar statusBar;
    private Thermometer thermometer;
    private Barometer barometer;
    private PVGraph pvGraph;
    private HeatSource heatSource;
    private Cylinder cylinder;

    /* private CSVWritter csvWritter;
    private boolean saveCsvData; */

    private GasSubject gasSubject;

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
        
        int currentFps = Integer.valueOf(
            (String)AppSettings.getSettings().getSetting("fps")
        );
        if (currentFps != 0){
            frameRate(currentFps);
        }
        /* saveCsvData = (boolean)AppSettings.getSettings()
            .getSetting("save_data"); */

        gasSubject = new GasSubject();

        robotoFont = new PFont(
            AppResources.getResources().getFont(R.fonts.roboto_regular, 16), true);

        initSketch();
    }

    private void initSketch(){

        isRunning = false;
        isPaused = false;
        runErrorMessage = "";

        statusBar = new StatusBar(this, 0, 0, 600, 60);
        thermometer = new Thermometer(this, 600, 0, 200, 200);
        barometer = new Barometer(this, 600, 200, 200, 200);
        pvGraph = new PVGraph(this, 500, 400, 300, 250);
        cylinder = new Cylinder(this, 0, 60, 500, 480);
        heatSource = new HeatSource(this, 0, 540, 500, 650);

        gasSubject.register(statusBar);
        gasSubject.register(thermometer);
        gasSubject.register(barometer);
        gasSubject.register(pvGraph);
        gasSubject.register(cylinder);
        gasSubject.register(heatSource);

        // csvWritter = new CSVWritter();
    }

    @Override
    public void draw() {
        background(0);

        if (isRunning && !isPaused){
            gasSubject.updateGasData();

            statusBar.update();
            thermometer.update();
            barometer.update();
            pvGraph.update();

            cylinder.update();
            heatSource.update();

            isRunning = !gasSubject.IsTheTransformationFinished();

            /* if (saveCsvData){
                if (frameCount % 30 == 0) {
                    csvWritter.putRow(transformationStrategy.getData());
                }
    
                if(transformationStrategy.IsTheTransformationFinished()){
                    csvWritter.saveData();
                }
            } */

        }else{
            statusBar.draw();
            thermometer.draw();
            barometer.draw();
            pvGraph.draw();
            cylinder.draw();
            heatSource.draw();
        }

        drawSketchFragmentsDivisions();
    }

    public boolean requestStartOfSimulation(HashMap<String, Float> initialData,
        HashMap<String, Float> finalData, TransformationType transformationType){
        
        //Si no es la primera vez reseteamos los componentes
        if (gasSubject.isSimulationAlreadyStarted()){
            delay(600);
            resetSimulation();
        }

        gasSubject.setGasTransformation(
            new TransformationFactory(initialData, finalData), transformationType
        );
        
        if(isMaxParticleReached(
            initialData.get("n"), 
            gasSubject.getGasTransmoration().getPVrange().minVolume
        )
        ){
            return false;
        }
        
        pvGraph.setPVScale(gasSubject.getGasTransmoration().getPVrange());
        cylinder.fillCylinder(initialData.get("volume"), 
                              initialData.get("n").intValue(), 
                              BaseTransformation.getInitialFakeVelocity(initialData.get("temperature")));
        
        isRunning = true;
        return isRunning;
    }

    public void run() {
        String[] processingArgs = { SimulationWorkspace.class.getName() };
        PApplet.runSketch(processingArgs, this);
    }

    public boolean requestPauseResumeOfSimulation(){
        if (isRunning){
            isPaused = !isPaused;
            return true;
        }else{
            return false;
        }
    }

    private void resetSimulation(){
        noLoop();
        //reset csvWritter
        gasSubject.clearObservers();
        initSketch();
        loop();
    }

    private boolean isMaxParticleReached(float userParticles, float minVolume){
        
        float maxNumerOfParticles = map(minVolume, 
                                        GasDataMap.MIN_PROCESS_VOLUME, 
                                        GasDataMap.MAX_PROCESS_VOLUME, 
                                        GasDataMap.MIN_NUMBER_OF_PARTICLES, 
                                        GasDataMap.MAX_NUMBER_OF_PARTICLES);

        if (userParticles > maxNumerOfParticles){
            runErrorMessage = AppResources.getResources().getString(R.strings.sm_error_message) 
                +  (int)maxNumerOfParticles;
            return true;
        }
        
        return false;
    }

    private void drawSketchFragmentsDivisions(){
        thermometer.drawDivison();
        barometer.drawDivison();
        pvGraph.drawDivison();
    }

}
