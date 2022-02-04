package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExempleTest {

	private int n;
	
	@BeforeEach
	void beforeEach() {
		System.out.println("@beforeEach");
		n=0;
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("@afterEach");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("@beforeAll");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("@AfterAll");
	}
	
	@Test
	@DisplayName("Levee ArithmeticException sur division par 0")
	void test() {
		assertThrows(ArithmeticException.class, () -> {
			double d = 5 / 0;
		});
	}

	@Test
	//@Disabled
	void test2() {
		int n = 2 + 3;
		assertEquals(5, n);
	}

}
