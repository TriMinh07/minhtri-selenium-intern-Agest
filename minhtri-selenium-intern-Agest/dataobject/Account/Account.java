package Account;

import Common.RandomString;

public class Account {
	private String password;
	private String email;
	private String pid;

	public Account(String email, String password) {
		this.password = password;
		this.email = email;
	}

	public Account(String email, String password, String pid) {
		this.password = password;
		this.email = email;
		this.pid = pid;
	}
	
	public Account(String email) {
		this.password = "";
		this.email = email;
		this.pid = "";
	}
	public static Account generalAccount() {
	    String email = RandomString.generateRandomString(12);
	    String password = RandomString.generateRandomString(12);
	    String pid = RandomString.generateRandomNumberString(12);
	    return new Account(email, password, pid);
	}

	public Account() {
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
