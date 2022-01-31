package safariJpa.model.singleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "animal_single")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_animal",discriminatorType = DiscriminatorType.STRING,length = 5)
@SequenceGenerator(name="seqAnimal",sequenceName = "seq_animal",initialValue = 100,allocationSize = 1)
public abstract class AnimalSingle {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqAnimal")
	private Long id;
	@Column(name = "race", length = 200)
	private String race;

	public AnimalSingle() {

	}

	public AnimalSingle(String race) {
		super();
		this.race = race;
	}

	public AnimalSingle(Long id, String race) {
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
