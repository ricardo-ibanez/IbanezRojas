package gestionhotel;

import java.time.LocalDate;

public class Reservas {
	/*
	 * fecha entrada localdate
	 * fecha salida "
	 * codigo reservaa (id)
	 * cantidad gente
	 * 
	 */
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private int cReserva;
	private int numPersonas;
	private Clientes cliente;
	private Habitacion habitacion;
	
	public Reservas() {
		super();
		this.fechaEntrada = LocalDate.parse("1950/1/1");
		this.fechaSalida = LocalDate.parse("2000/1/1");
		this.cReserva = 1234;
		this.numPersonas = 2;
	}
	
	public Reservas(LocalDate fechaEntrada, LocalDate fechaSalida, int cReserva, int numPersonas, Clientes cliente, Habitacion habitacion) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cReserva = cReserva;
		this.numPersonas = numPersonas;
		this.cliente= cliente;
		this.habitacion=habitacion;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getcReserva() {
		return cReserva;
	}

	public void setcReserva(int cReserva) {
		this.cReserva = cReserva;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Reservas [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", cReserva=" + cReserva
				+ ", numPersonas=" + numPersonas + "]";
	}
	
	
	
	
	
	

}
