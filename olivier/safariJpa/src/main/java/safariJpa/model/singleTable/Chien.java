package safariJpa.model.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("chien")
public class Chien extends Animal{
	public Chien() {
		
	}
	
	public Chien(String race) {
		super(race);
	}
}
