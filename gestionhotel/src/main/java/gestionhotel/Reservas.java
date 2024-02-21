package gestionhotel;

import java.time.LocalDate;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Reservas.
 */
@Entity
@Table(name = "reservas")
public class Reservas {
	/*
	 * fecha entrada localdate
	 * fecha salida 
	 * codigo reservaa (id)
	 * cantidad gente
	 * 
	 */
	
	@Column(length=50)
	
	/** The fecha entrada. */
	private LocalDate fechaEntrada;
	
	/** The fecha salida. */
	private LocalDate fechaSalida;
	
	/** The c reserva. */
	@Id
	private int cReserva;
	
	/** The num personas. */
	private int numPersonas;
	
	/** The cliente. */
	@OneToOne(fetch = FetchType.LAZY )
	private Clientes cliente;
	
	/** The habitacion. */
	@OneToOne(fetch = FetchType.LAZY )
	private Habitacion habitacion;
	
	/**
	 * Instantiates a new reservas.
	 */
	public Reservas() {
		super();
		this.fechaEntrada = LocalDate.parse("1950/1/1");
		this.fechaSalida = LocalDate.parse("2000/1/1");
		this.cReserva = 1234;
		this.numPersonas = 2;
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
	public Reservas(LocalDate fechaEntrada, LocalDate fechaSalida, int cReserva, int numPersonas, Clientes cliente, Habitacion habitacion) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cReserva = cReserva;
		this.numPersonas = numPersonas;
		this.cliente= cliente;
		this.habitacion=habitacion;
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return cliente;
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
	
	
	
	
	
	

}
