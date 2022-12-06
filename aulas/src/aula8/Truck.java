package aula8;

public class Truck extends Vehicle {
	
	public enum truckType {
		TRUCK,
		TIR
	}
	
	private int lenght;
	private int load;
	private truckType truckType;
	private boolean trailer = false;

	public Truck(String id, int vin, String brand, String model, String manufacturingDate, aula8.Vehicle.origin origin,
			int kms, aula8.Vehicle.condition condition, int price, int lenght, int load, truckType truckType, boolean trailer) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
		this.lenght = lenght;
		this.load = load;
		this.truckType = truckType;
		this.trailer = trailer;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	public truckType getTruckType() {
		return truckType;
	}

	public void setTruckType(truckType truckType) {
		this.truckType = truckType;
	}

	public boolean isTrailer() {
		return trailer;
	}

	public void setTrailer(boolean trailer) {
		this.trailer = trailer;
	}

}
