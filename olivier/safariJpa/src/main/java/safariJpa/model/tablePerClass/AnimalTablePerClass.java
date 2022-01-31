package safariJpa.model.tablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqAnimalTablePerClass", sequenceName = "seq_animal", initialValue = 100, allocationSize = 1)
public abstract class AnimalTablePerClass {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAnimal")
	private Long id;
	@Column(name = "race", length = 200)
	private String race;

	public AnimalTablePerClass() {

	}

	public AnimalTablePerClass(String race) {
		super();
		this.race = race;
	}

	public AnimalTablePerClass(Long id, String race) {
		super();
		this.id = id;
		this.race = race;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

}
