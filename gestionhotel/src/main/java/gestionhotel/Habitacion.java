package gestionhotel;

import java.util.ArrayList;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Habitacion.
 */
@Entity
@Table(name = "Habitaciones")
public class Habitacion {
	
	/** The estado. */
	/*atributos
	 * estado habitacion libre/ocupada/rota
	 
	 * tipo habitacion normal/busines/superior
	 * precio 
	 */
	
	@Column(length=50)
	
	/** The id. */
	@Id
	private int id;
	
	private String estado;
	
	/** The capacidad. */
	private int capacidad;
	
	/** The tipo. */
	private String tipo;
	
	/** The precio. */
	private double precio;
	
	
	/**
	 * Instantiates a new habitacion.
	 */
	public Habitacion() {
		
	}
	
	/**
	 * Metodo constructor.
	 *
	 * @param estado the estado
	 * @param capacidad the capacidad
	 * @param tipo the tipo
	 * @param precio the precio
	 */
	public Habitacion(int id, String estado, int capacidad, String tipo,double precio) {
		this.id=id;
		this.estado = estado;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.precio = precio;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Gets the capacidad.
	 *
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}
	
	/**
	 * Sets the capacidad.
	 *
	 * @param capacidad the new capacidad
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Habitacion [estado=" + estado + ", capacidad=" + capacidad + ", tipo=" + tipo + ", precio=" + precio
				+ "]";
	}
	
	/*
	 * metodos:
	 * En el hito 2 cambiar estado
	 * 
	 * 
	 */
	

}
