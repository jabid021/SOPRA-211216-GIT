package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpa.config.AppConfig;
import formationJpa.dao.DaoDepartement;

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
	}

	@Test
	public void insertDepartement() {
		
	}
}
