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
		
	}

}
