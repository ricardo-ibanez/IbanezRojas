package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingService {
	
	
	
	
	
	
	
	public void consultarDisponibilidad(int numPersona, Hotel hotel) {
		boolean posReserva = false;
		ArrayList<Habitacion> habitaciones= hotel.getHabitaciones();
		
		//Recorrer habitaciones 1 a 1
		for(int i = 0;i<habitaciones.size();i++) {
			
			//Comprobar estado habitacion
			if(habitaciones.get(i).getEstado() !="libre") {
				posReserva = false;
			}else {
				posReserva = true;
			}
			
			//Comprobar cantidad personas
			if(habitaciones.get(i).getCapacidad() !=numPersona) {
				posReserva = false;
			}else {
				posReserva = true;
			}
			
			if(posReserva) {
				break;
			}
		}
		
		if(posReserva) {
			System.out.println("Habitacion disponible");
		}else {
			System.out.println("Habitacion no disponible");
		}
		
		
	}
	
	
	public void reservarHabitacion() {
		
		
		
	}

}
