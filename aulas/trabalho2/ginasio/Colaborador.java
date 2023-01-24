package ginasio;

import java.util.ArrayList;

public class Colaborador extends User {
	
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	
	public Colaborador(int id, String email, String password, String nome, String numero) {
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
