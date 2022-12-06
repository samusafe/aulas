package aula8;

public class Towhaul extends Trailer {
	
	public enum trailerType {
		TIPPER,
		OPEN,
		CLOSED,
		FRIDGE
	}
	
	private trailerType trailerType;

	public Towhaul(String id, int vin, String brand, String model, String manufacturingDate,
			aula8.Vehicle.origin origin, int kms, aula8.Vehicle.condition condition, int price, int lenght, int load,
			aula8.Truck.truckType truckType, boolean trailer, aula8.Towhaul.trailerType trailerType) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price, lenght, load, truckType, trailer, load, load);
		this.trailerType = trailerType;
	}

	public trailerType getTrailerType() {
		return trailerType;
	}

	public void setTrailerType(trailerType trailerType) {
		this.trailerType = trailerType;
	}

}
