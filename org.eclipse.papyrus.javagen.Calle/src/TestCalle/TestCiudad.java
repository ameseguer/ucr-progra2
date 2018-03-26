package TestCalle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Calle.Ciudad;
import Calle.Carro;
import Calle.ConstantesTipoCarro;
import Calle.ConstantesTipoMotocicleta;
import Calle.Motocicleta;
import Calle.Bicicleta;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

import ArchivosCalle.AdministradorArchivosJson;
import ArchivosCalle.AdministradorArchivosTxt;
import ArchivosCalle.ArchivosCalle;

class TestCiudad {

	static private Ciudad testCiudad;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testCiudad = new Ciudad();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Insertar Carro en Ciudad")
	void testCarroCiudad() {
		Carro testCarro = new Carro("Verde", 100, "AF01", ConstantesTipoCarro.SEDAN);
		Boolean resultadoAgrega = testCiudad.agregaCarro(testCarro);
		assertEquals(true, resultadoAgrega);
	}

	@Test
	@DisplayName("Sacar Lista de Carros de la Ciudad")
	void testCarroCiudad2() {
		ArrayList<Carro> listaCarros = testCiudad.getListaCarros();
		/*
		 * for (Carro carro : listaCarros) {
		 * System.out.println(carro.getNúmeroChasis()); }
		 */
		assertNotNull(listaCarros);
	}

	@Test
	@DisplayName("Guardar Ciudad en archivo Json")
	void testGuardarCiudadJson() {
		AdministradorArchivosJson backend = new AdministradorArchivosJson();
		/*
		 * TODO: autoreconocer tipo
		 */
		Boolean resultado = backend.guardarCiudad("/tmp/testCiudad1.json", testCiudad);
		assertEquals(true, resultado);
	}

	@Test
	@DisplayName("Guardar Ciudad en archivo Txt")
	void testGuardarCiudadTxt() {
		AdministradorArchivosTxt backend = new AdministradorArchivosTxt();
		/*
		 * TODO: autoreconocer tipo
		 */
		/*
		 * Boolean resultado = backend.guardarCiudad("/tmp/testCiudad1.txt",
		 * testCiudad); assertEquals(true, resultado);
		 */

		fail("Ciudad debe ser serializable");
	}

}
