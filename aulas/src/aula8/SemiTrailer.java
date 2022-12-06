package aula8;

public class SemiTrailer extends Trailer {
	
	private int spareTyreNumber;

	public SemiTrailer(String id, int vin, String brand, String model, String manufacturingDate,
			aula8.Vehicle.origin origin, int kms, aula8.Vehicle.condition condition, int price, int lenght, int load,
			aula8.Truck.truckType truckType, boolean trailer, int spareTyreNumber) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price, lenght, load, truckType, trailer, spareTyreNumber, spareTyreNumber);
		this.spareTyreNumber = spareTyreNumber;
	}

	public int getSpareTyreNumber() {
		return spareTyreNumber;
	}

	public void setSpareTyreNumber(int spareTyreNumber) {
		this.spareTyreNumber = spareTyreNumber;
	}

}
