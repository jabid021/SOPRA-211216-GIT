package model;

public class Chien extends Animal{

	public Chien(String race) {
		super(race);
	}

	@Override
	public String toString() {
		return "Chien [race=" + race + "]";
	}

	
}
