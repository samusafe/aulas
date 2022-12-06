package aula8;

public class Trailer extends Truck {
	
	private int axesNumber;
	private int loadTrailer;

	public Trailer(String id, int vin, String brand, String model, String manufacturingDate,
			aula8.Vehicle.origin origin, int kms, aula8.Vehicle.condition condition, int price, int lenght, int load,
			aula8.Truck.truckType truckType, boolean trailer, int axesNumber, int loadTrailer) {
		super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price, lenght, load, truckType, trailer);
		this.axesNumber = axesNumber;
		this.loadTrailer = loadTrailer;
	}

	public int getAxesNumber() {
		return axesNumber;
	}

	public void setAxesNumber(int axesNumber) {
		this.axesNumber = axesNumber;
	}

	public int getLoadTrailer() {
		return loadTrailer;
	}

	public void setLoadTrailer(int loadTrailer) {
		this.loadTrailer = loadTrailer;
	}

}
