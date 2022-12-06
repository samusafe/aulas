package aula8;

public class Bike extends Vehicle {
	
	private int cubicCapacity;
	private int wheelSize;

	public Bike(String id, int vin, String brand, String model, String manufacturingDate, aula8.Vehicle.origin origin,
			int kms, aula8.Vehicle.condition condition, int price, int cubicCapacity, int wheelSize) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
		this.cubicCapacity = cubicCapacity;
		this.wheelSize = wheelSize;
	}

	public int getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public int getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}

}
