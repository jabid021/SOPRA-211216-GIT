package safariJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.model.Match;
import safariJpa.model.MatchKey;
import safariJpa.util.Context;

public class DaoMatchJpaImpl implements DaoMatch {

	@Override
	public List<Match> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Match> query = em.createQuery("from Match match", Match.class);
		List<Match> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Match findByKey(MatchKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Match fiche = em.find(Match.class, key);
		em.close();
		return fiche;
	}

	@Override
	public void insert(Match obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Match update(Match obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Match obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(MatchKey key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Match.class, key));
		tx.commit();
		em.close();
	}

}
