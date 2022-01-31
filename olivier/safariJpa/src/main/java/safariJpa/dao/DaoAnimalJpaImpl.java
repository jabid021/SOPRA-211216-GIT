package safariJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.model.Animal;
import safariJpa.util.Context;

public class DaoAnimalJpaImpl implements DaoAnimal {

	@Override
	public List<Animal> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Animal> query = em.createQuery("from Animal a", Animal.class);
		List<Animal> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Animal findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Animal animal = em.find(Animal.class, key);
		em.close();
		return animal;
	}

	@Override
	public void insert(Animal obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Animal update(Animal obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Animal obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Animal.class, key));
		tx.commit();
		em.close();
	}

}
