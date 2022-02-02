package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	Account a;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();

	@BeforeEach
	void setUp() throws Exception {
		a = new Account("Luis", 4444444, 2.5f);
	}

	@Test
	void testDeposit() {
		assertEquals(false, a.deposit(-3f));
		assertEquals(true, a.deposit(5f));

	}

	
	
	@Test
	void testWithdraw() {
		assertEquals(false, a.withdraw(-2f, -1f));
		assertEquals(true, a.withdraw(2f, 1f));


	}

	@Test
	void testAddInterest() {
		a.addInterest();
		assertEquals(2.5f + (2.5f * 0.045f), a.getBalance());
	}

	@Test
	void testGetBalance() {
		assertEquals(2.5f, a.getBalance());
	}

	@Test
	void testGetAccountNumber() {
		assertEquals(4444444, a.getAccountNumber());
	}

	@Test
	void testToString() {
		assertEquals(4444444 + "\t" + "Luis" + "\t" + fmt.format(2.5f), a.toString());
	}

}
