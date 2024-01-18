package gestionhotel;

import java.util.ArrayList;

public class Habitacion {
	/*atributos
	 * estado habitacion libre/ocupada/rota
	 * cantidad ocupantes INDIVIDUAL/doble/triple
	 * tipo habitacion normal/bussines/superior
	 * precio 
	 */
	private String estado;
	private int capacidad;
	private String tipo;
	private double precio;
	
	public Habitacion() {
		super();
		this.estado = "libre";
		this.capacidad = 1;
		this.tipo = "normal";
		this.precio = 20;
	}
	
	
	public Habitacion(String estado, int capacidad, String tipo,double precio) {
		super();
		this.estado = estado;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}


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
