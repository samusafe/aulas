package ginasio;

import java.util.ArrayList;

import enums.AcessType;
import enums.ClientType;
import enums.ContratoType;

interface Methods {
	public boolean criarConta(int id, String nome, String email, char[] password, String numero);
	public User entrarSistema(String nome, char[] password);
	public User getClientByNumber(String number);
	public boolean bookSession(User user, String data, User trainer);
	public void unBookSession(Sessao sessao, User user, User trainer);
	public void convertVIP(User user);
	public void convertNormal(User user);
	public ArrayList<User> filterUsers();
	public ArrayList<User> filterColab();
	public int countContracts();
}

class GereGinasio implements Methods {
	
	public ArrayList<User> users = new ArrayList<>();
	public ArrayList<Contrato> contratos = new ArrayList<>();
	
	public GereGinasio() {
		User user1 = new User(1, "user", "user", "user", "user");
		User user2 = new User(2, "samuel", "samuel", "samuel", "samuel");
		User user3 = new User(3, "bruno", "bruno", "bruno", "bruno");
		User user4 = new User(4, "carolina", "carolina", "carolina", "carolina");
		User user5 = new User(5, "isabel", "isabel", "isabel", "isabel");
		User user6 = new User(6, "guilherme", "guilherme", "guilherme", "guilherme");
		User user7 = new User(7, "jose", "jose", "jose", "jose");
		User user8 = new User(8, "antonio", "antonio", "antonio", "antonio");
		User user9 = new User(9, "duarte", "duarte", "duarte", "duarte");
		User user10 = new User(10, "david", "david", "david", "david");
		VIP user15 = new VIP(15, "vip", "vip", "vip", "vip");
		((VIP) user15).getContrato().setAcessType(AcessType.COMPLETO);
		((VIP) user15).getContrato().setClientType(ClientType.VIP);
		((VIP) user15).getContrato().setContratoType(ContratoType.ANUAL);
		((VIP) user15).getContrato().setDataInicio("24/01/2023");
		((VIP) user15).getContrato().setDataFinal("24/01/2024");
		Colaborador user16 = new Colaborador(16, "colab", "colab", "colab", "colab");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		users.add(user15);
		users.add(user16);
	}
	
	public boolean criarConta(int id, String nome, String email, char[] password, String numero) {
		User user = new User(id, nome, email, joinCharArray(password), numero);
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(user.getEmail()) || users.get(i).getNumero().equals(user.getNumero())) {
				return false;
			}
		}
		
		return users.add(user);
	}

	public User entrarSistema(String email, char[] password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email)
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
	
	public User getClientByNumber(String number) {
		for (int i = 0; i < users.size(); i++) {
			if (number.equals(users.get(i).getNumero())) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public boolean bookSession(User user, String data, User trainer) {
		Sessao sessao = new Sessao(user, data, trainer);
		for (int i = 0; i < ((Colaborador) trainer).getSessoes().size(); i++) {
			if (((Colaborador) trainer).getSessoes().get(i).getData().equals(data)) {
				return false;
			}
		}
		
		for (int i = 0; i < ((VIP) user).getSessoes().size(); i++) {
			if (((VIP) user).getSessoes().get(i).getData().equals(data)) {
				return false;
			}
		}
		return ((VIP) user).addSessoes(sessao) && ((Colaborador) trainer).addSessoes(sessao);
	}
	
	public void unBookSession(Sessao sessao, User user, User trainer) {
		for (int i = 0; i < ((Colaborador) trainer).getSessoes().size(); i++) {
			if (((Colaborador) trainer).getSessoes().get(i).equals(sessao)) {
				((Colaborador) trainer).getSessoes().remove(i);
			}
		}
		
		for (int i = 0; i < ((VIP) user).getSessoes().size(); i++) {
			if (((VIP) user).getSessoes().get(i).equals(sessao)) {
				((VIP) user).getSessoes().remove(i);
			}
		}
	}
	
	public void convertVIP(User user) {
		VIP vip = new VIP(user.getId(), user.getNome(), user.getEmail(), user.getPassword(), user.getNumero());
		vip.setContrato(user.getContrato());
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				users.remove(i);
				users.add(vip);
			}
		}
	}
	
	public void convertNormal(User user) {
		User client = new User(user.getId(), user.getNome(), user.getEmail(), user.getPassword(), user.getNumero());
		client.setContrato(user.getContrato());
		for (int i = 0; i < users.size(); i++) {
			if (user.equals(users.get(i))) {
				users.remove(i);
				users.add(client);
			}
		}
	}
	
	public ArrayList<User> filterUsers() {
		ArrayList<User> usersFiltrados = new ArrayList<>();
		for (User user: users) {
			if (!(user instanceof Colaborador)) {
				usersFiltrados.add(user);
			}
		}
		return usersFiltrados;
	}
	
	public ArrayList<User> filterColab() {
		ArrayList<User> usersFiltrados = new ArrayList<>();
		for (User user: users) {
			if (user instanceof Colaborador) {
				usersFiltrados.add(user);
			}
		}
		return usersFiltrados;
	}
	
	public int countContracts() {
		ArrayList<User> usersFiltrados = new ArrayList<>();
		for (User user: users) {
			if (!(user instanceof Colaborador) && user.getContrato().getDataInicio() != null) {
				usersFiltrados.add(user);
			}
		}
		return usersFiltrados.size();
	}
}
