package safariJpa.model.tablePerClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import safariJpa.util.Context;

public class DaoAnimalTablePerClassJpaImpl implements DaoAnimalTablePerClass {

	@Override
	public List<AnimalTablePerClass> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<AnimalTablePerClass> query = em.createQuery("from AnimalTablePerClass a", AnimalTablePerClass.class);
		List<AnimalTablePerClass> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public AnimalTablePerClass findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		AnimalTablePerClass animal = em.find(AnimalTablePerClass.class, key);
		em.close();
		return animal;
	}

	@Override
	public void insert(AnimalTablePerClass obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public AnimalTablePerClass update(AnimalTablePerClass obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(AnimalTablePerClass obj) {
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
		em.remove(em.find(AnimalTablePerClass.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public List<ChienTablePerClass> findAllChien() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<ChienTablePerClass> query = em.createQuery("from ChienTablePerClass a", ChienTablePerClass.class);
		List<ChienTablePerClass> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<ChatTablePerClass> findAllChat() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		TypedQuery<ChatTablePerClass> query = em.createQuery("from ChatTablePerClass a", ChatTablePerClass.class);
		List<ChatTablePerClass> list = query.getResultList();
		em.close();
		return list;
	}

}
