package formationJpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.dao.DaoDepartement;
import formationJpa.dao.DaoDepartementJpaImplementation;

public class Context {

	private static EntityManagerFactory emf = null;

	private static DaoDepartement daoDepartment = new DaoDepartementJpaImplementation();

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("demoPU");
		}
		return emf;
	}

	public static void destroy() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}

	public static DaoDepartement getDaoDepartment() {
		return daoDepartment;
	}
}
