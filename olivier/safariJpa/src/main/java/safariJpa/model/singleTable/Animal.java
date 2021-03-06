package safariJpa.model.singleTable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import safariJpa.model.Fiche;

@Entity
@Table(name = "animal_single")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_animal",discriminatorType = DiscriminatorType.STRING,length = 5)
@SequenceGenerator(name="seqAnimalSingle",sequenceName = "seq_animal",initialValue = 100,allocationSize = 1)
public abstract class Animal {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqAnimalSingle")
	private Long id;
	@Column(name = "race", length = 200)
	private String race;
	@OneToOne(mappedBy = "animal")
	private Fiche fiche;

	public Animal() {

	}

	public Animal(String race) {
		super();
		this.race = race;
	}

	public Animal(Long id, String race) {
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

	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
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
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}

}
