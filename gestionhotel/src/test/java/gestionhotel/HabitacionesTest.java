package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HabitacionesTest {

	@Test
	void test() {
		Habitacion h = new Habitacion();
		
		assertEquals(h.getEstado(), "libre");
	}

}
