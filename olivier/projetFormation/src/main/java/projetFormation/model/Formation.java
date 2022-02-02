package projetFormation.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", initialValue = 10, allocationSize = 1)
public class Formation {

	/**
	 * Default constructor
	 */
	public Formation() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	@Column(name = "formation_id")
	private Long id;

	@Column(name = "formation_nom", length = 50)
	private String nom;

	@Column(name = "formation_date")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "formation_referent", foreignKey = @ForeignKey(name = "formation_referent_fk"))
	private Formateur referent;

	@OneToMany(mappedBy = "id.formation")
	private Set<ModuleFormation> modules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	public Set<ModuleFormation> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleFormation> modules) {
		this.modules = modules;
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
		Formation other = (Formation) obj;
		return Objects.equals(id, other.id);
	}

}