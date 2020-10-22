package simulation.sketchs;

import simulation.SimulationWorkspace;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import processing.core.PImage;

public class HeatSource extends SketchFragment {


	private PImage fireUp;
    private PImage lowerFire; 
    private PImage flameImage;
    private PImage stones; 
    private float temperature;
    private boolean isLosingHeat;
    private boolean isAbsorbingHeat;

    public HeatSource(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
        fireUp = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.leftarrow));
        lowerFire = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.rightarrow));
        flameImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.hotsource)); 
        stones = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.stones)); 
    }
    
    @Override
    public void update() {
    drawStones();
    drawFlame();
    }
    public void draw() {
        if (isLosingHeat) {
            drawFlame();
            drawHeatLowerFireArrows();
        } else if (isAbsorbingHeat) {
            drawStones();
            drawHeatFireUpArrows();
        } else {
            drawStones(); 
        }
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void drawFlame() {
        sketch.image(flameImage,200, 540, 110, 110);    
    }
    public void drawStones() {
        sketch.image(stones,200,540,110,110);
    }
    
    public void drawHeatFireUpArrows() {
        sketch.image(fireUp, 160, 570,50,50);
    }
    public void drawHeatLowerFireArrows() {
        sketch.image(lowerFire, 300,570,50,50);
    }
    public void setLosingHeat(boolean b){
        isLosingHeat = b;
    }

    public void setAbsorbingHeat(boolean b){
        isAbsorbingHeat = b;
      
    }
   
}
