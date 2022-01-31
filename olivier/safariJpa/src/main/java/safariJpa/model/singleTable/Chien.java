package safariJpa.model.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("chien")
public class ChienSingle extends AnimalSingle{
	public ChienSingle() {
		
	}
	
	public ChienSingle(String race) {
		super(race);
	}
}
