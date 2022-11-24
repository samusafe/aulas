package transporte;

import java.util.ArrayList;

public class Truck {
	
	public enum truckState {
		LOADING,
		IN_TRANSIT,
		DELIVERED
	}
	
	private int volume;
	private truckState truckState;
	public ArrayList<Box> caixas;
	
	public Truck(truckState truckState, int volume) {
		this.truckState = truckState;
		this.volume = volume;
		caixas = new ArrayList<>();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public truckState getTruckState() {
		return truckState;
	}

	public void setTruckState(truckState truckState) {
		this.truckState = truckState;
	}
	
	public ArrayList<Box> getCaixas() {
		return caixas;
	}
	
	public void addBox(Box box) {
		for (int i = 0; i < caixas.size(); i++) {
			if (caixas.get(i).getTruck() == box.getTruck()) {
				caixas.set(i, box);
				return;
			}
		}
		caixas.add(box);
	}
	
	public boolean hasCaixas() {
		return caixas.size() > 0;
	}
}
