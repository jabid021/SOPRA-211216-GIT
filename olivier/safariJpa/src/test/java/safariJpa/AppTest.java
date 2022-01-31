package safariJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import safariJpa.dao.DaoAnimal;
import safariJpa.model.Animal;
import safariJpa.util.Context;

public class AppTest {

	public static void main(String[] args) {
		DaoAnimal daoAnimal = Context.getDaoAnimal();
		daoAnimal.insert(new Animal(1L, "chien"));

		Context.destroy();
	}

}
