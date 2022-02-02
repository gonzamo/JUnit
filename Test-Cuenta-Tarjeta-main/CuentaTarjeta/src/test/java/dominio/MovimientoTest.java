package dominio;

import static org.junit.jupiter.api.Assertions.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	
	Movimiento m;
	
	

	@BeforeEach
	void setUp() throws Exception {
		m = new Movimiento();
	}



	@Test
	void testGetImporte() {
		m.setImporte(10.0);
		assertEquals(10.0, m.getImporte());
	}

	@Test
	void testGetConcepto() {
		m.setConcepto("Ingreso");
		assertEquals("Ingreso", m.getConcepto());
	}

	@Test
	void testSetConcepto() {
		m.setConcepto("Retiro");
		assertEquals("Retiro", m.getConcepto());
	}

	@Test
	void testGetFecha() throws ParseException {
		String fecha = "25/06/2025";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date f = formato.parse(fecha);
		m.setFecha(f);
		assertEquals("Jun 25 24:00:00 CET 2025" , m.getFecha());
	}

	@Test
	void testSetFecha() {
		fail("Not yet implemented");
	}

	@Test
	void testSetImporte() {
		m.setImporte(100.0);
		assertEquals(100.0, m.getImporte());
	}

}
