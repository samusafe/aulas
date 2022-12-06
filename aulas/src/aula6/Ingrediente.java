package aula6;

public class Ingrediente {
	
	public enum ingOrigin {
		ANIMAL,
		VEGETAL,
		MINERAL
	}
	
	private int code;
	private String nome;
	private ingOrigin ingOrigin;
	private float quantCal;
	
	public Ingrediente(int code, String nome, ingOrigin ingOrigin, int quantCal) {
		this.code = code;
		this.nome = nome;
		this.ingOrigin = ingOrigin;
		this.quantCal = quantCal;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ingOrigin getIngOrigin() {
		return ingOrigin;
	}

	public void setIngOrigin(ingOrigin ingOrigin) {
		this.ingOrigin = ingOrigin;
	}

	public float getQuantCal() {
		return quantCal;
	}

	public void setQuantCal(int quantCal) {
		this.quantCal = quantCal;
	}
	
	public String toString() {
		return "";
	}
}
