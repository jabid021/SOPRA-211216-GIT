package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formationJpa.model.Departement;

@Repository
public class DaoDepartementJpaImplementation implements DaoDepartement {

//	@Autowired
//	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Departement> findAll() {
		// requete jpql
		// Query query=em.createQuery("select d from Departement d");
		// Query query = em.createQuery("from Departement d");
		TypedQuery<Departement> query = em.createQuery("from Departement d", Departement.class);
		List<Departement> departements = query.getResultList();
		return departements;
	}

	@Override
	public Departement findByKey(Long key) {
		return em.find(Departement.class, key);
	}

	@Override
	@Transactional
	public void insert(Departement obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Departement update(Departement obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Departement obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Departement.class, key));
	}

	@Override
	public Departement findByIdWithEmploye(Long id) {
		TypedQuery<Departement> query = em.createQuery(
				"select d from Departement d left join fetch d.employes where d.id=:id", Departement.class);
		query.setParameter("id", id);
		Departement d = query.getSingleResult();
		return d;
	}

	@Override
	public List<Departement> findAllWithEmploye() {
		TypedQuery<Departement> query = em
				.createQuery("select distinct d from Departement d left join fetch d.employes", Departement.class);
		List<Departement> list = query.getResultList();
		return list;
	}

	@Override
	public List<Departement> findDepartementAvecLesEmployesQuiGangentPlusDeXEuros(double salaire) {
		TypedQuery<Departement> query = em.createQuery(
				"select distinct d from Departement d left join fetch d.employes as e where e.salaire>:salaire",
				Departement.class);
		query.setParameter("salaire", salaire);
		List<Departement> list = query.getResultList();
		return list;
	}

	@Override
	public List<Departement> findDepartementOuUnEmployeGagnePlusQueSonManager() {
		TypedQuery<Departement> query = em.createQuery(
				"select distinct d from Departement d left join fetch d.employes as e left join fetch e.manager as mgr where e.salaire>mgr.salaire",
				Departement.class);
		List<Departement> list = query.getResultList();
		return list;
	}
}
