package safariJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.model.Fiche;
import safariJpa.util.Context;

public class DaoFicheJpaImpl implements DaoFiche {

	@Override
	public List<Fiche> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Fiche> query = em.createQuery("from Fiche fiche", Fiche.class);
		List<Fiche> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Fiche findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Fiche fiche = em.find(Fiche.class, key);
		em.close();
		return fiche;
	}

	@Override
	public void insert(Fiche obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Fiche update(Fiche obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Fiche obj) {
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
		em.remove(em.find(Fiche.class, key));
		tx.commit();
		em.close();
	}

}
