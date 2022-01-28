package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.model.Departement;

public class AppTest {
	public static void main(String[] args) {
		// lancement de JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoPU");
		
		EntityManager em=emf.createEntityManager();
		Departement dept= em.find(Departement.class, 100L);
		System.out.println(dept);
		//arret JPA
		emf.close();
	}
}
