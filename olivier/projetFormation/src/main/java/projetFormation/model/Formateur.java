package projetFormation.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formateur")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_formateur", initialValue = 10, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "formateur_id")),
		@AttributeOverride(name = "prenom", column = @Column(name = "formateur_prenom", length = 200)),
		@AttributeOverride(name = "nom", column = @Column(name = "formateur_nom", length = 200)),
		@AttributeOverride(name = "dateNaissance", column = @Column(name = "formateur_dt_naiss")),
		@AttributeOverride(name = "email", column = @Column(name = "formateur_email", length = 200)),
		@AttributeOverride(name = "telephone", column = @Column(name = "formateur_tel", length = 20)),
		@AttributeOverride(name = "adresse.numero", column = @Column(name = "formateur_numero")),
		@AttributeOverride(name = "adresse.rue", column = @Column(name = "formateur_rue", length = 200)),
		@AttributeOverride(name = "adresse.codePostal", column = @Column(name = "formateur_cp", length = 20)),
		@AttributeOverride(name = "adresse.ville", column = @Column(name = "formateur_ville", length = 200)),
		@AttributeOverride(name = "civilite", column = @Column(name = "formateur_civilite", length = 5)) })
public class Formateur extends Personne {

	/**
	 * Default constructor
	 */
	public Formateur() {
	}

	@Column(name = "formateur_exp")
	private int experience;

	@OneToMany(mappedBy = "referent")
	private Set<Formation> formations;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

}