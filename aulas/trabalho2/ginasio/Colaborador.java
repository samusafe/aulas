package ginasio;

import enums.ColabType;

public class Colaborador extends Conta {

	private ColabType colabType;
	
	public Colaborador(int id, String email, String password, String nome, int numero,
			ColabType colabType) {
		super(id, email, password, nome, numero);
		this.colabType = colabType;
	}
	
	public ColabType getColabType() {
		return colabType;
	}

	public void setColabType(ColabType colabType) {
		this.colabType = colabType;
	}
	

}
