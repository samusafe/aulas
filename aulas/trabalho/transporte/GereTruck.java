package transporte;

import java.util.ArrayList;

import transporte.Truck.truckState;

public class GereTruck {
	
	public ArrayList<Truck> trucks = new ArrayList<>();
	
	public boolean createTruck(int volume) {
		Truck truck = new Truck(truckState.LOADING, volume, trucks.size());
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

	public void addBox(String reference, int comprimento, int altura, int largura, int peso, Truck truck) {
		int volume = calculateBoxVolume(comprimento, altura, largura);
		Box box = new Box(reference, volume, comprimento, altura, largura, peso, truck);
		for (int i = 0; i < trucks.size(); i++) {
			if (truck.equals(trucks.get(i)) || (trucks.get(i).getVolume() + volume) <= trucks.get(i).getVolume()) {
				trucks.get(i).setVolume(trucks.get(i).getVolume() + volume);
				trucks.get(i).caixas.add(box);
			}
		}
	}
	
	public void takeBox(Truck truck, int box) {
		for (int i = 0; i < trucks.size(); i++) {
			if (truck.equals(trucks.get(i))) {
				trucks.get(i).caixas.remove(box);
			}
		}
	}
	
	public String calculateTruck(Truck truck) {
		int peso = 0;
		for (int i = 0; i < trucks.size(); i++) {
			peso += truck.caixas.get(i).getPeso();
		}
		return "|| Peso - " + peso + "\n|| Volume - " + truck.getVolume();
	}
	
	public int calculateBoxVolume(int comprimento, int altura, int largura) {
		int volume = comprimento * altura * largura;
		return volume;
	}
}
