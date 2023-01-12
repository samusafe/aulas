package ginasio;

import java.util.ArrayList;

import enums.UserType;
import enums.ContratoType;

interface Methods {
	public boolean criarConta(int id, String email, char[] password, String nome, int numero);
	public User entrarSistema(String nome, char[] password);
	public void validateEntryOut(String check, User conta);
	public void notifyTrain(User conta);
	
	public ArrayList<User> users = new ArrayList<>();
	public ArrayList<User> clientes = new ArrayList<>();
	public ArrayList<User> clientesVip = new ArrayList<>();
	public ArrayList<User> colaboradores = new ArrayList<>();
	public ArrayList<User> trainers = new ArrayList<>();
}

class GereGinasio implements Methods {

	public boolean criarConta(int id, String email, char[] password, String nome, int numero) {
		User user = new User(id, email, joinCharArray(password), nome, numero,
				UserType.NORMAL, ContratoType.NULL);
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(user)) {
				return false;
			}
		}
		
		if (user.getUserType().equals(UserType.NORMAL)) {
			clientes.add(user);
		} else if (user.getUserType().equals(UserType.VIP)) {
			clientesVip.add(user);
		} else if (user.getUserType().equals(UserType.COLABORADOR)) {
			colaboradores.add(user);
		} else if (user.getUserType().equals(UserType.TRAINER)) {
			trainers.add(user);
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
	
	public void validateEntryOut(String newCheck, User user) {
		Check check = new Check(newCheck, user);
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				users.get(i).addCheck(check);
			}
		}
	}
	
	public void notifyTrain(User cliente) {
		
	}
}
