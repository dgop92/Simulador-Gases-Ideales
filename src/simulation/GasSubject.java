package simulation;

import java.util.ArrayList;
import java.util.List;

import idealgas.TransformationType;
import idealgas.datarecorder.GasDataWriter;
import idealgas.transformations.TransformationFactory;
import idealgas.transformations.TransformationStrategy;

public class GasSubject {
    
    private List<GasObserver> observers = new ArrayList<GasObserver>();
    private GasData gasData;

    public TransformationStrategy gasTransmoration;
    public GasDataWriter gasDataWriter;
    public boolean saveGasData;
    public int gasRecordCount = 0;

    public GasSubject() {
        gasData = new GasData();
    }

    public void setGasDataWriter(GasDataWriter gasDataWriter) {
        this.gasDataWriter = gasDataWriter;
        saveGasData = true;
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

        if (saveGasData){
            if (gasRecordCount == 30){
                gasDataWriter.insertRecord(gasTransmoration.getData());
            }
            if (gasTransmoration.IsTheTransformationFinished()){
                gasDataWriter.saveData();
            }
            gasRecordCount = 0;
        }

        gasRecordCount += 1;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (GasObserver observer : observers) {
            observer.updateGasData(gasData);
        }
    }

    public GasDataWriter getGasDataWriter() {
        return gasDataWriter;
    }
}
