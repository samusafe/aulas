package ginasio;

import java.util.ArrayList;

public class Colaborador extends User {
	
	private boolean available;
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	private boolean notify;
	
	public Colaborador(int id, String email, String password, String nome, int numero,
			boolean available, boolean notify) {
		super(id, email, password, nome, numero);
		this.available = available;
		this.notify = notify;
		contrato = getContrato();
		sessoes = new ArrayList<>();
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
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

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}
}
