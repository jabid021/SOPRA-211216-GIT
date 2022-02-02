package projetFormation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("casque")
public class Casque extends Materiel {

	/**
	 * Default constructor
	 */
	public Casque() {
	}

	@Column(name = "materiel_is_filere")
	private boolean filere;

	public boolean isFilere() {
		return filere;
	}

	public void setFilere(boolean filere) {
		this.filere = filere;
	}

}