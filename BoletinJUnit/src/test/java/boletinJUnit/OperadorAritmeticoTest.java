package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	int a;
	int b;
	int c;
	Exception e;

	@BeforeEach
	public void init() {
		a = 4;
		b = 2;
		c = 0;

	}

	@Test
	void testSuma() {

		assertEquals(6, OperadorAritmetico.suma(a, b));

	}

	@Test
	public void division() {

		try {

			assertEquals(2, OperadorAritmetico.division(a, b));
		} catch (Exception e) {
			fail("No debería fallar");
		}

	}

	public void divisionException() {
		try {

			assertEquals(0, OperadorAritmetico.division(a, c));
			fail("El dividendo no puede ser 0");
		} catch (Exception e) {

			assertEquals(true, e.getMessage());
		}

	}

}
