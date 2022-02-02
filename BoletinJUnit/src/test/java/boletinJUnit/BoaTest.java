package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoaTest {

	Boa s1;
	Boa s2;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Boa("Boa", 2, "raton");
		s2 = new Boa("Cobra", 5, "huevos");
	}

	@Test
	void testIsHealthy() {
		assertEquals(false, s1.isHealthy());
		assertEquals(true, s2.isHealthy());
	}

	@Test
	void testFitsInCage() {
		assertEquals(true, s2.fitsInCage(3));
		assertEquals(false, s2.fitsInCage(3));
	}

}
