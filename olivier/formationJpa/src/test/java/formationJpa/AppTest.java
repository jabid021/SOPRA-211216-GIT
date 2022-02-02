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
		Departement info = new Departement("info");
		daoDepartement.insert(info);

		DaoEmploye daoEmploye = Context.getDaoEmploye();

		Employe king = new Employe("King", "AD_PRES", 20000, LocalDate.of(2000, Month.JANUARY, 20), Civilite.M,
				new Adresse("100", "rue XXX", "11111", "ville"));
		daoEmploye.insert(king);

		king.setCivilite(Civilite.MME);
		Employe employeEnBase = daoEmploye.findByKey(king.getId());
		employeEnBase.setCivilite(king.getCivilite());
		king = daoEmploye.update(employeEnBase);
		king.setSalaire(30000);
		king.setDepartement(info);
		king = daoEmploye.update(king);

		daoEmploye.findByNom("King").forEach(e -> {
			System.out.println(e.getDepartement());
		});
		System.out.println("-----------------");
		System.out.println(daoDepartement.findByIdWithEmploye(info.getId()).getEmployes());
		Employe e = new Employe("Abbb", "SA_REP", 1000000, LocalDate.of(2000, Month.JANUARY, 20), Civilite.M,
				new Adresse("100", "rue XXX", "11111", "ville"));
		e.setDepartement(info);
		e.setManager(king);
		daoEmploye.insert(e);
		System.out.println("-----------------");
		System.out.println(daoDepartement.findByIdWithEmploye(info.getId()).getEmployes());

		Departement direction = new Departement("direction");
		daoDepartement.insert(direction);
		System.out.println("------   direction  ----------");
		System.out.println(daoDepartement.findByKey(direction.getId()));
		System.out.println("------   direction  ----------");

		System.out.println(daoDepartement.findByIdWithEmploye(direction.getId()));
		System.out.println("-----------findAll-------------");
		e = new Employe("Abbb", "SA_REP", 1000, LocalDate.of(2000, Month.JANUARY, 20), Civilite.M,
				new Adresse("100", "rue XXX", "11111", "ville"));
		e.setDepartement(direction);
		daoEmploye.insert(e);
		System.out.println(daoDepartement.findDepartementOuUnEmployeGagnePlusQueSonManager());
		System.out.println("-----------------------");
		System.out.println(daoEmploye.findByDepartement(info));
		Context.destroy();
	}
}
