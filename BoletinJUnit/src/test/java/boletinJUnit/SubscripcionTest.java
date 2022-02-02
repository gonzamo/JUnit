package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubscripcionTest {

	Subscripcion s1;
	Subscripcion s2;
	Subscripcion s3;
	Subscripcion s4;

	@BeforeEach
	public void setUp() {
		s1 = new Subscripcion(0, 1);
		s2 = new Subscripcion(5, 0);
		s3 = new Subscripcion(5, 1);
		s4 = new Subscripcion(5, 2);
	}

	@Test
	public void testPrecioPorMes() {
		assertEquals(0.0, s1.precioPorMes());
		assertEquals(0.0, s2.precioPorMes());
		assertEquals(5.0, s3.precioPorMes());
		assertEquals(3.5, s4.precioPorMes());

	}

// He tenido que añadir el método getPeriodo para poder testear el método Cancel

	@Test
	public void testCancel() {
		Subscripcion s3 = new Subscripcion(5, 1);
		s3.cancel();
		assertEquals(0, s3.getPeriodo());

	}

}
