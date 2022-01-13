package model;

import java.util.ArrayList;
import java.util.List;

public class Vendeur extends Compte {

	private Refuge refuge;
	private Adresse adresse;
	private List<Fiche> fiches=new ArrayList();
	
	public Vendeur(Integer id,String login,String password, String mail,Refuge refuge,Adresse adresse) {
		super(id,login,password, mail);
		this.refuge=refuge;
		this.adresse=adresse;
	}

	public Refuge getRefuge() {
		return refuge;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setRefuge(Refuge refuge) {
		this.refuge = refuge;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

	@Override
	public String toString() {
		return "Vendeur [refuge=" + refuge + ", adresse=" + adresse + ", fiches=" + fiches + ", id=" + id + ", login="
				+ login + ", password=" + password + ", mail=" + mail + "]";
	}
	
	

}
