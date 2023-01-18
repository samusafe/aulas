package ginasio;

import java.util.ArrayList;

import enums.ContratoType;

interface Methods {
	public boolean criarConta(int id, String email, char[] password, String nome, int numero);
	public User entrarSistema(String nome, char[] password);
	public void addEntryOut(String newCheck, User user);
	public void notifyTrainer(User user, String data);
	public User getClientByName(String name);
	public boolean bookSession(User user, String data, String hora, User trainer);
	public void editContrato(User user, ContratoType contratoType);
}

class GereGinasio implements Methods {
	
	public ArrayList<User> users = new ArrayList<>();
	public ArrayList<Contrato> contratos = new ArrayList<>();
	
	public boolean criarConta(int id, String email, char[] password, String nome, int numero) {
		User user = new User(id, email, joinCharArray(password), nome, numero);
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(user)) {
				return false;
			}
		}
		
		return users.add(user);
	}

	public User entrarSistema(String nome, char[] password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getNome().equals(nome) 
					&& users.get(i).getPassword().equals(joinCharArray(password))) {
					return users.get(i);
			}
		}
		return null;
	}
	
	public boolean hasUsers() {
		return users.size() > 0;
	}
	
	private String joinCharArray(char[] password) {
		String pw = "";
		for (int i = 0; i < password.length; i++) {
			pw += password[i];
		}
		
		return pw;
	}
	
	public void addEntryOut(String newLog, User user) {
		EntryOut entryOut = new EntryOut(newLog, user);
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				if (user instanceof Colaborador) {
					((Colaborador) users.get(i)).addCheck(entryOut);
				} else if (user instanceof VIP) {
					notifyTrainer((VIP) users.get(i), newLog);
				}
			}
		}
	}
	
	public void notifyTrainer(User user, String data) {
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				if (user instanceof Colaborador) {
					for (int j = 0; j < ((Colaborador) user).getSessoes().size(); i++ ) {
						if (((Colaborador) user).getSessoes().get(i).getData().equals(data)) {
							((Colaborador) user).setNotify(true);
						}
					}
				}
			}
		}
	}
	
	public User getClientByName(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getNome())) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public boolean bookSession(User user, String data, String hora, User trainer) {
		Sessao sessao = new Sessao(user, data, hora, trainer);
		for (int i = 0; i < users.size(); i++) {
			if (user instanceof Colaborador &&
					((Colaborador) users.get(i)).isAvailable() != false) {
				return ((Colaborador) users.get(i)).addSessoes(sessao);
			}
		}
		return false;
	}
	
	public void editContrato(User user, ContratoType contratoType) {
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				if (contratoType != user.getContrato().getContratoType()) {
					user.getContrato().setContratoType(contratoType);
				}
			}
		}
	}
}
