package formationJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dept")
public class Departement {
	@Id
	@Column(name="deptno")
	private Long id;
	@Column(name="dname",length = 200,nullable = false)
	private String nom;
	
	public Departement() {
		
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
	
	
}