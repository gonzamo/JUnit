package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTest {

	Debito debito;
	Cuenta cuenta;

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1111.2222.12.1234567890", "Pepe");

		String caducidad = "25/06/2025";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());
		debito = new Debito("1234567890123456", "Pepe", fechaCaducidad);

		debito.setCuenta(cuenta);
	}

	@Test
	void testRetirar() {
		
		
		try {
			debito.ingresar(1000);
			debito.retirar(500.0);
			assertEquals(500, debito.getSaldo());
		} catch (Exception e) {
			fail("No deberia fallar");
		}
	}

	@Test
	void testIngresar() {
		try {
			debito.ingresar(1000.0);
			assertEquals(1500, debito.getSaldo());
		} catch (Exception e) {
			fail("No deberia fallar");
		}
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			debito.ingresar(1000.0);
			debito.pagoEnEstablecimiento("floristeria", 500);
			assertEquals(2000, debito.getSaldo());
		} catch (Exception e) {
			fail("No deberia fallar");
		}
	}

	@Test
	void testGetSaldo() {
		try {
			debito.ingresar(1000.0);
			assertEquals(3000.0, debito.getSaldo());
		} catch (Exception e) {
		}

		
	}

}
