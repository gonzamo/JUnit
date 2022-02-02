package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FridgeTest {

	Fridge nevera;
	private Collection<String> food = new HashSet<String>();

	@BeforeEach
	void setUp() throws Exception {
		nevera = new Fridge();
		food.add("Fanta");
		food.add("Jamon");
		food.add("Chorizo");
	}

	@Test
	void testPut() {
		nevera.put("Fanta");
		assertEquals(true, nevera.contains("Fanta"));
	}

	@Test
	void testContains() {
		nevera.put("Fanta");
		assertEquals(true, nevera.contains("Jamon"));
		assertEquals(false, nevera.contains("Chorizo"));
	}

	@Test
	void testTake() {
		try {
			nevera.put("Jamon");
			assertEquals(true, nevera.contains("Jamon"));
			nevera.take("Jamon");
			assertEquals(false, nevera.contains("Jamon"));
		} catch (Exception e) {
			fail("No debería fallar");
		}
	}
	
	@Test
	void testTakeException() {
		try {
			nevera.take("Jamon");
			fail("No hay en el frigorífico");
		} catch (Exception e) {
			assertEquals(true, e.getMessage().contains("Jamon"));
		}
	}

}
