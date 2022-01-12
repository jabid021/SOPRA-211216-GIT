package model;

public class Admin extends Compte {

	public Admin(String login,String password, String mail) {
		super(login,password, mail);
	}

	@Override
	public String toString() {
		return "Admin [login=" + login + ", password=" + password + ", mail=" + mail + "]";
	}

	
	
	
}
