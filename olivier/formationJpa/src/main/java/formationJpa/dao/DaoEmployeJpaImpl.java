package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.model.Departement;
import formationJpa.model.Employe;
import formationJpa.util.Context;

public class DaoEmployeJpaImpl implements DaoEmploye {

	// JPQL:
	// mots cles: select, from, where, group by, having, union, join, and, or,order
	// by
	// requete sur des entités
	// select alias.attribut from Class alias=>resultat sera Object[] ou
	// List<Object[]>
	// select alias.attribut1, alias.attribut2 from Class alias
	// select obj from "Class" obj =>resultat sera une instance de la classe "Class"
	// ou List<"Class">

	public void desExempleDeRequete() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select e.id, e.nom from Employe e");
		// query.getResultList() List<Object[]> dans la case 0=>id,case 1=>nom
		query = em.createQuery("select e from Employe e");
		query.getResultList();
		// garanti une List

		query = em.createQuery("from Employe e where e.id=100");
		query.getSingleResult();
		// 1 objet
		// si pas de resultat=>NoResultException
		// si plus d'un resultat=>NonUniqueResultException

		query = em.createQuery("select e from Employe e where e.nom='King'");
		query = em.createQuery("select e from Employe e where lower(e.nom)=lower('King')");
		query = em.createQuery("select e from Employe e where e.nom like 'K%'");
		query = em.createQuery("select e from Employe e where e.nom like 'K%' and e.salaire>5000");
		query = em.createQuery("select e from Employe where e.nom=:nom and e.salaire>:salaire");
		query.setParameter("nom", "King");
		query.setParameter("salaire", 3000);

		query = em.createNativeQuery("requete sql pure");

		query = em.createNamedQuery("Employe.findByNom");
		query.setParameter("nom", "olivier");
	}

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

	@Override
	public List<Employe> findByNom(String nom) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findByNom", Employe.class);
		query.setParameter("nom", nom);
		List<Employe> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Employe> findByDepartement(Departement departement) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<Employe> query = em.createQuery(
				"select e from Employe e left join fetch e.departement as d where d=:departement", Employe.class);
		query.setParameter("departement", departement);
		List<Employe> list = query.getResultList();
		em.close();
		return list;
	}

}
