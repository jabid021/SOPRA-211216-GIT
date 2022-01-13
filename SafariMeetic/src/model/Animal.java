package model;

public abstract class Animal {

	protected String race;
	protected Integer id;

	public Animal(Integer id, String race) {
		this.race = race;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setIdAnimal(Integer id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	
	
}
