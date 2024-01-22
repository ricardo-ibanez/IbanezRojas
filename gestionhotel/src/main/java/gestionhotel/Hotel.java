package gestionhotel;

import java.util.ArrayList;

public class Hotel {
	/*
	 * arraylist habitaciones
	 */
	
	private ArrayList <Habitacion> habitaciones;
	private ArrayList <Clientes> clientes;
	
	/*
	 * arraylist reservas
	 */
	
	public Hotel() {
		
		
	}

	public ArrayList<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}

	public Hotel(ArrayList<Habitacion> habitaciones) {
		super();
		this.habitaciones = habitaciones;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	
	@Override
	public String toString() {
		return "Hotel [habitaciones=" + habitaciones + "]";
	}

	public void agregarHabitacion(Habitacion habitacion) {
		habitaciones.add(habitacion);
	}
	
	
	
	
	

}
