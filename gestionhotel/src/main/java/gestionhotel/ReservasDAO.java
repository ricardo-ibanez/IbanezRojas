package gestionhotel;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReservasDAO.
 */
public interface ReservasDAO {
	
	/**
	 * Anadir reserava.
	 *
	 * @param r the r
	 */
	public void anadirReserava(Reservas r);
	
	/**
	 * Buscar reserva.
	 *
	 * @param id the id
	 * @return the reservas
	 */
	public Reservas buscarReserva(int id);
	
	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Reservas> obtenerTodo();
	
	/**
	 * Eliminar reserva.
	 *
	 * @param r the r
	 */
	public void eliminarReserva(Reservas r);
	public void modificarReserva(Reservas r);
}
