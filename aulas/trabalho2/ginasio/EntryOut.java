package ginasio;

public class EntryOut {

	private String entryOut;
	private User user;
	
	public EntryOut(String entryOut, User user) {
		this.entryOut = entryOut;
		this.user = user;
	}

	public String getEntryOut() {
		return entryOut;
	}

	public void setEntryOut(String entryOut) {
		this.entryOut = entryOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
