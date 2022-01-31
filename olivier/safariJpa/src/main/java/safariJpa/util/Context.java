package safariJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import safariJpa.dao.DaoAnimal;
import safariJpa.dao.DaoAnimalJpaImpl;

public class Context {
	private static EntityManagerFactory emf = null;
	private static DaoAnimal daoAnimal = new DaoAnimalJpaImpl();

	public static DaoAnimal getDaoAnimal() {
		return daoAnimal;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("safari");
		}
		return emf;
	}

	public static void destroy() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
