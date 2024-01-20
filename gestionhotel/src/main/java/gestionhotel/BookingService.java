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
	
	
	public void reservarHabitacion(Habitacion habitacion,String dniCliente,LocalDate fechaEntrada, LocalDate fechaSalida) {
		Reservas reserva = new Reservas();
		boolean existeCliente = false;
		
		
		for(int i=0;i<hotel.getClientes().size();i++) {
			
			if(hotel.getClientes().get(i).getDni().equals(dniCliente)) {
				reserva.setCliente(hotel.getClientes().get(i));
				existeCliente=true;
				break;
				
			}
			
		}
		if(existeCliente) {
			reserva.setcReserva(2);
			reserva.setFechaEntrada(fechaEntrada);
			reserva.setFechaSalida(fechaSalida);
			reserva.setHabitacion(habitacion);
			reserva.setNumPersonas(habitacion.getCapacidad());
			System.out.println("Reserva"+ reserva.getcReserva()+ "confirmada para las fechas desde"+reserva.getFechaEntrada()+"hasta"+reserva.getFechaSalida()+"con la habitacion"+reserva.getHabitacion()+"para"+reserva.getNumPersonas());
			
		}else {
			
			System.out.println("Registre los datos del nuevo cliente ");
			
		}
		
		
	}
	
	/*public Clientes registrarClientes(String dni, String nombre, String apellido, int edad) {
		
		Clientes c = new Clientes(nombre,apellido,dni,edad);
		
		return c;
	}*/

}
