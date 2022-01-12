package model;

public class Client extends Compte {

	private String tel;
	private Adresse adresse;
	
	
	public Client(String login, String password, String mail, String tel, Adresse adresse) {
		super(login, password, mail);
		this.tel = tel;
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Client [login=" + login + ", password=" + password + ", mail=" + mail + ", tel=" + tel + ", adresse="
				+ adresse + "]";
	}
	
	
	
	
	
}
