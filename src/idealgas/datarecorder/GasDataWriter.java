package idealgas.datarecorder;
import java.util.HashMap;

public interface GasDataWriter {
    
    public void insertRecord(HashMap<String, Float> gasData);

    public boolean saveData();
}
