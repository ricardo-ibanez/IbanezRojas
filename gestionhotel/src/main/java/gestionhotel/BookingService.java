package gestionhotel;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingService.
 */
public class BookingService {
	Scanner sc = new Scanner(System.in);
	/** The hotel. */
	private Hotel hotel;
	private final HabitacionDAOImplement hd = new HabitacionDAOImplement();
	private final ClientesDAOImplement cd = new ClientesDAOImplement();
	private final ReservasDAOImplement rd = new ReservasDAOImplement();
	
	
	
	
	/**
	 * Instantiates a new booking service.
	 */
	public BookingService() {
		
	}
	
	
	
	

	/**
	 * Consultar disponibilidad.
	 *
	 * @param numPersona the num persona
	 * @param fechaEntrada the fecha entrada
	 * @param fechaSalida the fecha salida
	 * @return the array list
	 */
	public Habitacion consultarDisponibilidad(int numPersona,LocalDate fechaEntrada, LocalDate fechaSalida) {
		boolean posReserva = false;
		ArrayList<Habitacion> habitaciones= hd.obtenerTodo();
		
		Habitacion h = new Habitacion();
		
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
				h = habitaciones.get(i);
			}
			
			
		}
		
		if(posReserva) {
			System.out.println("Habitacion disponible");
		}else {
			System.out.println("Habitacion no disponible");
		}
		
		return h;
		
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
	public void reservarHabitacion(Habitacion h,String dniCliente,LocalDate fechaEntrada, LocalDate fechaSalida,int personas) {
		
		/*
		 * crear nuevo metodo para comprobar que existe el cliente y sacarlo de este metodo
		 */
		Reservas reserva = new Reservas(fechaEntrada,fechaSalida);
		boolean existeCliente = false;
		Clientes c = null;
		
		
		
		
		
		
		for(int i=0;i<cd.obtenerTodo().size();i++) {
			if(cd.obtenerTodo().get(i).getDni().equals(dniCliente)) {
				reserva.setCliente(cd.obtenerTodo().get(i));
				c= cd.obtenerTodo().get(i);
				
				
				existeCliente=true;
				break;
				
			}
			
		}
		if(existeCliente) {
			//reserva.setcReserva(Integer.parseInt(UUID.randomUUID().toString()));
			reserva.setcReserva((int) (Math.random() * (999999999 - 1)) + 1); //();
			reserva.setFechaEntrada(fechaEntrada);
			reserva.setFechaSalida(fechaSalida);
			reserva.setHabitacion(null);
			reserva.setCliente(c);
			reserva.setNumPersonas(personas);
			if(h.getEstado().equals("normal")) {
				reserva.setHabitacion(h);
			}else if(h.getEstado().equals("business")) {
				reserva.setHabitacion(h);
			}else if(h.getEstado().equals("superior")) {
				reserva.setHabitacion(h);
			}
			h.setEstado("ocupada");
			rd.anadirReserava(reserva);
			System.out.println("Reserva "+ reserva.getcReserva()+ " confirmada para las fechas desde "+reserva.getFechaEntrada()+" hasta "+reserva.getFechaSalida()+" para "+reserva.getNumPersonas());
			
		}else {
			
			System.out.println("Registre los datos del nuevo cliente ");
			
		}
		if (!existeCliente){
			//no existe el cliente
				
				
				System.out.println("Introduzca nombre");
				String nombre = sc.nextLine();
				
				System.out.println("Introduzca apellido");
				String apellido = sc.nextLine();
				
				
				
				System.out.println("Introduzca edad");
				int edad = sc.nextInt();
				sc.nextLine();
				
				c = new Clientes(nombre,apellido,dniCliente,edad);
				
				existeCliente = true;
				
				cd.anadirCliente(c);
				reserva.setcReserva((int) (Math.random() * (999999999 - 1)) + 1); //();
				reserva.setFechaEntrada(fechaEntrada);
				reserva.setFechaSalida(fechaSalida);
				//reserva.setHabitacion(null);
				reserva.setCliente(c);
				reserva.setNumPersonas(personas);
				
				if(h.getEstado().equals("normal")) {
					reserva.setHabitacion(h);
				}else if(h.getEstado().equals("business")) {
					reserva.setHabitacion(h);
				}else if(h.getEstado().equals("superior")) {
					reserva.setHabitacion(h);
				}
				h.setEstado("ocupada");
				rd.anadirReserava(reserva);
				
				
				
				
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
