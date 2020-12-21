package simulation;

import java.util.ArrayList;
import java.util.List;

import idealgas.TransformationType;
import idealgas.transformations.TransformationFactory;
import idealgas.transformations.TransformationStrategy;

public class GasSubject {
    
    private List<GasObserver> observers = new ArrayList<GasObserver>();
    private GasData gasData;

    public TransformationStrategy gasTransmoration;

    public GasSubject() {
        gasData = new GasData();
    }

    public void setGasTransformation(
        TransformationFactory transformationFactory,
        TransformationType transformationType){
        
        gasTransmoration = transformationFactory.
            createTransformation(transformationType);

    }

    public TransformationStrategy getGasTransmoration(){
        return gasTransmoration;
    }

    public boolean IsTheTransformationFinished(){
        return gasTransmoration.IsTheTransformationFinished();
    }

    public boolean isSimulationAlreadyStarted(){
        return gasTransmoration != null;
    }
    
    public void register(GasObserver observer) {
        observers.add(observer);
    }

    public void clearObservers(){
        observers.clear();
    }

    public void updateGasData(){
        gasTransmoration.updateData();

        gasData.setAbsorbingHeat(gasTransmoration.isAbsorbingHeat());
        gasData.setLosingHeat(gasTransmoration.isLosingHeat());
        gasData.setGasBeingCompressed(gasTransmoration.isGasBeingCompressed());
        gasData.setGasBeingExpanded(gasTransmoration.isGasBeingExpanded());

        gasData.setGasData(gasTransmoration.getData());

        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (GasObserver observer : observers) {
            observer.updateGasData(gasData);
        }
    }
}
