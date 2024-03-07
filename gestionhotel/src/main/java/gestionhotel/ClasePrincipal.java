package gestionhotel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ClasePrincipal {
	
	Scanner sc = new Scanner(System.in);
	BookingService bs = new BookingService();
	private final HabitacionDAOImplement hd = new HabitacionDAOImplement();
	
	public static void main(String[] args) {
		ArrayList <Habitacion> habitaciones = new ArrayList <Habitacion>();
		
		
		/*
		 * Tiene que salir 
		 * normales:2 y una ocupada
		 * Busines: 3
		 * superior:3
		 */
		Hotel h = new Hotel(habitaciones);
		ClasePrincipal cp = new ClasePrincipal();
		cp.metodoGlobal();
		
		
	}
	
	public void metodoGlobal() {
		int opcion = 0;
		boolean seguir = true;
		
		do{
			
			menuPrimero();
			opcion = sc.nextInt();
			//sc.nextLine();
			
			switch(opcion) {
				case 1:
					pedirDatos();
					
					break;
				case 2:
					System.out.println("Chaito, vuelva pronto");
					seguir = false;
					break;
				case 3:
					System.out.println("Introduzca el codigo de la reserva");
					int idC = sc.nextInt();
					bs.cancelarReserva(idC);
					break;
				case 4:
					System.out.println("Introduce el id de la reserva");
					idC = sc.nextInt();
					bs.realizarCheckIn(idC);
					break;
				case 5:
					sc.nextLine();
					System.out.println("Introduce el dni del cliente");
					String dni = sc.nextLine();
					double precio = bs.realizarCheckOut(dni);
					System.out.println("Precio total: " + precio + "€");
					System.out.println("-------------------------------------------");
					break;
				default:
					System.err.println("No es una opcion valida, pruebe de nuevo \n ------------------------------------------- \n");
					break;
			}
			
		}while(seguir);
	}
	
	public void menuPrimero() {
		System.out.println("1.Consultar disponibilidad.");
		System.out.println("2. Salir");
		System.out.println("3. Cancelar reserva");
		System.out.println("4. Check in");
		System.out.println("5. Check out");
		System.out.println("----------------------");
		System.out.println("Introduzca una opción.");
	}
	
	public void pedirDatos() {
		
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("### Consultar disponibilidad y reserva de habitaciones ###");
		System.out.println("------------------------");
		sc.nextLine();
		
		System.out.println("Indique fecha de entrada (formato dd/MM/yyyy)");
		String fechaEntrada = sc.nextLine();
		LocalDate dateEntrada = LocalDate.parse(fechaEntrada,formato);
		
		System.out.println("Indique fecha de salida (formato dd/MM/yyyy)");
		String fechaSalida = sc.nextLine();
		LocalDate dateSalida= LocalDate.parse(fechaSalida,formato);
		
		System.out.println("Indique numero de personas (maximo 3)");
		int personas = sc.nextInt();
		
		Habitacion h;
		h = bs.consultarDisponibilidad(personas, dateEntrada, dateSalida);
		
		mostrarHabitaciones(h,dateEntrada,dateSalida,personas);
		
		
		
	}
	
	public void mostrarHabitaciones (Habitacion habitacion,LocalDate fechaEntrada,LocalDate fechaSalida,int personas) {
		int cantidadHabitacionesNormal = 0;
		int cantidadHabitacionesBusiness = 0;
		int cantidadHabitacionesSuperior = 0;
		
		for(int i = 0; i<hd.obtenerTodo().size();i++) {
			if(hd.obtenerTodo().get(i).getTipo().equalsIgnoreCase("normal") && hd.obtenerTodo().get(i).getEstado().equalsIgnoreCase("libre")) {
				cantidadHabitacionesNormal++;
			} else if(hd.obtenerTodo().get(i).getTipo().equalsIgnoreCase("business") && hd.obtenerTodo().get(i).getEstado().equalsIgnoreCase("libre")) {
				cantidadHabitacionesBusiness++;
			}else if(hd.obtenerTodo().get(i).getTipo().equalsIgnoreCase("superior") && hd.obtenerTodo().get(i).getEstado().equalsIgnoreCase("libre")) {
				cantidadHabitacionesSuperior++;
			}
		}
		
		System.out.println("------------------");
		System.out.println(cantidadHabitacionesNormal + " Habitaciones normales (75.00€)");
		System.out.println(cantidadHabitacionesBusiness + " Habitaciones business (100.00€)");
		System.out.println(cantidadHabitacionesBusiness + " Habitaciones superior (150.00€)");
		System.out.println("------------------");
		
		System.out.println("Opciones de reserva");
		
		System.out.println("------------------");
		System.out.println("1) Reservar habitacion NORMAL");
		System.out.println("2) Reservar habitacion BUSINESS");
		System.out.println("3) Reservar habitacion SUPERIOR");
		System.out.println("------------------");
		
		System.out.println("Introduzca una opcion");
		int opc = sc.nextInt();
		sc.nextLine();
		
		String tipo;
		float precio = 1;
		
		switch(opc) {
			case 1:
				tipo = "normal";
				precio = 75;
				break;
			case 2:
				tipo = "business";
				precio = 100;
				break;
			case 3:
				tipo = "superior";
				precio = 150;
				break;
		}
		
		System.out.println("Introduzca DNI");
		String dni = sc.nextLine();

		bs.reservarHabitacion(habitacion,dni,fechaEntrada,fechaSalida,personas);
		
		int dias = (int) ChronoUnit.DAYS.between(fechaEntrada,fechaSalida);
		
		boolean pagar = false;
		
		
		
		System.out.println("Coste de alojamiento es: " + (dias*precio));
		
		System.out.println("¿quiere continuar?(Y/N)");
		String cont = sc.nextLine();
		
		if(cont.equalsIgnoreCase("y")) {
			System.out.println("Reserva realizada con exito");
		}else {
			System.out.println("Reserva cancelada");
		}
		
		
	}
	
	
	
	
	
}
