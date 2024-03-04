package gestionhotel;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface HabitacionDAO.
 */
public interface HabitacionDAO {
	
	/**
	 * Buscar habitacion.
	 *
	 * @param id the id
	 * @return the habitacion
	 */
	public Habitacion buscarHabitacion(int id);
	
	/**
	 * Guardar habitacion.
	 *
	 * @param h the h
	 */
	public void guardarHabitacion(Habitacion h);
	
	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Habitacion> obtenerTodo();
	
	/**
	 * Eliminar habitacoin.
	 *
	 * @param h the h
	 */
	public void eliminarHabitacoin(Habitacion h);
	public void modificarHabitacion(Habitacion h );
}
