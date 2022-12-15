package transporte;

import java.util.ArrayList;
import enums.TruckState;

public class GereTruck {
	
	public ArrayList<Truck> trucks = new ArrayList<>();
	
	public boolean createTruck(int volume, int peso) {
		Truck truck = new Truck(TruckState.LOADING, volume, peso, trucks.size());
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
	
	public int calculateTruck(Truck truck) {
		int peso = 0;
		for (int i = 0; i < trucks.size(); i++) {
			peso += truck.caixas.get(i).getPeso();
		}
		return peso;
	}
	
	public int calculateBoxVolume(int comprimento, int altura, int largura) {
		int volume = comprimento * altura * largura;
		return volume;
	}
	
	public ArrayList<Truck> filterByType(TruckState truckState) {
		ArrayList<Truck> trucksFiltrados = new ArrayList<>();
		for(Truck truck: trucks) {
			if (truck.getTruckState() == truckState)
				trucksFiltrados.add(truck);
		}
		return trucksFiltrados;
	}
}
