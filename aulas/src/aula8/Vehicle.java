package aula8;

public class Vehicle {
	
	public enum origin {
		NATIONAL,
		IMPORTED
	}
	
	public enum condition {
		NEW,
		USED
	}
	
	private String id;
	private int vin;
	private String brand;
	private String model;
	private String manufacturingDate;
	private origin origin;
	private int kms;
	private condition condition;
	private double price;
	
	public Vehicle(String id, int vin, String brand, String model, String manufacturingDate, origin origin, int kms,
			condition condition, double price) {
		this.id = id;
		this.vin = vin;
		this.brand = brand;
		this.model = model;
		this.manufacturingDate = manufacturingDate;
		this.origin = origin;
		this.kms = kms;
		this.condition = condition;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public origin getOrigin() {
		return origin;
	}

	public void setOrigin(origin origin) {
		this.origin = origin;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}

	public condition getCondition() {
		return condition;
	}

	public void setCondition(condition condition) {
		this.condition = condition;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return id;
	}
	
}
