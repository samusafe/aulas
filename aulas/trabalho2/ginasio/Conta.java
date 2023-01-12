package ginasio;

import java.util.ArrayList;

public class Conta {
		
	private int id;
	private String email;
	private String password;
	private String nome;
	private int numero;
	ArrayList<Check> checks = new ArrayList<>();

	public Conta(int id, String email, String password, String nome, int numero) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.numero = numero;
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
 
        if (!(o instanceof Conta)) {
            return false;
        }
         
        Conta c = (Conta) o;
      
        return c.getNome().equals(getNome())
        		&& c.getPassword().equals(getPassword())
        		&& c.getNumero() == getNumero();
	}
}
