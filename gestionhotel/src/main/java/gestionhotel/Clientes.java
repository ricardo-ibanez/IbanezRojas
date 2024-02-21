package gestionhotel;

import javax.persistence.*;


// TODO: Auto-generated Javadoc
/**
 * La clase Clientes.
 */
@Entity
@Table(name = "clientes")
public class Clientes {
	
	@Column(length=50)
	
	/** nombre. */
	private String nombre;
	
	/** apellidos. */
	private String apellidos;
	
	/** dni. */
	@Id
	private String dni;
	
	/** edad. */
	private int edad;
	
	/**
	 * Instantiates nuevo clientes.
	 */
	public Clientes() {
		super();
		this.nombre = "Pepe";
		this.apellidos = "Ramirez";
		this.dni = "00000000A";
		this.edad = 20;
	}
	
	/**
	 * Instantiates nuevo clientes.
	 *
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param dni the dni
	 * @param edad the edad
	 */
	public Clientes(String nombre, String apellidos, String dni, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}

	/**
	 * Obtiene el nombre
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Nuevo nombre.
	 *
	 * @param nombre nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene apellidos.
	 *
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + "]";
	}
	
	

}
