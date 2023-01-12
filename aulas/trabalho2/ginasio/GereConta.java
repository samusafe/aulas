package ginasio;

import java.util.ArrayList;

import enums.ClienteType;
import enums.ContratoType;

public class GereConta {
	protected ArrayList<Conta> contas = new ArrayList<>();
	
	public boolean hasContas() {
		return contas.size() > 0;
	}

	public boolean criarConta(int id, String email, char[] password, String nome, int numero) {
		Conta conta = new Conta(id, email, joinCharArray(password), nome, numero);
		Cliente cliente = new Cliente(id, email, joinCharArray(password), nome, numero,
				ClienteType.NORMAL, ContratoType.NULL);
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).equals(conta)) {
				return false;
			}
		}
		return contas.add(conta);
	}

	public Conta entrarConta(String nome, char[] password) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNome().equals(nome) 
					&& contas.get(i).getPassword().equals(joinCharArray(password))) {
					return contas.get(i);
			}
		}
		return null;
	}
	
	private String joinCharArray(char[] password) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		
		return pw;
	}
}