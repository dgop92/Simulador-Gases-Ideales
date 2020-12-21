package simulation.sketchs;

import simulation.GasData;
import simulation.GasObserver;
import simulation.SimulationWorkspace;
import processing.core.PImage;
import inevaup.resources.AppResources;
import inevaup.resources.R;

public class Thermometer extends SketchFragment implements GasObserver {

    private PImage thermotherImage;
    private float temperature;

    public Thermometer(SimulationWorkspace sketch, float x, float y, float fragmentWidth, float fragmentHeight) {
        super(sketch, x, y, fragmentWidth, fragmentHeight);

        thermotherImage = sketch.loadImage(AppResources.getResources().getImageP(R.images.temperatura2));
        sketch.noStroke();

    }

    @Override
    public void update() {
        draw();

    }

    @Override
    public void draw() {

        float transformation, tp = 5;
        transformation = (150 * temperature) / (600);
        tp = -transformation;
        if (temperature > 548) {
            transformation = (150 * 548) / (600);
            tp = -transformation;

        }

        sketch.image(thermotherImage, 630, 30);
        sketch.fill(139, 0, 0);
        sketch.noStroke();
        sketch.rect(685, 179, 12, tp);
        sketch.textSize(10);
        sketch.textFont(sketch.robotoFont);
        sketch.fill(255, 255, 255);

        sketch.text(temperature + " K ", 645, 195);

    }

    @Override
    public void updateGasData(GasData gasData) {
        this.temperature = gasData.getGasData().get("temperature");
    }
}
