package ginasio;

import enums.ContratoType;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String nome;
	private int numero;
	protected Contrato contrato;

	public User(int id, String email, String password, String nome, int numero) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.numero = numero;
		contrato = new Contrato(this, null, null, ContratoType.NULL);
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


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
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
        		&& c.getPassword().equals(getPassword())
        		&& c.getNumero() == getNumero();
	}
}
