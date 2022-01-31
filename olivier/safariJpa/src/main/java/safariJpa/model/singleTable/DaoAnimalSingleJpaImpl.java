package safariJpa.model.singleTable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.util.Context;

public class DaoAnimalSingleJpaImpl implements DaoAnimalSingle {

	@Override
	public List<AnimalSingle> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<AnimalSingle> query = em.createQuery("from Animal a", AnimalSingle.class);
		List<AnimalSingle> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public AnimalSingle findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		AnimalSingle animal = em.find(AnimalSingle.class, key);
		em.close();
		return animal;
	}

	@Override
	public void insert(AnimalSingle obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public AnimalSingle update(AnimalSingle obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(AnimalSingle obj) {
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
		em.remove(em.find(AnimalSingle.class, key));
		tx.commit();
		em.close();
	}

}
