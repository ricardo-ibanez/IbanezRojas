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
	private final HabitacionDAOImplement hd = new HabitacionDAOImplement();
	private final ClientesDAOImplement cd = new ClientesDAOImplement();
	private final ReservasDAOImplement rd = new ReservasDAOImplement();
	private final int[] habitaciones = new int[3];

	/**
	 * Instantiates a new booking service.
	 */
	public BookingService() {

	}

	private void recogerHabitaciones() {
		for (Habitacion habitacion : hd.obtenerTodo()) {
			if (habitacion.getTipo().equals("normal")) {
				habitaciones[0]++;
			} else if (habitacion.getTipo().equals("business")) {
				habitaciones[1]++;
			} else if (habitacion.getTipo().equals("superior")) {
				habitaciones[2]++;
			}

		}
	}

	private void habitacionesValidas(int personas, LocalDate fechaEntrada, LocalDate fechaSalida) {
		for (Habitacion habitacion : hd.obtenerTodo()) {
			if (habitacion.getCapacidad() < personas) {
				decrementarHabitacionPorTipo(habitacion.getTipo());
			}
		}

		for (Reservas reserva : rd.obtenerTodo()) {
			LocalDate reservaFechaEntrada = reserva.getFechaEntrada();
			LocalDate reservaFechaSalida = reserva.getFechaSalida();

			boolean coincideTipoFecha = false;

			// Si la fecha de entrada es anterior a la fecha de salida y la fecha de salida
			// del parámetro es posterior a la de salida
			if (fechaEntrada.isBefore(reservaFechaSalida) && fechaSalida.isAfter(reservaFechaSalida) && !reserva.isReservado()) {
				coincideTipoFecha = true;
			}

			// Si la fecha de entrada del parámetro está entre la fecha de entrada y salida
			// de la reserva
			if (!fechaEntrada.isBefore(reservaFechaEntrada) && !fechaSalida.isAfter(reservaFechaSalida) && !reserva.isReservado()) {
				coincideTipoFecha = true;
			}

			// Si la fecha de fin del parámetro es posterior a la fecha de salida de la
			// reserva
			if (fechaSalida.isAfter(reservaFechaSalida) && !reserva.isReservado()) {
				coincideTipoFecha = true;
			}

			if (coincideTipoFecha) {
				decrementarHabitacionPorTipo(reserva.getTipoHabitacion());
				coincideTipoFecha = false;
			}
		}
	}

	private void decrementarHabitacionPorTipo(String tipoHabitacion) {
		if (tipoHabitacion.equals("normal")) {
			habitaciones[0]--;
		} else if (tipoHabitacion.equals("business")) {
			habitaciones[1]--;
		} else if (tipoHabitacion.equals("superior")) {
			habitaciones[2]--;
		}
	}

	public int consultarDisponibilidad(int nPersonas, LocalDate fechaEntrada, LocalDate fechaSalida) {
		habitaciones[0] = 0;
		habitaciones[1] = 0;
		habitaciones[2] = 0;
		recogerHabitaciones();
		habitacionesValidas(nPersonas, fechaEntrada, fechaSalida);
		System.out.println("------------------");
		System.out.println(habitaciones[0] + " Habitaciones normales (100.00€)");
		System.out.println(habitaciones[1] + " Habitaciones business (150.00€)");
		System.out.println(habitaciones[2] + " Habitaciones superior (200.00€)");
		System.out.println("------------------");

		System.out.println("Opciones de reserva");

		System.out.println("------------------");
		System.out.println("1) Reservar habitacion NORMAL");
		System.out.println("2) Reservar habitacion BUSINESS");
		System.out.println("3) Reservar habitacion SUPERIOR");
		System.out.println("------------------");

		System.out.println("Introduzca una opcion");
		int opc = sc.nextInt();
		return opc;
	}

	public String obtenerTipo(int opc,int personas) {
		String tipo="";
		switch(opc) {
		case 1:
			tipo="normal";
			break;
		case 2:
			tipo="business";
			break;
		case 3:
			tipo="superior";
			break;
		}
		for (Habitacion hab : hd.obtenerTodo()) {
			if (hab != null) {
				if (hab.getTipo().equals(tipo) && hab.getEstado().equals("libre") && hab.getCapacidad()>=personas) {
					return hab.getTipo();
				}
			}
		}
		return null;
	}

	public void registrarCliente(Clientes cliente) {
		cd.anadirCliente(cliente);
	}

	public boolean comprobarDNI(String dni) {
		boolean valido = false;
		for (Clientes cliente : cd.obtenerTodo()) {
			if (cliente.getDni().equals(dni)) {
				valido = true;
				break;
			}
		}
		return valido;
	}

	public int reservarHabitacion(String tipoHabitacion, String dni, LocalDate fechaEntrada, LocalDate fechaSalida,
			int personas) {
		Clientes cliente = localizarCliente(dni);
		double precio = obtenerPrecio(personas, tipoHabitacion);
		System.out.println("Coste de alojamiento es: " + precio);
		sc.nextLine();
		System.out.println("¿quiere continuar?(Y/N)");
		String cont = sc.nextLine();

		if (cont.equalsIgnoreCase("y")) {
			System.out.println("Reserva realizada con exito");
			int codigo = generadorCodigoReserva();
			Reservas reserva = new Reservas(codigo, fechaEntrada, fechaSalida, personas, tipoHabitacion, cliente, null,
					false);
			rd.anadirReserava(reserva);
			return codigo;
		} else {
			System.out.println("Reserva cancelada");
			cd.eliminarCliente(cliente);
		}

		return -1;
	}

	private Clientes localizarCliente(String dni) {
		for (Clientes cliente : cd.obtenerTodo()) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

	private int generadorCodigoReserva() {
		int codigo=0;
		for(Reservas r : rd.obtenerTodo()) {
			while(r.getcReserva()==codigo) {
				codigo=(int)(Math.random()*1000000)+1;
			}
		}
		return codigo;
	}

	private double obtenerPrecio(int personas, String tipoHabitacion) {
		double precio = 0.0;
		for (Habitacion habitacion : hd.obtenerTodo()) {
			if (habitacion.getCapacidad() == personas && habitacion.getTipo().equals(tipoHabitacion)) {
				precio = habitacion.getPrecio();
				break;
			}
		}
		return precio;
	}

	public String realizarCheckin(int codigo) {
		
		return comprobarReserva(codigo);
	}

	private String comprobarReserva(int codigo) {
		Habitacion habitacion = new Habitacion();
		boolean comprobarDia = false,elegida=false;
		for (Reservas reserva : rd.obtenerTodo()) {
			if (reserva.getcReserva()==(codigo)) {
				if (comprobarDia(reserva.getFechaEntrada())) {
					comprobarDia = true;
					for(Habitacion habitaciones : hd.obtenerTodo()) {
						if(habitaciones.getCapacidad()==reserva.getNumPersonas() && habitaciones.getTipo().equals(reserva.getTipoHabitacion()) && elegida==false) {
							habitacion=habitaciones;
							elegida=true;
							reserva.setHabitacion(habitacion);
							habitacion.setEstado("ocupada");
							rd.modificarReserva(reserva);
							hd.modificarHabitacion(habitacion);
						}
					}
				} else {
					comprobarDia = false;
				}
			} else {
				comprobarDia = false;
			}
		}
		if (comprobarDia) {
			return "Estancia confirmada.";
		}else {
			System.err.println("No se encontro ningún código de reserva o hoy no es el día de su reserva.");
			return null;
		}
	}

	private boolean comprobarDia(LocalDate fechaEntrada) {
		return fechaEntrada.now().equals(fechaEntrada);
	}
	
	public String cancelarReserva(int codigo) {
		
		return comprobarCancelacion(codigo);
	}
	
	private String comprobarCancelacion(int codigo) {
		String resultado=null;
		for(Reservas reserva : rd.obtenerTodo()) {
			if(reserva.getcReserva()==(codigo)) {
				if(reserva.getHabitacion()!=null && !reserva.isReservado()) {
					System.err.println("No se puede cancelar una reserva en checkin.");
				}else if(reserva.getHabitacion()!=null && reserva.isReservado()) {
					System.err.println("No se puede cancelar una reserva antigua.");
				}else if(reserva.getHabitacion()==null && !reserva.isReservado()){
					rd.eliminarReserva(reserva);
					resultado="Reserva cancelada.";
				}
			}
		}
		return resultado;
	}
	
	public double realizarCheckOut(String dni) {
		Reservas reservaObtenida=obtenerReservaCheckOut(dni);
		double precioFinal=0;
		if(reservaObtenida!=null) {
			Habitacion habitacion = obtenerHabitacionCheckOut(reservaObtenida);
			if(habitacion!=null) {
				double precio=habitacion.getPrecio();
				int dias = (int) ChronoUnit.DAYS.between(reservaObtenida.getFechaEntrada(), reservaObtenida.getFechaSalida());
				precioFinal=dias*precio;
				reservaObtenida.setReservado(true);
				rd.modificarReserva(reservaObtenida);
				habitacion.setEstado("libre");
				hd.modificarHabitacion(habitacion);
			}
		}
		return precioFinal;
	}
	
	private Habitacion obtenerHabitacionCheckOut(Reservas reserva) {
		Habitacion habitacion = null;
		for(Habitacion habi : hd.obtenerTodo()) {
			if(habi.equals(reserva.getHabitacion())) {
				habitacion = habi;
			}
		}
		return habitacion;
	}
	
	private Reservas obtenerReservaCheckOut(String dni) {
		Reservas reser=null;
		for(Reservas reserva : rd.obtenerTodo()) {
			if(reserva.getCliente().getDni().equals(dni) && reserva.getHabitacion()!=null) {
				reser=reserva;
			}
		}
		if(reser==null) {
			System.err.println("No se puede hacer checkOut de una reserva sin checkin o no se encontro o es antigua.");
		}
		return reser;
	}
}
