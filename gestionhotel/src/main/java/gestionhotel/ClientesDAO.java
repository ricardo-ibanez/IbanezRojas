package gestionhotel;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientesDAO.
 */
public interface ClientesDAO {
	//Añadir y bbuscar cliente
	
	/**
	 * Anadir cliente.
	 *
	 * @param c the c
	 */
	public void anadirCliente(Clientes c);
	
	/**
	 * Buscar cliente.
	 *
	 * @param dni the dni
	 * @return the clientes
	 */
	public Clientes buscarCliente(String dni);
	
	/**
	 * Eliminar cliente.
	 *
	 * @param c the c
	 */
	public void eliminarCliente(Clientes c);
	
	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Clientes> obtenerTodo();
}
