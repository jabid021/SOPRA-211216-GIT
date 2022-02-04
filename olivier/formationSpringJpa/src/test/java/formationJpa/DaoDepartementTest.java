package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpa.config.AppConfig;
import formationJpa.dao.DaoDepartement;
import formationJpa.model.Departement;

class DaoDepartementTest {

	private static AnnotationConfigApplicationContext ctx = null;
	private DaoDepartement daoDepartement;

	@BeforeAll
	public static void setup() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterAll
	public static void close() {
		ctx.close();
	}

	@BeforeEach
	public void initDaoDepartement() {
		daoDepartement = ctx.getBean(DaoDepartement.class);
	}

	@Test
	public void getDaoDepartment() {
		assertNotNull(daoDepartement);
		Departement d=daoDepartement.findByKey(1000L);
		if(d!=null) {
			System.out.println(d.getId());
		}
	}

	@Test
	public void insertDepartement() {
		
	}
}
