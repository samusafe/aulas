package aulas;

public class Despesas {
	
	public enum despesaType {
		AUTOMOVEL,
		ALIMENTAR,
		OUTRO
	}
	
	private Utilizador utilizador;
	private int codigo;
	private int id;
	private int gasto;
	private String date;
	private despesaType type = despesaType.OUTRO;
	
	public Despesas(Utilizador utilizador, int codigo, int id, despesaType type, int gasto, String date) {
		this.utilizador = utilizador;
		this.codigo = codigo;
		this.id = id;
		this.type = type;
		this.gasto = gasto;
		this.date = date;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	
	public String toString() {
		return "| Codigo - " + codigo + "\n| Tipo - " + type + "\n| Gasto - " + gasto + "\n| Data da despesa - " + date + "\n";
	}
}
