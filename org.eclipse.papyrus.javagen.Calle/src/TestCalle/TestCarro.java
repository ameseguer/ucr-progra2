package TestCalle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import Calle.Carro;


class TestCarro {
	
	static Carro  carroDePrueba;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//carroDePrueba = new Carro();
	}

	@DisplayName("Probar getVelocidad después de setVelocidad")
	@Test
	void testSetGetVelocidad() {
		int valorPrueba= 100;
		carroDePrueba.setVelocidad(valorPrueba);
		int retorno = carroDePrueba.getVelocidad();
		assertEquals(valorPrueba, retorno);
	}

}
