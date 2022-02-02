package projetFormation.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "seq_module", initialValue = 10, allocationSize = 1)
public class Module {

	/**
	 * Default constructor
	 */
	public Module() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqModule")
	@Column(name = "module_id")
	private Long id;
	@Column(name = "module_nom", length = 150)
	private String nom;

	@Column(name = "module_description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "module_duree")
	private int duree;

	@OneToMany(mappedBy = "id.module")
	private Set<ModuleFormation> modulesFormations;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Set<ModuleFormation> getModulesFormations() {
		return modulesFormations;
	}

	public void setModulesFormations(Set<ModuleFormation> modulesFormations) {
		this.modulesFormations = modulesFormations;
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
		Module other = (Module) obj;
		return Objects.equals(id, other.id);
	}

}