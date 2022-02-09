package formationJpa.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
@SequenceGenerator(name = "seqDepartement", sequenceName = "seq_dept", initialValue = 100, allocationSize = 1)
public class Departement {
	@Id
	@Column(name = "deptno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDepartement")
	private Long id;
	@Column(name = "dname", length = 200, nullable = false)
	private String nom;
	// List ou Set
	// Set =>pas de doublon plusieurs Set peuvent etre chargees simultanement
	// List=>1 seule List charge par requete
	@OneToMany(mappedBy = "departement")
	private List<Employe> employes;

	public Departement() {

	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public Departement(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

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

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
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
		Departement other = (Departement) obj;
		return Objects.equals(id, other.id);
	}

}
