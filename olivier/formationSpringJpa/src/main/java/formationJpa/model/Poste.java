package formationJpa.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "job")
public class Poste {
	@Id
	@Column(name = "job_id", length = 50)
	@NotEmpty(message = "mon message pour dire que c'est vide")
	private String code;
	@NotEmpty
	@Column(name = "job_name", length = 100, nullable = false, unique = true)
	private String libelle;
	@DecimalMin("0.0")
	@Column(name = "job_min_sal")
	private double salaireMin;
	@Column(name = "job_max_sal")
	@DecimalMin("100")
	@DecimalMax("999999999")
	private double salaireMax;
	@OneToMany(mappedBy = "poste")
	private List<Employe> employes;
	@Version
	private int version;

	public Poste() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getSalaireMin() {
		return salaireMin;
	}

	public void setSalaireMin(double salaireMin) {
		this.salaireMin = salaireMin;
	}

	public double getSalaireMax() {
		return salaireMax;
	}

	public void setSalaireMax(double salaireMax) {
		this.salaireMax = salaireMax;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poste other = (Poste) obj;
		return Objects.equals(code, other.code);
	}

}
