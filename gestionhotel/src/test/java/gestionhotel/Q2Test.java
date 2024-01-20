package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class Q2Test {

	@Test
	void test() {
		Hotel ho = new Hotel();
		Habitacion ha = new Habitacion();
		ho.agregarHabitacion(ha);
		BookingService bs = new BookingService(ho);
		bs.reservarHabitacion(ha, "75778905T", LocalDate.parse("2023-12-12"),LocalDate.parse("2023-12-14"));
		
	}

}
