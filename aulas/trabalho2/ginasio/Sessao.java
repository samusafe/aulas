package ginasio;

public class Sessao {
	
	private User user;
	private String data;
	private User trainer;
	
	public Sessao(User user, String data, User trainer) {
		this.user = user;
		this.data = data;
		this.trainer = trainer;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}
	
	public String toString() {
		if (user instanceof VIP) {
			return data + "      " + trainer.getNome();
		} 
		if (user instanceof Colaborador) {
			return data + "      " + user.getNome();
		}
		return null;
	}
}
