package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.model.Employe;
import formationJpa.util.Context;

public class DaoEmployeJpaImpl implements DaoEmploye {

	@Override
	public List<Employe> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Employe> query = em.createQuery("from Employe e", Employe.class);
		List<Employe> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Employe findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Employe obj = em.find(Employe.class, key);
		em.close();
		return obj;
	}

	@Override
	public void insert(Employe obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Employe update(Employe obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Employe obj) {
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
		em.remove(em.find(Employe.class, key));
		tx.commit();
		em.close();
	}

}
