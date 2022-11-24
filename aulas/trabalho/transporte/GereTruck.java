package transporte;

import java.util.ArrayList;

import transporte.Truck.truckState;

public class GereTruck {
	
	private ArrayList<Truck> trucks = new ArrayList<>();
	
	public boolean criarLocal(int volume) {
		Truck truck = new Truck(truckState.LOADING, volume);
		for (int i = 0; i < trucks.size(); i++) {
			if (truck.equals(trucks.get(i))) {
				return false;
			}
		}
		return trucks.add(truck);
	}
	
	public boolean hasTrucks() {
		return trucks.size() > 0;
	}
	
	public void addBox(String reference, int volume, int peso, Truck truck) {
		Box box = new Box(reference, volume, peso, truck);
		for (int i = 0; i < trucks.size(); i++) {
			if (truck.equals(trucks.get(i))) {
				trucks.get(i).addBox(box);
			}
		}
	}
}
