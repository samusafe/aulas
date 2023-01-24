package ginasio;

import java.util.ArrayList;

public class VIP extends User {
	
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	
	public VIP(int id, String email, String password, String nome, String numero) {
		super(id, email, password, nome, numero);
		contrato = getContrato();
		sessoes = new ArrayList<>();
	}

	public ArrayList<Sessao> getSessoes() {
		return sessoes;
	}

	public boolean addSessoes(Sessao sessao) {
		return sessoes.add(sessao);
	}
	
	public boolean hasSessoes() {
		return sessoes.size() > 0;
	}
}
