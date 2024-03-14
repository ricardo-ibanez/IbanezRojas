package gestionhotel;

import java.time.LocalDate;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservas.
 */
@Entity
@Table(name = "Reservas")
public class Reservas {
	/*
	 * fecha entrada localdate
	 * fecha salida 
	 * codigo reservaa (id)
	 * cantidad gente
	 * 
	 */
	
	@Column(length=150)
	/** The c reserva. */
	@Id
	private int cReserva;
	
	/** The fecha entrada. */
	private LocalDate fechaEntrada;
	
	/** The fecha salida. */
	private LocalDate fechaSalida;
	
	
	/** The num personas. */
	private int numPersonas;
	
	/** The cliente. */
	@OneToOne(fetch = FetchType.LAZY )
	private Clientes cliente;
	
	/** The habitacion. */
	@OneToOne(fetch = FetchType.LAZY )
	private Habitacion habitacion;
	
	private boolean reservado;
	
	private String tipoHabitacion;
	
	/**
	 * Instantiates a new reservas.
	 */
	public Reservas() {
	}
	
	/**
	 * Instantiates a new reservas.
	 *
	 * @param fechaEntrada the fecha entrada
	 * @param fechaSalida the fecha salida
	 * @param cReserva the c reserva
	 * @param numPersonas the num personas
	 * @param cliente the cliente
	 * @param habitacion the habitacion
	 */
	

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return cliente;
	}

	
	public Reservas(int cReserva, LocalDate fechaEntrada, LocalDate fechaSalida, int numPersonas,
			String tipoHabitacion, Clientes cliente, Habitacion habitacion, boolean reservado) {
		super();
		this.cReserva = cReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.reservado = reservado;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the habitacion.
	 *
	 * @return the habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Sets the habitacion.
	 *
	 * @param habitacion the new habitacion
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * Gets the fecha entrada.
	 *
	 * @return the fecha entrada
	 */
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Sets the fecha entrada.
	 *
	 * @param fechaEntrada the new fecha entrada
	 */
	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * Gets the fecha salida.
	 *
	 * @return the fecha salida
	 */
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Sets the fecha salida.
	 *
	 * @param fechaSalida the new fecha salida
	 */
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Gets the c reserva.
	 *
	 * @return the c reserva
	 */
	public int getcReserva() {
		return cReserva;
	}

	/**
	 * Sets the c reserva.
	 *
	 * @param cReserva the new c reserva
	 */
	public void setcReserva(int cReserva) {
		this.cReserva = cReserva;
	}

	/**
	 * Gets the num personas.
	 *
	 * @return the num personas
	 */
	public int getNumPersonas() {
		return numPersonas;
	}

	/**
	 * Sets the num personas.
	 *
	 * @param numPersonas the new num personas
	 */
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	
	

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Reservas [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", cReserva=" + cReserva
				+ ", numPersonas=" + numPersonas + "]";
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
	
	
	
	

}
