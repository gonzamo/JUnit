package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoaTestParametrizado {

	Boa bicha;
	Boa bicha2;

	@BeforeEach
	void setUp() throws Exception {
		bicha = new Boa("Boa", 2, "huevo");
		bicha2 = new Boa("Cobra", 5, "pajaros");
	}

	@ParameterizedTest(name = "Test IsHealthy")
	@CsvSource({
			"Boa1,    	 7,   chocolate,   	  false",
			"Cobra1,    5,   pajaros,   true",
			"Boa2,        7,   chuches,        false",
			"Cobra2,    5,   chocolate,      false",
			"Boa3,        7,   huevo,   true",
			"Cobra3,    5,   chuches,        false",
			"Boa4,        7,   chuches,        false",
			"Cobra4,    5,   pajaros,   true"
			
	})
	
	void testIsHealthy1(String nombre,int medidas,String comida, boolean expectedResult) throws Exception {
		bicha = new Boa(nombre,medidas,comida);
		
		assertEquals(expectedResult, bicha.isHealthy());
	}
	

	@ParameterizedTest(name = "Test FitsInCage")
	@CsvSource({
			"Boa,    	2,    3,     huevo,    true",
			"Diamantina,    5,   3,   pajaros,   false"
			
	})
	void testFitsInCage2(String nombre,int medidas,int cageLength,String comida, boolean expectedResult) throws Exception {
		bicha = new Boa(nombre,medidas,comida);
		
		assertEquals(expectedResult, bicha.fitsInCage(cageLength));
	}

}
