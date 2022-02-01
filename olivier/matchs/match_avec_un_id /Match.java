package safariJpa.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "match")
@SequenceGenerator(name = "seqMatch", sequenceName = "seq_match", initialValue = 100, allocationSize = 1)
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatch")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "match_fiche_id", foreignKey = @ForeignKey(name = "match_fiche_id_fk"))
	private Fiche fiche;
	@ManyToOne
	@JoinColumn(name = "match_client_id", foreignKey = @ForeignKey(name = "match_client_id_fk"))
	private Client client;

	public Match() {

	}

	public Match(Fiche fiche, Client client) {
		super();
		this.fiche = fiche;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return Objects.equals(id, other.id);
	}

}
