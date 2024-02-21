package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAOTest {

	@Test
	void DAOTest() {
		ClientesDAOImplement cd = new ClientesDAOImplement();
		Clientes c = new Clientes();
		
		cd.anadirCliente(c);
	}

}
