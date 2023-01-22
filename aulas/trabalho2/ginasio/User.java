package ginasio;

import enums.AcessType;
import enums.ClientType;
import enums.ContratoType;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String nome;
	private String numero;
	protected Contrato contrato;

	public User(int id, String email, String password, String nome, String numero) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.numero = numero;
		contrato = new Contrato(this, null, null, AcessType.NULL, ContratoType.NULL, ClientType.NULL);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof User)) {
            return false;
        }
         
        User c = (User) o;
      
        return c.getNome().equals(getNome())
        		&& c.getEmail().equals(getEmail())
        		&& c.getPassword().equals(getPassword())
        		&& c.getNumero() == getNumero();
	}
}
