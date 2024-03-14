package gestionhotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClasePrincipal {

	private final Scanner sc = new Scanner(System.in);
	private final BookingService bs = new BookingService();
	 private static final HabitacionDAOImplement hd = new HabitacionDAOImplement();

	public static void main(String[] args) {

		
		  Habitacion h1 = new Habitacion(1,"libre",1,"normal",100); 
		  Habitacion h2 = new Habitacion(2,"libre",1,"business",150); 
		  Habitacion h3 = new Habitacion(3,"libre",1,"superior",200); 
		  Habitacion h4 = new Habitacion(4,"libre",2,"normal",100); 
		  Habitacion h5 = new Habitacion(5,"libre",2,"business",150); 
		  Habitacion h6 = new Habitacion(6,"libre",2,"superior",200); 
		  Habitacion h7 = new Habitacion(7,"libre",3,"normal",100); 
		  Habitacion h8 = new Habitacion(8,"libre",3,"business",150); 
		  Habitacion h9 = new Habitacion(9,"libre",3,"superior",200);
		  
		  hd.guardarHabitacion(h1); 
		  hd.guardarHabitacion(h2); 
		  hd.guardarHabitacion(h3);
		  hd.guardarHabitacion(h4); 
		  hd.guardarHabitacion(h5); 
		  hd.guardarHabitacion(h6);
		  hd.guardarHabitacion(h7); 
		  hd.guardarHabitacion(h8); 
		  hd.guardarHabitacion(h9);
		 

		/*
		 * Tiene que salir normales:2 y una ocupada Busines: 3 superior:3
		 */
		ClasePrincipal cp = new ClasePrincipal();
		cp.metodoGlobal();

	}

	private void metodoGlobal() {
		int opcion = 0;
		boolean seguir = true;

		do {

			menuPrimero();
			opcion = sc.nextInt();
			// sc.nextLine();

			switch (opcion) {
			case 1:
				pedirDatos();

				break;
			case 2:
				System.out.println("Chaito, vuelva pronto");
				seguir = false;
				break;
			case 3:
				sc.nextLine();
				System.out.println("Introduzca el codigo de la reserva");
				int idC = sc.nextInt();
				String resultado = bs.cancelarReserva(idC);
				if(resultado!=null) {
					System.out.println(resultado);
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Introduzca el codigo de la reserva");
				idC = sc.nextInt();
				resultado = bs.realizarCheckin(idC);
				if(resultado!=null) {
					System.out.println(resultado);
				}
				break;
			case 5:
				sc.nextLine();
				System.out.println("Introduce el dni del cliente");
				String dni = sc.nextLine();
				double precio = bs.realizarCheckOut(dni);
				if(precio>0) {
					System.out.println("Precio total: " + precio + "€");
					System.out.println("-------------------------------------------");
				}
				break;
			default:
				System.err.println(
						"No es una opcion valida, pruebe de nuevo \n ------------------------------------------- \n");
				break;
			}

		} while (seguir);
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
		LocalDate dateEntrada = LocalDate.parse(fechaEntrada, formato);

		System.out.println("Indique fecha de salida (formato dd/MM/yyyy)");
		String fechaSalida = sc.nextLine();
		LocalDate dateSalida = LocalDate.parse(fechaSalida, formato);

		System.out.println("Indique numero de personas (maximo 3)");
		int personas = sc.nextInt();

		int capacidadHabitacion = bs.consultarDisponibilidad(personas, dateEntrada, dateSalida);

		if (capacidadHabitacion < 1 || capacidadHabitacion > 3) {
			System.err.println("No has elegido una opción de habitación valida.");
		} else {
			String tipoHabitacion = bs.obtenerTipo(capacidadHabitacion,personas);
			if (tipoHabitacion != null) {
				sc.nextLine();
				System.out.println("Introduce el DNI:");
				String dni = sc.nextLine();
				if (!dni.isEmpty()) {
					boolean existeCliente =bs.comprobarDNI(dni);
					int codigo=-1;
					if(existeCliente) {
						codigo=bs.reservarHabitacion(tipoHabitacion, dni, dateEntrada, dateSalida, capacidadHabitacion);
						System.out.println("Su código de reserva es: "+codigo);
					}else {
						System.out.println("Registro de Cliente: ");
						System.out.println("Introduce el nombre: ");
						String nombre=sc.nextLine();
						System.out.println("Introduce los apellidos: ");
						String apellidos=sc.nextLine();
						System.out.println("Introduce la edad: ");
						int edad=sc.nextInt();
						if(edad<18) {
							System.err.println("Debe ser mayor de edad para realizar la reserva.");
						}else {
							sc.nextLine();
							Clientes cliente = new Clientes(nombre,apellidos,dni,edad);
							bs.registrarCliente(cliente);
							codigo=bs.reservarHabitacion(tipoHabitacion, dni, dateEntrada, dateSalida, capacidadHabitacion);
							System.out.println("Su código de reserva es: "+codigo);
						}
					}
				} else {
					System.err.println("Debes introducir un DNI.");
				}
			} else {
				System.err.println("No has elegido un tipo de habitación válido o existente.");
			}
		}

		// mostrarHabitaciones(h,dateEntrada,dateSalida,personas);

	}


	/*public void mostrarHabitaciones(Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida,
			int personas) {

		float precio = 1;

		System.out.println("Introduzca DNI");
		String dni = sc.nextLine();

		// bs.reservarHabitacion(habitacion,dni,fechaEntrada,fechaSalida,personas);

		int dias = (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);

		boolean pagar = false;

		System.out.println("Coste de alojamiento es: " + (dias * precio));

		System.out.println("¿quiere continuar?(Y/N)");
		String cont = sc.nextLine();

		if (cont.equalsIgnoreCase("y")) {
			System.out.println("Reserva realizada con exito");
		} else {
			System.out.println("Reserva cancelada");
		}

	}*/

}
