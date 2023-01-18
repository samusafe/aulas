package ginasio;

import java.util.ArrayList;

public class Colaborador extends User {
	
	private boolean available;
	private ArrayList<EntryOut> checks = new ArrayList<>();
	private ArrayList<Sessao> sessoes = new ArrayList<>();
	private boolean notify;
	
	public Colaborador(int id, String email, String password, String nome, int numero,
			boolean available, boolean notify) {
		super(id, email, password, nome, numero);
		this.available = available;
		this.notify = notify;
		contrato = getContrato();
		checks = new ArrayList<>();
		sessoes = new ArrayList<>();
	}

	public ArrayList<EntryOut> getChecks() {
		return checks;
	}

	public void setChecks(ArrayList<EntryOut> checks) {
		this.checks = checks;
	}
	
	public void addCheck(EntryOut check) {
		for (int i = 0; i < checks.size(); i++) {
			if (checks.get(i).getUser() == check.getUser()) {
				checks.set(i, check);
				return;
			}
		}
		checks.add(check);
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
