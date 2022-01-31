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

		Departement d = new Departement("departement test");

		System.out.println(d.getId());
		daoDepartement.insert(d);
		
		
		Departement recherche=daoDepartement.findByKey(100L);
		System.out.println(d.equals(recherche));
	
		Context.destroy();
	}
}
