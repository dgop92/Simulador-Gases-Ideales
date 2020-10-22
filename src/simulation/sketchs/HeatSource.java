package simulation.sketchs;

import simulation.SimulationWorkspace;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import processing.core.PImage;

public class HeatSource extends SketchFragment {


	private PImage fireIcon;
    private PImage iceIcon; 
    private PImage flameImage;
    private PImage stones; 
    private float temperature;
    private boolean isLosingHeat;
    private boolean isAbsorbingHeat;

    public HeatSource(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);
        fireIcon = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.leftarrow));
        iceIcon = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.rightarrow));
        flameImage = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.hotsource)); 
        stones = sketch.loadImage(AppResources.getAppResources().getImageP(R.images.stones)); 
    }
    
    @Override
    public void update() {
        draw();
    }

    public void draw() {

        if (isLosingHeat) {
            //drawFlame();
            //drawHeatLowerFireArrows();
            //drawIceIcon();
            drawStones();
        } else if (isAbsorbingHeat) {
            drawStones();
            drawFlame();
            //drawFireIcon();
        } else {
            drawStones(); 
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void drawFlame() {
        sketch.image(flameImage, x + 200, y, 110, 110);    
    }

    public void drawStones() {
        sketch.image(stones, x + 200, y, 110, 110);
    }
    
    public void drawFireIcon() {
        sketch.image(fireIcon, x + 150, y + 30, 50, 50);
        sketch.image(fireIcon, x + 310, y + 30, 50, 50);
    }

    public void drawIceIcon() {
        //sketch.image(iceIcon, x + 300,570,50,50);
    }

    public void setLosingHeat(boolean b){
        isLosingHeat = b;
    }

    public void setAbsorbingHeat(boolean b){
        isAbsorbingHeat = b;
      
    }
   
}
