package transporte;

public class Box {
	
	private String reference;
	private int volume;
	private int peso;
	private Truck truck;
	
	public Box(String reference, int volume, int peso, Truck truck) {
		this.reference = reference;
		this.volume = volume;
		this.peso = peso;
		this.truck = truck;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
}
