package projetFormation.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {

	/**
	 * Default constructor
	 */
	public ModuleFormation() {
	}

	@Column(name = "module_formation_date")
	private LocalDate date;

	@EmbeddedId
	private ModuleFormationKey id;

	@ManyToOne
	@JoinColumn(name = "module_formation_formateur_id", foreignKey = @ForeignKey(name = "module_formation_formateur_id_fk"))
	private Formateur formateur;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ModuleFormationKey getId() {
		return id;
	}

	public void setId(ModuleFormationKey id) {
		this.id = id;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
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
		ModuleFormation other = (ModuleFormation) obj;
		return Objects.equals(id, other.id);
	}

}