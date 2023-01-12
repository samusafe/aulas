package ginasio;

public class Check {

	private String check;
	private User user;
	
	public Check(String check, User user) {
		this.check = check;
		this.user = user;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
