package formationJpa;

import org.springframework.beans.factory.annotation.Autowired;

import formationJpa.dao.DaoDepartement;
import formationJpa.model.Departement;

public class AppSpring {

	@Autowired
	private DaoDepartement daoDepartment;

	public void run(String... args) {
		System.out.println(daoDepartment.findAll());
	}
}
