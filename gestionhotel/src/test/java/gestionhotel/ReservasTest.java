package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservasTest {

	@Test
	void test() {
		Reservas r = new Reservas();
		assertEquals(r.getcReserva(), 1234);
	}

}
