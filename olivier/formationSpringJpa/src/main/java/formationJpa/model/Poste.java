package formationJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	//a vous de generer le code manquant
}
