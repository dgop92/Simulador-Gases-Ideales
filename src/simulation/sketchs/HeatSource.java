package simulation.sketchs;

import simulation.SimulationWorkspace;
import inevaup.resources.AppResources;
import inevaup.resources.R;
import processing.core.PImage;

public class HeatSource extends SketchFragment {


	private PImage fireIconLeft;
	private PImage fireIconRight;
    private PImage flameImage;
    private PImage stones; 
    private float temperature;
    private boolean isLosingHeat;
    private boolean isAbsorbingHeat;

    public HeatSource(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        fireIconLeft = sketch.loadImage(AppResources.getResources().getImageP(R.images.fire_icon_left));
        fireIconRight = sketch.loadImage(AppResources.getResources().getImageP(R.images.fire_icon_right));
        flameImage = sketch.loadImage(AppResources.getResources().getImageP(R.images.hotsource)); 
        stones = sketch.loadImage(AppResources.getResources().getImageP(R.images.stones)); 
    }
    
    @Override
    public void update() {
        draw();
    }

    public void draw() {

        if (isLosingHeat) {
            drawFireIcons();
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
    
    public void drawFireIcons() {
        sketch.image(fireIconLeft, x + 50, y + 5, 50, 50);
        sketch.image(fireIconRight, x + fragmentWidth - 100, y + 5, 50, 50);
    }

    public void setLosingHeat(boolean b){
        isLosingHeat = b;
    }

    public void setAbsorbingHeat(boolean b){
        isAbsorbingHeat = b;
      
    }
   
}
