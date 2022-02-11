package formationJpa.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "job")
public class Poste {
	@Id
	@Column(name = "job_id", length = 50)
	private String code;
	@Column(name = "job_name", length = 100)
	private String libelle;
	@Column(name = "job_min_sal")
	private double salaireMin;
	@Column(name = "job_max_sal")
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
