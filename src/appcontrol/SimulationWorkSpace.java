package appcontrol;

import processing.core.PApplet;
import appcontrol.sketchs.Barometer;
import appcontrol.sketchs.Cylinder;
import appcontrol.sketchs.HeatSource;
import appcontrol.sketchs.PVGraph;
import appcontrol.sketchs.StatusBar;
import appcontrol.sketchs.Thermometer;

public class SimulationWorkspace extends PApplet{

    private final int SKETCH_WIDTH = 800;
    private final int SKETCH_HEIGHT = 650;

    private StatusBar statusBar;
    private Thermometer thermometer;
    private Barometer barometer;
    private PVGraph pvGraph;
    private HeatSource heatSource;
    private Cylinder cylinder;
    
    
    @Override
    public void settings() {
        size(SKETCH_WIDTH, SKETCH_HEIGHT);
    }

    @Override
    public void setup() {
        frameRate(60);
        initSketchFragments();
        initComponents();
    }

    @Override
    public void draw() {
        background(0);
        cylinder.update();
        drawSketchFragmentsDivisions();
    }

    @Override
    public void mouseDragged() {
        //cylinder.update();
    }

    
    public void run() {
        String[] processingArgs = { SimulationWorkspace.class.getName() };
        PApplet.runSketch(processingArgs, this);
    }
    
    private void initSketchFragments(){

        statusBar = new StatusBar(this, 0, 0, 600, 60);
        thermometer = new Thermometer(this, 600, 0, 200, 200);
        barometer = new Barometer(this, 600, 200, 200, 200);
        pvGraph = new PVGraph(this, 500, 400, 300, 250);
        cylinder = new Cylinder(this, 0, 60, 500, 480);
        heatSource = new HeatSource(this, 0, 540, 500, 650);
    }

    private void initComponents(){
        cylinder.fillCylinder(5, 0.5f);
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
