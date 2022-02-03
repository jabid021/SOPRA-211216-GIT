package formationSpringCore.beans;

import org.springframework.stereotype.Component;

public class Adresse {
	private String adresse = "une adresse";

	public Adresse() {

	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + "]";
	}

	
}
