package ginasio;

public class Check {

	private String check;
	private Conta user;
	
	public Check(String check, Conta user) {
		this.check = check;
		this.user = user;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public Conta getUser() {
		return user;
	}

	public void setUser(Conta user) {
		this.user = user;
	}
}
