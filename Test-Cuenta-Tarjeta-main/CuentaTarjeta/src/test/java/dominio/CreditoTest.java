package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTest {

	Cuenta cuenta;
	Credito tarjeta;
	Movimiento mov;

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1111.2222.12.1234567890", "Pepe");
		cuenta.ingresar(1000.0);

		String caducidad = "25/06/2025";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());

		tarjeta = new Credito("1234567890123456", "Pepe", fechaCaducidad, 1000.0);
		tarjeta.setCuenta(cuenta);
	}

	@Test
	void testRetirar() {
		try {
			tarjeta.retirar(100);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(5, tarjeta.getSaldo());
	}

	@Test
	void testIngresar() {
		try {
			tarjeta.ingresar(100);
			assertEquals(100, tarjeta.getSaldo());
			tarjeta.ingresar(50);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(150, tarjeta.getSaldo());
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			tarjeta.pagoEnEstablecimiento("Restaurante", 150);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(150, tarjeta.getSaldo());
	}

	@Test
	void testGetSaldo() {
		try {
			Movimiento m = new Movimiento();
			tarjeta.ingresar(100);
			m.getImporte();
		} catch (Exception e) {
		}
		assertEquals(100.0, tarjeta.getSaldo());
	}

	@Test
	void testGetCreditoDisponible() {
		try {

			tarjeta.retirar(100);

		} catch (Exception e) {
		}
		assertEquals(995.0, tarjeta.getCreditoDisponible());
	}

	 @Test //Este no he sabido hacerlo.

	 void testLiquidar() {
	 try
	 {
     Movimiento m=new Movimiento();
	 tarjeta.liquidar(1, 2021);
	 m.setImporte(50);
	 cuenta.addMovimiento(m);
	 assertEquals(50, m.getImporte());

	 assertEquals("Liquidacion de operaciones tarj. credito, " + 2 + " de " +
	 2921, m.getConcepto());
	 }
	 catch (Exception e)
	 {
	 fail("No deberia fallar");
	 }
	 }

}
