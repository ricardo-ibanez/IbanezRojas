package gestionhotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.*;

import org.junit.jupiter.api.Test;

class ClientesTest {

	@Test
	void test() {
		Clientes c = new Clientes();
		
		assertEquals(c.getNombre(), "Pepe");
	}

}
