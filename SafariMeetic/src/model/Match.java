package model;

public class Match {

	private Fiche fiche;
	private Client client;
	
	
	public Match(Fiche fiche, Client client) {
		this.fiche = fiche;
		this.client = client;
	}


	public Fiche getFiche() {
		return fiche;
	}


	public Client getClient() {
		return client;
	}


	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Match [fiche=" + fiche + ", client=" + client + "]";
	}



	
	
	
}
