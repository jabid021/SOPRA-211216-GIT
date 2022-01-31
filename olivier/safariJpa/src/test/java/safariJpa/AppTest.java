package safariJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import safariJpa.model.Animal;
import safariJpa.model.Chat;
import safariJpa.model.Chien;
import safariJpa.model.DaoAnimal;
import safariJpa.model.singleTable.ChatSingle;
import safariJpa.model.singleTable.ChienSingle;
import safariJpa.model.singleTable.DaoAnimalSingle;
import safariJpa.model.tablePerClass.ChatTablePerClass;
import safariJpa.model.tablePerClass.ChienTablePerClass;
import safariJpa.model.tablePerClass.DaoAnimalTablePerClass;
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
