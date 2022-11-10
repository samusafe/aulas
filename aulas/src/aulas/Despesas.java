package aulas;

public class Despesas {
	
	public enum despesaType {
		AUTOMOVEL,
		ALIMENTAR,
		OUTRO
	}
	
	private Utilizador utilizador;
	private int id;
	private int gasto;
	private String date;
	private despesaType type = despesaType.OUTRO;
	
	public Despesas(Utilizador utilizador, int id, despesaType type, int gasto, String date) {
		this.utilizador = utilizador;
		this.id = id;
		this.type = type;
		this.gasto = gasto;
		this.date = date;
	}
	
	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGasto() {
		return gasto;
	}

	public void setGasto(int gasto) {
		this.gasto = gasto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
