package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class Q1Test {

	@Test
	void test() {
		Hotel ho = new Hotel();
		Habitacion ha = new Habitacion();
		ho.agregarHabitacion(ha);
		BookingService bs = new BookingService(ho);
		bs.consultarDisponibilidad(1, LocalDate.parse("2023-12-12"),LocalDate.parse("2023-12-14"));
		
	}

}
