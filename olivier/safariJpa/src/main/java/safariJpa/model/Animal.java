package safariJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "race", length = 200)
	private String race;

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

}
