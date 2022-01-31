package safariJpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="chien")
@SequenceGenerator(name = "seqDefault", sequenceName = "seq_chat", initialValue = 100, allocationSize = 1)
public class Chien extends Animal{
	public Chien() {
		
	}
	
	public Chien(String race) {
		super(race);
	}
}
