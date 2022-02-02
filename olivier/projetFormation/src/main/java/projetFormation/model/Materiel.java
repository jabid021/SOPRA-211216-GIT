package projetFormation.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "materiel_type", discriminatorType = DiscriminatorType.STRING, length = 10)
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_materiel", initialValue = 10, allocationSize = 1)
public abstract class Materiel {

	/**
	 * Default constructor
	 */
	public Materiel() {
	}

	@Id
	@Column(name = "materiel_id")
	private Long id;

	@Column(name = "materiel_marque", length = 100)
	private String marque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
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
		Materiel other = (Materiel) obj;
		return Objects.equals(id, other.id);
	}

}