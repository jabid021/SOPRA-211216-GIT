package model;

public class Chien extends Animal{

	
	public Chien(Integer idAnimal, String race) {
		super(idAnimal, race);
		// TODO Auto-generated constructor stub
	}
	
	
	public Chien(String race) {
		super(race);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Chien [race=" + race + "]";
	}

	
}
