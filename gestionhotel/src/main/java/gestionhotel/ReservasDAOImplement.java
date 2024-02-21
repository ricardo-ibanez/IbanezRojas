package gestionhotel;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReservasDAOImplement implements ReservasDAO{
	
private Session session;
	
    public ReservasDAOImplement() {
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }

	public void anadirReserava(Reservas r) {
		Transaction tx = session.beginTransaction();
		session.save(r);
		tx.commit();
		
	}

	public Reservas buscarReserva(int id) {
		return session.get(Reservas.class, id);
	}

	/**
	 * Obtener todo.
	 *
	 * @return the array list
	 */
	public ArrayList<Reservas> obtenerTodo() {
		return (ArrayList<Reservas>) session.createQuery("SELECT r FROM Reservas r").getResultList(
	}

	public void eliminarReserva(Reservas r) {
		Transaction tx = session.beginTransaction();
		session.delete(r);
		tx.commit();
		
	}
	
	public void modificarReserva(Reservas r) {
		Transaction tx = session.beginTransaction();
		session.update(r);
		tx.commit();
	}
	
}
