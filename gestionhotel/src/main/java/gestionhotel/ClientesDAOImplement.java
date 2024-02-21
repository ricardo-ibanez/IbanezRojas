package gestionhotel;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientesDAOImplement.
 */
public class ClientesDAOImplement implements ClientesDAO {
	
	/** The conexion. */
	private Session session;
	
    /**
     * Instantiates a new clientes DAO implement.
     */
    public ClientesDAOImplement() {
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }

	/**
	 * Anadir cliente.
	 *
	 * @param c the c
	 */
	public void anadirCliente(Clientes c) {
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		
	}

	/**
	 * Buscar cliente.
	 *
	 * @param dni the dni
	 * @return the clientes
	 */
	public Clientes buscarCliente(String dni) {
		return session.get(Clientes.class, dni);
	}

	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Clientes> obtenerTodo() {
		return (ArrayList<Clientes>) session.createQuery("SELECT c FROM Clientes c").getResultList();
	}

	/**
	 * Eliminar cliente.
	 *
	 * @param c the c
	 */
	public void eliminarCliente(Clientes c) {
		Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		
	}
}
