package model;

public abstract class Compte {
	
	protected String login;
	protected String password; 
	protected String mail;
	
	
	public Compte(String login, String password, String mail) {
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
