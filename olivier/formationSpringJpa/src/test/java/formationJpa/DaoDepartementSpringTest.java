package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import formationJpa.config.AppConfig;
import formationJpa.dao.DaoDepartement;
import formationJpa.model.Departement;

@ContextConfiguration(classes = { AppConfig.class })
@ExtendWith(SpringExtension.class)
class DaoDepartementSpringTest {

	@Autowired
	private DaoDepartement daoDepartement;

	@Test
	void test() {
		assertNotNull(daoDepartement);
	}

	@Test
	@Transactional
	@Commit
	void insert() {
		Departement d = new Departement("departement test 229999922");
		assertNull(d.getId());
		daoDepartement.insert(d);
		assertNotNull(d.getId());
		assertNotNull(daoDepartement.findByKey(d.getId()));
	}

//	@Test
//	void find() {
//		assertNotNull(daoDepartement.findByKey(1L));
//	}

}
