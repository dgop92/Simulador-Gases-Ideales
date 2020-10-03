package appcontrol.sketchs;

import appcontrol.SimulationWorkspace;

public class SketchFragment {
    
    private SimulationWorkspace sketch;
    protected float x;
    protected float y;
    protected float fragmentWidth;
    protected float fragmentHeight;

    public SketchFragment(SimulationWorkspace sketch, float x, float y, 
        float fragmentWidth, float fragmentHeight) {
            
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.fragmentWidth = fragmentWidth;
        this.fragmentHeight = fragmentHeight;
    }

    protected void draw(){
        
    }

}
