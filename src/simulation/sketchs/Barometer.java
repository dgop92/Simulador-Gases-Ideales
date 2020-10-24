package simulation.sketchs;

import simulation.SimulationWorkspace;
import processing.core.PImage;
import inevaup.resources.AppResources;
import inevaup.resources.R;


public class Barometer extends SketchFragment {

    private float pressure;
    private PImage barometerImage;

    public Barometer(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        barometerImage= sketch.loadImage(AppResources.getAppResources().getImageP(R.images.barometro));

    }

    @Override
    public void update() {
        draw();
        
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void draw() {
        float transformation;
        float[] temp = new float[1] ;
        
        transformation=(pressure*40)/20000;
        if(pressure <temp[0]){
            transformation=-transformation;

        }

        temp[0]=pressure;
    
        sketch.image(barometerImage, 600,200);
        sketch.stroke(5);
        sketch.fill(132,0,0);
        sketch.line(700,300,700+transformation,250);
        sketch.textSize(10);
        sketch.textFont(sketch.robotoFont);
        sketch.fill(255,255,255);
        sketch.text(pressure + " Pa ",645,330);
        

    }
}
