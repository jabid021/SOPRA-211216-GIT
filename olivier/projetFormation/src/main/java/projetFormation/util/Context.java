package projetFormation.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
	private static EntityManagerFactory emf = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("formation");
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
