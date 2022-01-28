package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.dao.DaoDepartement;
import formationJpa.model.Departement;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {

		DaoDepartement daoDepartement = Context.getDaoDepartment();

		Departement d = new Departement();
		d.setId(12L);
		d.setNom("un nom ");

		daoDepartement.insert(d);

		System.out.println(daoDepartement.findAll());

		daoDepartement.delete(d);
		Context.destroy();
	}
}
