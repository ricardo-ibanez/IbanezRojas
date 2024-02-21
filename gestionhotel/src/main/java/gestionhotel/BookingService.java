package gestionhotel;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingService.
 */
public class BookingService {
	
	/** The hotel. */
	private Hotel hotel;
	private final HabitacionDAOImplement hd = new HabitacionDAOImplement();
	private final ClientesDAOImplement cd = new ClientesDAOImplement();
	private final ReservasDAOImplement rd = new ReservasDAOImplement();
	
	
	/**
	 * Instantiates a new booking service.
	 */
	public BookingService() {
		HabitacionDAOImplement h = new HabitacionDAOImplement();
		h.guardarHabitacion(new Habitacion("libre",2,"normal",75,null));
		h.guardarHabitacion(new Habitacion("libre",2,"business",100,null));
		h.guardarHabitacion(new Habitacion("libre",2,"superior",150,null));
		h.guardarHabitacion(new Habitacion("libre",2,"business",100,null));
		h.guardarHabitacion(new Habitacion("libre",2,"normal",75,null));
		h.guardarHabitacion(new Habitacion("ocupada",2,"superior",150,null));
		h.guardarHabitacion(new Habitacion("libre",2,"superior",150,null));
		h.guardarHabitacion(new Habitacion("libre",2,"business",100,null));
		h.guardarHabitacion(new Habitacion("libre",2,"normal",75,null));
	}
	
	
	
	

	/**
	 * Consultar disponibilidad.
	 *
	 * @param numPersona the num persona
	 * @param fechaEntrada the fecha entrada
	 * @param fechaSalida the fecha salida
	 * @return the array list
	 */
	public ArrayList<Habitacion> consultarDisponibilidad(int numPersona,LocalDate fechaEntrada, LocalDate fechaSalida) {
		boolean posReserva = false;
		ArrayList<Habitacion> posibleReserva = new ArrayList<Habitacion>();
		ArrayList<Habitacion> habitaciones= hd.obtenerTodo();
		
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
				posibleReserva.add(habitaciones.get(i));
			}
			
			
		}
		
		if(posReserva) {
			System.out.println("Habitacion disponible");
		}else {
			System.out.println("Habitacion no disponible");
		}
		
		return posibleReserva;
		
		/*
		 * Tener en cuenta las reservas
		 * 
		 */
		
		
	}
	
	
	/**
	 * Reservar habitacion.
	 *
	 * @param habitacion the habitacion
	 * @param dniCliente the dni cliente
	 * @param fechaEntrada the fecha entrada
	 * @param fechaSalida the fecha salida
	 */
	public void reservarHabitacion(Habitacion habitacion,String dniCliente,LocalDate fechaEntrada, LocalDate fechaSalida) {
		
		/*
		 * crear nuevo metodo para comprobar que existe el cliente y sacarlo de este metodo
		 */
		Reservas reserva = new Reservas();
		boolean existeCliente = false;
		
		
		for(int i=0;i<hotel.getClientes().size();i++) {
			
			if(hotel.getClientes().get(i).getDni().equals(dniCliente)) {
				reserva.setCliente(hotel.getClientes().get(i));
				habitacion.setC(hotel.getClientes().get(i));
				hd.modificarHabitacion(habitacion);
				existeCliente=true;
				break;
				
			}
			
		}
		if(existeCliente) {
			reserva.setcReserva(2);
			reserva.setFechaEntrada(fechaEntrada);
			reserva.setFechaSalida(fechaSalida);
			reserva.setHabitacion(null);
			
			reserva.setNumPersonas(habitacion.getCapacidad());
			rd.anadirReserava(reserva);
			System.out.println("Reserva"+ reserva.getcReserva()+ "confirmada para las fechas desde"+reserva.getFechaEntrada()+"hasta"+reserva.getFechaSalida()+"con la habitacion"+reserva.getHabitacion()+"para"+reserva.getNumPersonas());
			
		}else {
			
			System.out.println("Registre los datos del nuevo cliente ");
			
		}
		
		
	}
	private double realizarCheckOut(String dni) {
        double precioTotal = 0;
        for (Habitacion hbt : hd.obtenerTodo()) {
            if (hbt.getC() != null && hbt.getC().getDni().equals(dni)) {
                for (Reservas reser : rd.obtenerTodo()) {
                   
                    if (reser.getHabitacion().equals(hbt)) {
                        long diasReservados = ChronoUnit.DAYS.between(reser.getFechaEntrada(), reser.getFechaSalida());
                        precioTotal += diasReservados * reser.getHabitacion().getPrecio();
                        
                        rd.modificarReserva(reser);
                        hbt.setEstado("libre");
                        hbt.setC(null);
                        hd.modificarHabitacion(hbt);
                        return precioTotal;
                    }else {
                        System.err.println("No puedes hacer checkout de una reserva que ya se hizo checkout.");
                    }
                }
                
            }
        }
        return precioTotal;
    }

	private boolean realizarCheckIn(int codigo) {
        

        for (Reservas reservas : rd.obtenerTodo()) {
            if (reservas != null && reservas.getcReserva() == codigo) {
                if (reservas.getFechaEntrada().isAfter(LocalDate.now())) {
                    System.err.println("La fecha de inicio de la reserva no es válida para el check-in.");
                    return false;
                }

                for (Reservas res : rd.obtenerTodo()) {
                    if (res.getcReserva() == codigo) {
                        for (Habitacion habitacion : hd.obtenerTodo()) {
                            if (habitacion.getC() != null
                                    && habitacion.getC().getDni().equals(res.getCliente().getDni())) {
                                habitacion.setEstado("ocupado");
                                res.setHabitacion(habitacion);
                                hd.modificarHabitacion(habitacion);
                                rd.modificarReserva(reservas);
                                return true; // Termina el método una vez que se ha realizado el check-in.
                            }
                        }
                    }
                }
            }
        }

        System.err.println("No se encontró ninguna reserva asociada a ese código.");
        return false;
    }
	
	/*public Clientes registrarClientes(String dni, String nombre, String apellido, int edad) {
		
		Clientes c = new Clientes(nombre,apellido,dni,edad);
		
		return c;
	}*/

}
