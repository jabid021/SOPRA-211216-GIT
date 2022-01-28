package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.model.Departement;
import formationJpa.util.Context;

public class DaoDepartementJpaImplementation implements DaoDepartement {

	@Override
	public List<Departement> findAll() {
		// requete jpql
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// Query query=em.createQuery("select d from Departement d");
		//Query query = em.createQuery("from Departement d");
		TypedQuery<Departement> query=em.createQuery("from Departement d", Departement.class);
		List<Departement> departements = query.getResultList();
		em.close();
		return departements;
	}

	@Override
	public Departement findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Departement departement = em.find(Departement.class, key);
		em.close();
		return departement;
	}

	@Override
	public void insert(Departement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Departement update(Departement obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Departement obj) {
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
		em.remove(em.find(Departement.class, key));
		tx.commit();
		em.close();
	}

}
