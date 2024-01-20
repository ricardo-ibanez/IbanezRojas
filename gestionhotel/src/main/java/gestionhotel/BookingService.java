package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingService {
	
	private Hotel hotel;
	
	public BookingService(Hotel hotel) {
		
		
		this.hotel = hotel;
	}
	
	
	
	
	public void consultarDisponibilidad(int numPersona,LocalDate fechaEntrada, LocalDate fechaSalida) {
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
			//Comprobar la fecha de la disponibilidad es valida
			if(fechaEntrada.isBefore(fechaSalida)) {
				
				posReserva= true;
			}else {
				
				posReserva= false;
				
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
