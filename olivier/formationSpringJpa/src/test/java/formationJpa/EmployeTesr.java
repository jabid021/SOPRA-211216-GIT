package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import formationJpa.config.AppConfig;
import formationJpa.model.Adresse;
import formationJpa.model.Civilite;
import formationJpa.model.Departement;
import formationJpa.model.Employe;
import formationJpa.repositories.DepartementRepository;
import formationJpa.repositories.EmployeRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class EmployeTesr {

	@Autowired
	private EmployeRepository empRepo;
	@Autowired
	private DepartementRepository deptRepo;

	@Test
	@Disabled
	void test() {
		Employe e = new Employe("test", "test", 10000, LocalDate.now(), Civilite.M,
				new Adresse("11", "rue 11", "11111", "11111"));
		Departement d = new Departement("pour test");
		e.setDepartement(d);
		deptRepo.save(d);
		empRepo.save(e);
	}

}
