package safariJpa;

import safariJpa.model.singleTable.Chat;
import safariJpa.model.singleTable.Chien;
import safariJpa.model.singleTable.DaoAnimal;
import safariJpa.util.Context;

public class AppTest {

	public static void main(String[] args) {

		DaoAnimal daoAnimal = Context.getDaoAnimal();

		daoAnimal.insert(new Chien("malinois"));
		daoAnimal.insert(new Chat("siamois"));
		daoAnimal.findAll();

		Context.destroy();
	}

}
