package ginasio;

import enums.AcessType;
import enums.ClientType;
import enums.ContratoType;

public class Contrato {
	
	private User user;
	private String dataInicio;
	private String dataFinal;
	private AcessType acessType;
	private ContratoType contratoType;
	private ClientType clientType;
	
	public Contrato(User user, String dataInicio, String dataFinal, AcessType acessType, ContratoType contratoType, ClientType clientType) {
		this.user = user;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.acessType = acessType;
		this.contratoType = contratoType;
		this.clientType = clientType;
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
	
	public AcessType getAcessType() {
		return acessType;
	}

	public void setAcessType(AcessType acessType) {
		this.acessType = acessType;
	}

	public ContratoType getContratoType() {
		return contratoType;
	}

	public void setContratoType(ContratoType contratoType) {
		this.contratoType = contratoType;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
}
