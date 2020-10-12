package simulation.sketchs;

import idealgas.GasDataMap;
import simulation.SimulationWorkspace;

public class PVGraph extends SketchFragment {

    private final float XY_BORDER_GAP = 30f;

    private final float X_AXIS_SIZE; 
    private final float Y_AXIS_SIZE;
    
    //Numero de lineas paralelas a su eje indicado
    private final int X_LINES; 
    private final int Y_LINES; 
    
    private final float XY_GRID_GAP = 20f;

    private final float X_SCALE_FACTOR; 
    private final float Y_SCALE_FACTOR;

    public PVGraph(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
        
        X_AXIS_SIZE = fragmentWidth - 2 * XY_BORDER_GAP;
        Y_AXIS_SIZE = fragmentHeight - 2 * XY_BORDER_GAP;
        
        X_LINES = Math.round(Y_AXIS_SIZE / XY_GRID_GAP);
        Y_LINES = Math.round(X_AXIS_SIZE / XY_GRID_GAP);
        
        X_SCALE_FACTOR = (GasDataMap.MAX_PROCESS_VOLUME - GasDataMap.MIN_PROCESS_VOLUME) / Y_LINES;
        //Y_SCALE_FACTOR = (GasDataMap.MAX_PROCESS_PRESSURE - GasDataMap.MIN_PROCESS_PRESSURE) / X_LINES;
        Y_SCALE_FACTOR = (GasDataMap.MAX_USER_PRESSURE - GasDataMap.MIN_USER_PRESSURE) / X_LINES;
        //System.out.println(X_SCALE_FACTOR + "  " + Y_SCALE_FACTOR);
    }

    @Override
    public void update() {
        draw();
    }

    public void draw(){
        drawAxes();
        drawGrid();
    }

    private void drawAxes() {
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
            
            sketch.text((int)(GasDataMap.MIN_PROCESS_VOLUME + (i - 1) * X_SCALE_FACTOR),
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

            sketch.text((int)(GasDataMap.MIN_USER_PRESSURE + i * Y_SCALE_FACTOR),
                        x + 2, 
                        startY - i * XY_GRID_GAP);

            sketch.line(x + XY_BORDER_GAP, 
                        startY - i * XY_GRID_GAP, 
                        x + fragmentWidth - XY_BORDER_GAP, 
                        startY - i * XY_GRID_GAP);
        }
        /* for (float i = y + fragmentHeight - XY_BORDER_GAP + XY_GRID_GAP; 
            i > y + XY_BORDER_GAP; 
            i -= XY_GRID_GAP) {
            
            sketch.line(x + XY_BORDER_GAP, i, x + fragmentWidth - XY_BORDER_GAP, i);
        } */
    }
    
    public void setPoint(float p, float v){
        sketch.stroke(0, 255, 0);
        sketch.strokeWeight(5);

        float xPoint = p * XY_GRID_GAP / Y_SCALE_FACTOR;
        float yPoint = v * XY_GRID_GAP / X_SCALE_FACTOR;

        //sketch.println(x + " "+ y);

        sketch.point(x + XY_BORDER_GAP + xPoint,
                     y + fragmentHeight - XY_BORDER_GAP + yPoint);
    }
}