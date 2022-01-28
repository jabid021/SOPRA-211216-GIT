package safariJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import safariJpa.model.Animal;

public class AppTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("safari");
		// execution de requete avec JPA

		// l'EntityManager execute les requetes
		EntityManager em = emf.createEntityManager();

		// select avec la cle primaire
		// em.find(Entity.class, cle)
		// em.find(Animal.class, 1L);

		// LMD besoin d'une trasaction

		// insert
		Animal animal = new Animal(1L, null);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(animal);// se traduit par insert
		animal.setRace("chat");
		tx.commit();
		animal.setRace("mouton");

		// (update) rattacher un objet à la base
		tx = em.getTransaction();
		tx.begin();
		animal=em.merge(animal);
		animal.setRace("vache");
		tx.commit();
		
		//delete
		tx=em.getTransaction();
		tx.begin();
		em.remove(animal);
		tx.commit();

		emf.close();
	}

}
