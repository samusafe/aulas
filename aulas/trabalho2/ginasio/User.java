package ginasio;

import java.util.ArrayList;

import enums.UserType;
import enums.ContratoType;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String nome;
	private int numero;
	private UserType userType;
	private ContratoType contratoType;
	
	ArrayList<Check> checks = new ArrayList<>();

	public User(int id, String email, String password, String nome, int numero, UserType userType, ContratoType contratoType) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.numero = numero;
		this.userType = userType;
		this.contratoType = contratoType;
		checks = new ArrayList<>();
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

	public UserType getUserType() {
		return userType;
	}

	public void setClienteType(UserType userType) {
		this.userType = userType;
	}

	public ContratoType getContratoType() {
		return contratoType;
	}

	public void setContratoType(ContratoType contratoType) {
		this.contratoType = contratoType;
	}
	
	public ArrayList<Check> getCheck() {
		return checks;
	}
	
	public boolean hasCheck() {
		return checks.size() > 0;
	}
	
	public void addCheck(Check check) {
		for (int i = 0; i < checks.size(); i++) {
			if (checks.get(i).getUser() == check.getUser()) {
				checks.set(i, check);
				return;
			}
		}
		checks.add(check);
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
