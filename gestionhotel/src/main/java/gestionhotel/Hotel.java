package gestionhotel;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Hotel.
 */
public class Hotel {
	/*
	 * arraylist habitaciones
	 */
	
	/** The habitaciones. */
	private ArrayList <Habitacion> habitaciones;
	
	/** The clientes. */
	private ArrayList <Clientes> clientes;
	
	/*
	 * arraylist reservas
	 */
	
	/**
	 * Instantiates a new hotel.
	 */
	public Hotel() {
		habitaciones = new ArrayList<Habitacion>();
		clientes = new ArrayList<Clientes>();
	}
	
	/**
	 * Gets the clientes.
	 *
	 * @return the clientes
	 */
	public ArrayList<Clientes> getClientes() {
		return clientes;
	}

	/**
	 * Sets the clientes.
	 *
	 * @param clientes the new clientes
	 */
	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Instantiates a new hotel.
	 *
	 * @param habitaciones the habitaciones
	 */
	public Hotel(ArrayList<Habitacion> habitaciones) {
		super();
		this.habitaciones = habitaciones;
	}

	/**
	 * Gets the habitaciones.
	 *
	 * @return the habitaciones
	 */
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	/**
	 * Sets the habitaciones.
	 *
	 * @param habitaciones the new habitaciones
	 */
	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Hotel [habitaciones=" + habitaciones + "]";
	}

	/**
	 * Agregar habitacion.
	 *
	 * @param habitacion the habitacion
	 */
	public void agregarHabitacion(Habitacion habitacion) {
		habitaciones.add(habitacion);
	}
	
	
	
	
	

}
