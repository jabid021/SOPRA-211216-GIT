package projetFormation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("ordinateur")
public class Ordinateur extends Materiel {

	/**
	 * Default constructor
	 */
	public Ordinateur() {
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "materiel_ram")
	private Ram ram;

	@Enumerated(EnumType.STRING)
	@Column(name = "materiel_disque", length = 10)
	private Disque disque;

	@OneToOne
	@JoinColumn(name = "materiel_stagiaire_id", foreignKey = @ForeignKey(name = "materiel_stagiaire_id_fk"))
	private Stagiaire stagiaire;

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Disque getDisque() {
		return disque;
	}

	public void setDisque(Disque disque) {
		this.disque = disque;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}