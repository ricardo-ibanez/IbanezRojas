package gestionhotel;

public class Clientes {
	
	/*
	 * nombre
	 * apellidos
	 * dni 
	 * edad
	 */
	
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	
	public Clientes() {
		super();
		this.nombre = "Pepe";
		this.apellidos = "Ramirez";
		this.dni = "00000000A";
		this.edad = 20;
	}
	
	public Clientes(String nombre, String apellidos, String dni, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + "]";
	}
	
	

}
