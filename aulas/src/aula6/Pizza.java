package aula6;

import java.util.ArrayList;

public class Pizza {
	
	public enum pizzaSize {
		PEQUENA,
		MEDIA,
		FAMILIAR
	}
	
	private int code;
	private String nome;
	private String desc;
	private float price;
	private pizzaSize size;
	private int quantIng;
	public ArrayList<Ingrediente> ingredientes;
	
	public Pizza(int code, String nome, String desc, float price, pizzaSize size, int quantIng) {
		this.code = code;
		this.nome = nome;
		this.desc = desc;
		this.price = price;
		this.size = size;
		this.quantIng = quantIng;
		ingredientes = new ArrayList<>();
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public pizzaSize getSize() {
		return size;
	}

	public void setSize(pizzaSize size) {
		this.size = size;
	}

	public int getQuantIng() {
		return quantIng;
	}

	public void setQuantIng(int quantIng) {
		this.quantIng = quantIng;
	}
	
	public static String pizzaToString(pizzaSize size) {
		switch (size) {
		case PEQUENA:
			return "Esta pizza é pequena";
		case FAMILIAR:
			return "Esta pizza é familiar";
		default:
			return "Esta pizza é media";
		}
	}
	
	public String toString() {
		return "\nNome - " + nome + "\nDescrição - " + desc + "\nPreço - " + price + "\nTamanho - " + pizzaToString(size) 
				+ "\nQuantidade de ingredientes - " + quantIng;
	}
	
	public ArrayList<Ingrediente> getArrayList() {
        return this.ingredientes;
    }

}
