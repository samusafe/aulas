package aulas;

import java.util.ArrayList;

public class Utilizador {

	private String nome;
	private String email;
	private String nascimento;
	private int codigo = 0;
	
	public static ArrayList<Despesas> despesas;
	
	public Utilizador(int codigo, String nome, String email, String nascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		despesas = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public ArrayList<Despesas> getDespesas() {
		return despesas;
	}
	
	public void addDespesa(Despesas despesa) {
		for (int i = 0; i < despesas.size(); i++) {
			if (despesas.get(i).getUtilizador() == despesa.getUtilizador()) {
				despesas.set(i, despesa);
				return;
			}
		}
		despesas.add(despesa);
	}
	
	public static boolean hasDespesas() {
		return despesas.size() > 0;
	}

}
