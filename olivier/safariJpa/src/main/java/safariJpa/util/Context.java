package safariJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import safariJpa.dao.DaoFiche;
import safariJpa.dao.DaoFicheJpaImpl;
import safariJpa.model.DaoAnimal;
import safariJpa.model.DaoAnimalJpaImpl;
import safariJpa.model.singleTable.DaoAnimalSingle;
import safariJpa.model.singleTable.DaoAnimalSingleJpaImpl;
import safariJpa.model.tablePerClass.DaoAnimalTablePerClass;
import safariJpa.model.tablePerClass.DaoAnimalTablePerClassJpaImpl;

public class Context {
	private static EntityManagerFactory emf = null;
	private static DaoAnimal daoAnimal = new DaoAnimalJpaImpl();
	private static DaoFiche daoFiche = new DaoFicheJpaImpl();
	private static DaoAnimalTablePerClass daoAnimalTablePerClass = new DaoAnimalTablePerClassJpaImpl();
	private static DaoAnimal daoAnimalJoined = new DaoAnimalJpaImpl();

	public static DaoAnimal getDaoAnimalJoined() {
		return daoAnimalJoined;
	}

	public static DaoAnimalTablePerClass getDaoAnimalTablePerClass() {
		return daoAnimalTablePerClass;
	}

	public static DaoAnimal getDaoAnimal() {
		return daoAnimal;
	}

	public static DaoFiche getDaoFiche() {
		return daoFiche;
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
