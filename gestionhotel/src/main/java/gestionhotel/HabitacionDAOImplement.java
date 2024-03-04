package gestionhotel;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class HabitacionDAOImplement.
 */
public class HabitacionDAOImplement implements HabitacionDAO {

/** The conexion. */
private Session session;
	
    /**
     * Instantiates a new habitacion DAO implement.
     */
    public HabitacionDAOImplement	() {
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }

	/**
	 * Buscar habitacion.
	 *
	 * @param id the id
	 * @return the habitacion
	 */
	public Habitacion buscarHabitacion(int id) {
		return session.get(Habitacion.class, id);
	}

	/**
	 * Guardar habitacion.
	 *
	 * @param h the h
	 */
	public void guardarHabitacion(Habitacion h) {
		Transaction tx = session.beginTransaction();
		session.save(h);
		tx.commit();
		
	}

	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Habitacion> obtenerTodo() {
		return (ArrayList<Habitacion>) session.createQuery("SELECT h FROM Habitacion h").getResultList();
	}

	/**
	 * Eliminar habitacoin.
	 *
	 * @param h the h
	 */
	public void eliminarHabitacoin(Habitacion h) {
		Transaction tx = session.beginTransaction();
		session.delete(h);
		tx.commit();
		
	}
	public void modificarHabitacion(Habitacion h ) {
		Transaction tx = session.beginTransaction();
		session.update(h);
		tx.commit();
	}
	
	

	
}
