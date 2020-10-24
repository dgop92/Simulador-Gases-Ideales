package simulation.sketchs;

import idealgas.GasDataMap;
import idealgas.GasPVRange;
import simulation.SimulationWorkspace;
import processing.core.PVector;

import java.util.Iterator;
import java.util.Vector;

public class PVGraph extends SketchFragment {

    private final float XY_BORDER_GAP = 30f;

    private final float X_AXIS_SIZE; 
    private final float Y_AXIS_SIZE;
    
    //Numero de lineas paralelas a su eje indicado
    private final int X_LINES; 
    private final int Y_LINES; 
    
    private final float XY_GRID_GAP = 20f;

    private float xScaleFactor; 
    private float yScaleFactor;

    private Vector<PVector> points;
    
    private GasPVRange gasPVRange;

    public PVGraph(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
        
        X_AXIS_SIZE = fragmentWidth - 2 * XY_BORDER_GAP;
        Y_AXIS_SIZE = fragmentHeight - 2 * XY_BORDER_GAP;
        
        // Numero de lineas paralelas a su eje
        X_LINES = Math.round(Y_AXIS_SIZE / XY_GRID_GAP);
        Y_LINES = Math.round(X_AXIS_SIZE / XY_GRID_GAP);

        gasPVRange = new GasPVRange(GasDataMap.MIN_USER_PRESSURE, 
                                    GasDataMap.MAX_USER_PRESSURE, 
                                    GasDataMap.MIN_PROCESS_VOLUME, 
                                    GasDataMap.MAX_PROCESS_VOLUME);
        setPVScale(gasPVRange);

        points = new Vector<>();
    }

    @Override
    public void update() {
        draw();
    }

    public void draw(){
        drawAxes();
        drawGrid();
        drawPoints();
    }

    public void setPVScale(GasPVRange gasPVRange){

        //Escala de los valores de la grafica
        xScaleFactor = (gasPVRange.maxVolume - gasPVRange.minVolume) / Y_LINES;
        yScaleFactor = (gasPVRange.maxPressure - gasPVRange.minPressure) / X_LINES;
        
        this.gasPVRange = gasPVRange;

    }

    private void drawAxes() {
        sketch.fill(255);
        sketch.strokeWeight(4);
        sketch.stroke(255);
        sketch.textFont(sketch.robotoFont, 18);

        sketch.text("P", 
                    x + XY_BORDER_GAP - 4, 
                    y + XY_BORDER_GAP - 10);

        sketch.line(x + XY_BORDER_GAP, 
                    y + XY_BORDER_GAP, 
                    x + XY_BORDER_GAP, 
                    y + fragmentHeight - XY_BORDER_GAP);

        sketch.text("V", 
                    x + fragmentWidth - XY_BORDER_GAP + 10, 
                    y + fragmentHeight - XY_BORDER_GAP + 5);

        sketch.line(x + XY_BORDER_GAP, 
                    y + fragmentHeight - XY_BORDER_GAP, 
                    x + fragmentWidth - XY_BORDER_GAP, 
                    y + fragmentHeight - XY_BORDER_GAP);
        
    }

    private void drawGrid(){

        sketch.strokeWeight(1);
        sketch.stroke(200);
        sketch.textFont(sketch.robotoFont, 8);

        //Y Parallel lines
        float startX = x + XY_BORDER_GAP;
        for (int i = 1; i <= Y_LINES; i++) {
            
            sketch.text((int)(gasPVRange.minVolume + (i - 1) * xScaleFactor),
                        startX + (i - 1) * XY_GRID_GAP, 
                        y + fragmentHeight - XY_BORDER_GAP + 10);
            sketch.line(startX + i * XY_GRID_GAP, 
                        y + XY_BORDER_GAP, 
                        startX + i * XY_GRID_GAP, 
                        y + fragmentHeight - XY_BORDER_GAP);
            
        }
    
        //X Parallel lines
        float startY = y + fragmentHeight - XY_BORDER_GAP;
        for (int i = 0; i < X_LINES; i++) {

            sketch.text((int)(gasPVRange.minPressure + i * yScaleFactor),
                        x + 2, 
                        startY - i * XY_GRID_GAP);

            sketch.line(x + XY_BORDER_GAP, 
                        startY - i * XY_GRID_GAP, 
                        x + fragmentWidth - XY_BORDER_GAP, 
                        startY - i * XY_GRID_GAP);
        }

    }

    public void drawPoints(){

        sketch.stroke(0, 255, 0);
        sketch.strokeWeight(2);

        Iterator<PVector> pointsIterator =  points.iterator();
        while (pointsIterator.hasNext()) {
            PVector position = pointsIterator.next();
            sketch.point(position.x, position.y);
        }
    }
    
    public void setPoint(float p, float v){
        float xPoint = (v - gasPVRange.minVolume) * XY_GRID_GAP / xScaleFactor;
        float yPoint = (p - gasPVRange.minPressure) * XY_GRID_GAP / yScaleFactor;

        points.add(new PVector(x + XY_BORDER_GAP + xPoint,
                               y + fragmentHeight - XY_BORDER_GAP - yPoint));

    }
}