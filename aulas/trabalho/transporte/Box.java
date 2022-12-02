package transporte;

public class Box {
	
	private String reference;
	private int volume;
	private int peso;
	private int comprimento;
	private int altura;
	private int largura;
	private Truck truck;
	
	public Box(String reference, int volume, int peso, int comprimento, int altura, int largura, Truck truck) {
		this.reference = reference;
		this.volume = volume;
		this.peso = peso;
		this.comprimento = comprimento;
		this.altura = altura;
		this.largura = largura;
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
	
	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
}
