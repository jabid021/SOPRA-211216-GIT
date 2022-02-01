package safariJpa.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MatchKey implements Serializable{
	@ManyToOne
	@JoinColumn(name = "match_fiche_id", foreignKey = @ForeignKey(name = "match_fiche_id_fk"))
	private Fiche fiche;
	@ManyToOne
	@JoinColumn(name = "match_client_id", foreignKey = @ForeignKey(name = "match_client_id_fk"))
	private Client client;
	
	public MatchKey() {
		
	}

	public MatchKey(Fiche fiche, Client client) {
		super();
		this.fiche = fiche;
		this.client = client;
	}

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, fiche);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchKey other = (MatchKey) obj;
		return Objects.equals(client, other.client) && Objects.equals(fiche, other.fiche);
	}
	
	
}
