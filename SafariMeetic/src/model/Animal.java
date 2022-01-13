package model;

public abstract class Animal {

	protected String race;
	protected Integer idAnimal;

	public Animal(Integer idAnimal, String race) {
		this.race = race;
		this.idAnimal = idAnimal;
	}

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	
	
}
