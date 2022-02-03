package formationSpringCore;

import org.springframework.stereotype.Component;

@Component("perso")
public class Adresse {
	private String adresse="une adresse";
	
	public Adresse() {
		
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
