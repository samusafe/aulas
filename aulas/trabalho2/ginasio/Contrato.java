package ginasio;

import enums.ContratoType;

public class Contrato {
	
	private User user;
	private String dataInicio;
	private String dataFinal;
	private ContratoType contratoType;
	
	public Contrato(User user, String dataInicio, String dataFinal, ContratoType contratoType) {
		this.user = user;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.contratoType = contratoType;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public ContratoType getContratoType() {
		return contratoType;
	}

	public void setContratoType(ContratoType contratoType) {
		this.contratoType = contratoType;
	}
}
