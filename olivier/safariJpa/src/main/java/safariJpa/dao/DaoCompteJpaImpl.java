package safariJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.model.Compte;
import safariJpa.util.Context;

public class DaoCompteJpaImpl implements DaoCompte {

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Compte> query = em.createQuery("from Compte compte", Compte.class);
		List<Compte> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Compte findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Compte fiche = em.find(Compte.class, key);
		em.close();
		return fiche;
	}

	@Override
	public void insert(Compte obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Compte update(Compte obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Compte obj) {
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
		em.remove(em.find(Compte.class, key));
		tx.commit();
		em.close();
	}

}
