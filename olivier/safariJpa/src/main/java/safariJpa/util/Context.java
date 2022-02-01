package safariJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import safariJpa.dao.DaoCompte;
import safariJpa.dao.DaoCompteJpaImpl;
import safariJpa.dao.DaoFiche;
import safariJpa.dao.DaoFicheJpaImpl;
import safariJpa.dao.DaoMatch;
import safariJpa.dao.DaoMatchJpaImpl;
import safariJpa.model.singleTable.DaoAnimal;
import safariJpa.model.singleTable.DaoAnimalJpaImpl;

public class Context {
	private static EntityManagerFactory emf = null;
	private static DaoAnimal daoAnimal = new DaoAnimalJpaImpl();
	private static DaoFiche daoFiche = new DaoFicheJpaImpl();
	private static DaoCompte daoCompte = new DaoCompteJpaImpl();
	private static DaoMatch daoMatch = new DaoMatchJpaImpl();

	public static DaoMatch getDaoMatch() {
		return daoMatch;
	}

	public static DaoCompte getDaoCompte() {
		return daoCompte;
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
