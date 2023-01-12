package ginasio;

import enums.ClienteType;
import enums.ContratoType;

public class Cliente extends Conta {
	
	private ClienteType clienteType;
	private ContratoType contratoType;

	public Cliente(int id, String email, String password, String nome, int numero,
			ClienteType clienteType, ContratoType contratoType) {
		super(id, email, password, nome, numero);
		this.clienteType = clienteType;
		this.contratoType = contratoType;
	}

	public ClienteType getClienteType() {
		return clienteType;
	}

	public void setClienteType(ClienteType clienteType) {
		this.clienteType = clienteType;
	}

	public ContratoType getContratoType() {
		return contratoType;
	}

	public void setContratoType(ContratoType contratoType) {
		this.contratoType = contratoType;
	}

}
