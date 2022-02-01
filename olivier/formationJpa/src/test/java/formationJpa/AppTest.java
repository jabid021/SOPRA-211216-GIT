package formationJpa;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formationJpa.dao.DaoDepartement;
import formationJpa.dao.DaoEmploye;
import formationJpa.model.Adresse;
import formationJpa.model.Civilite;
import formationJpa.model.Departement;
import formationJpa.model.Employe;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {

		DaoDepartement daoDepartement = Context.getDaoDepartment();

		DaoEmploye daoEmploye = Context.getDaoEmploye();

		daoEmploye.insert(new Employe("King", "AD_PRES", 20000, LocalDate.of(2000, Month.JANUARY, 20), Civilite.M,
				new Adresse("100", "rue XXX", "11111", "ville")));

		Employe e = daoEmploye.findByKey(100L);
		System.out.println(e.getNom());
		System.out.println(e.getCivilite());
		System.out.println(e.getAdresse().getRue());

		e.setAdresse(new Adresse("1111", "avenue eeee", "66666", "autre ville"));
		daoEmploye.update(e);
		
		Departement departement=new Departement("info");
		daoDepartement.insert(departement);
		
		e.setDepartement(departement);
		daoEmploye.update(e);

		System.out.println("--------------");
		e=daoEmploye.findByKey(100L);
		System.out.println(e.getDepartement());
		System.out.println("-------------");
		daoDepartement.findByKey(100L);
		
		Employe bob=new Employe("Bob", "SA_REP", 10000, LocalDate.of(2000, Month.JANUARY, 20), Civilite.M,
				new Adresse("100", "rue XXX", "11111", "ville"));
		bob.setManager(e);
		daoEmploye.insert(bob);
		System.out.println("-------------------");
		daoEmploye.findByKey(bob.getId());
		Context.destroy();
	}
}
