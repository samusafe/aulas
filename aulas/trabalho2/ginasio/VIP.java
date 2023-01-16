package ginasio;

import java.util.ArrayList;

public class VIP extends User {
	
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	
	public VIP(int id, String email, String password, String nome, int numero) {
		super(id, email, password, nome, numero);
		contrato = getContrato();
		sessoes = new ArrayList<>();
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}
	
	public boolean hasSessoes() {
		return sessoes.size() > 0;
	}
}
