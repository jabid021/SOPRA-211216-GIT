package projetFormation.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_stagiaire", initialValue = 10, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "stagiaire_id")),
		@AttributeOverride(name = "prenom", column = @Column(name = "stagiaire_prenom", length = 200)),
		@AttributeOverride(name = "nom", column = @Column(name = "stagiaire_nom", length = 200)),
		@AttributeOverride(name = "dateNaissance", column = @Column(name = "stagiaire_dt_naiss")),
		@AttributeOverride(name = "email", column = @Column(name = "stagiaire_email", length = 200)),
		@AttributeOverride(name = "telephone", column = @Column(name = "stagiaire_tel", length = 20)),
		@AttributeOverride(name = "adresse.numero", column = @Column(name = "stagiaire_numero")),
		@AttributeOverride(name = "adresse.rue", column = @Column(name = "stagiaire_rue", length = 200)),
		@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "stagiaire_cp", length = 20)),
		@AttributeOverride(name = "adresse.ville", column = @Column(name = "stagiaire_ville", length = 200)),
		@AttributeOverride(name = "civilite", column = @Column(name = "stagiaire_civilite", length = 5)) })
public class Stagiaire extends Personne {

	/**
	 * Default constructor
	 */
	public Stagiaire() {
	}

	@Column(name = "stagiaire_entreprise", length = 150)
	private String entreprise;

	@OneToOne(mappedBy = "stagiaire")
	private Ordinateur pc;

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Ordinateur getPc() {
		return pc;
	}

	public void setPc(Ordinateur pc) {
		this.pc = pc;
	}

}