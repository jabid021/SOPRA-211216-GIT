package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formationJpa.model.Departement;
import formationJpa.model.Employe;

@Repository
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

	@PersistenceContext
	private EntityManager em;

	public void desExempleDeRequete() {
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
		TypedQuery<Employe> query = em.createQuery("from Employe e", Employe.class);
		List<Employe> list = query.getResultList();
		return list;
	}

	@Override
	public Employe findByKey(Long key) {
		Employe obj = em.find(Employe.class, key);
		return obj;
	}

	@Override
	@Transactional
	public void insert(Employe obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Employe update(Employe obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Employe obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Employe.class, key));
	}

	@Override
	public List<Employe> findByNom(String nom) {
		TypedQuery<Employe> query = em.createNamedQuery("Employe.findByNom", Employe.class);
		query.setParameter("nom", nom);
		List<Employe> list = query.getResultList();
		return list;
	}

	@Override
	public List<Employe> findByDepartement(Departement departement) {
		TypedQuery<Employe> query = em.createQuery(
				"select e from Employe e left join fetch e.departement as d where d=:departement", Employe.class);
		query.setParameter("departement", departement);
		List<Employe> list = query.getResultList();
		return list;
	}

}
