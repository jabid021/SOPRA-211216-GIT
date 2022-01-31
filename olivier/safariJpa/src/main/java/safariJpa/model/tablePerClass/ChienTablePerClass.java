package safariJpa.model.tablePerClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chien_table_per_class")
public class ChienTablePerClass extends AnimalTablePerClass {
	public ChienTablePerClass() {

	}

	public ChienTablePerClass(String race) {
		super(race);
	}
}
