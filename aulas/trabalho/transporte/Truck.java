package transporte;

import java.util.ArrayList;
import enums.TruckState;

public class Truck {
	
	private int identificador;
	private int volume;
	private int peso;
	private TruckState truckState = TruckState.LOADING;
	public ArrayList<Box> caixas;
	
	public Truck(TruckState truckState, int volume, int peso, int identificador) {
		this.truckState = truckState;
		this.volume = volume;
		this.peso = peso;
		this.identificador = identificador;
		caixas = new ArrayList<>();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public TruckState getTruckState() {
		return truckState;
	}

	public void setTruckState(TruckState truckState) {
		this.truckState = truckState;
	}
	
	public ArrayList<Box> getCaixas() {
		return caixas;
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public boolean hasCaixas() {
		return caixas.size() > 0;
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
	
	public void takeBox(Box box) {
		for (int i = 0; i < caixas.size(); i++) {
			if (caixas.get(i).equals(box)) {
				caixas.remove(i);
			}
		}
	}
	
	public String toString() {
		return "Camiao " + (identificador + 1) + " -- " + getTruckState() + " -- " + caixas.size() + " caixas";
	}
}
