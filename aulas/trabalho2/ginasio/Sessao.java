package ginasio;

public class Sessao {
	
	private User user;
	private String data;
	private String hora;
	private User trainer;
	
	public Sessao(User user, String data, String hora, User trainer) {
		this.user = user;
		this.data = data;
		this.hora = hora;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}	
}
