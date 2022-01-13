package model;

public class Admin extends Compte {

	public Admin(Integer id,String login,String password, String mail) {
		super(id,login,password, mail);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", mail=" + mail + "]";
	}

	
	
	
}
