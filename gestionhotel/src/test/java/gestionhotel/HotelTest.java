package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HotelTest {

	@Test
	void testHabitaciones() {
		Habitacion ha = new Habitacion();
		Hotel h = new Hotel();
		h.agregarHabitacion(ha);
		assertEquals(h.getHabitaciones().size(),1);
	}

	@Test
	void testClientes() {
		
		Hotel h = new Hotel();
		h.setClientes(new ArrayList<Clientes>());
		assertEquals(h.getClientes().size(),0);
	}
}
