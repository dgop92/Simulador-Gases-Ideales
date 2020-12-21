package simulation;

import java.util.HashMap;

public class GasData {
    
    private HashMap<String, Float> gasData;

    private boolean isAbsorbingHeat;

    private boolean isLosingHeat;

    private boolean isGasBeingExpanded;

    private boolean isGasBeingCompressed;

	public HashMap<String, Float> getGasData() {
		return gasData;
	}

	public void setGasData(HashMap<String, Float> gasData) {
		this.gasData = gasData;
	}

	public boolean isAbsorbingHeat() {
		return isAbsorbingHeat;
	}

	public void setAbsorbingHeat(boolean isAbsorbingHeat) {
		this.isAbsorbingHeat = isAbsorbingHeat;
	}

	public boolean isLosingHeat() {
		return isLosingHeat;
	}

	public void setLosingHeat(boolean isLosingHeat) {
		this.isLosingHeat = isLosingHeat;
	}

	public boolean isGasBeingExpanded() {
		return isGasBeingExpanded;
	}

	public void setGasBeingExpanded(boolean isGasBeingExpanded) {
		this.isGasBeingExpanded = isGasBeingExpanded;
	}

	public boolean isGasBeingCompressed() {
		return isGasBeingCompressed;
	}

	public void setGasBeingCompressed(boolean isGasBeingCompressed) {
		this.isGasBeingCompressed = isGasBeingCompressed;
	}

    
}
