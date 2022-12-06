package aula8;

public class Car extends Vehicle {
	
	private int occupantsNumber;
	private int doorsNumber;

	public Car(String id, int vin, String brand, String model, String manufacturingDate, aula8.Vehicle.origin origin,
			int kms, aula8.Vehicle.condition condition, int price, int occupantsNumber, int doorsNumber) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
		this.occupantsNumber = occupantsNumber;
		this.doorsNumber = doorsNumber;
	}
	
	@Override
	public double getPrice() {
		if (getCondition() != condition.NEW) {
			return (getPrice()*0.7);
		}
		return getPrice();
	}

	public int getOccupantsNumber() {
		return occupantsNumber;
	}

	public void setOccupantsNumber(int occupantsNumber) {
		this.occupantsNumber = occupantsNumber;
	}

	public int getDoorsNumber() {
		return doorsNumber;
	}

	public void setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
	}

}
