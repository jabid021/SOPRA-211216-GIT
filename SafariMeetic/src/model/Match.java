package model;

public class Match {

	private Integer id;
	private Fiche fiche;
	private Client client;
	
	
	public Match(Integer id,Fiche fiche, Client client) {
		this.fiche = fiche;
		this.client = client;
		this.id=id;
	}


	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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
		return "Match [id=" + id + ", fiche=" + fiche + ", client=" + client + "]";
	}





	
	
	
}
