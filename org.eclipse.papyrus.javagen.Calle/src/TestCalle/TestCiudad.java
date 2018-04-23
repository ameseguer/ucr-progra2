package TestCalle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Ignore;
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
import ArchivosCalle.AdministradorArchivosXml;
import ArchivosCalle.ArchivosCalle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestCiudad {

	private static Ciudad testCiudad;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testCiudad = new Ciudad();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@DisplayName("Insertar Carro en Ciudad")
	void test100CarroCiudad() {
		Carro testCarro1 = new Carro("Verde", 100, "AF01", ConstantesTipoCarro.SEDAN);
		Carro testCarro2 = new Carro("Azul", 100, "LU72", ConstantesTipoCarro.PICKUP);
		Motocicleta testMoto = new Motocicleta("verde",100,"MM01",ConstantesTipoMotocicleta.SCOOTER);
		testCiudad.agregarMotocicleta(testMoto);
		Boolean resultadoAgrega = testCiudad.agregaCarro(testCarro1);
		resultadoAgrega = testCiudad.agregaCarro(testCarro2);
		assertEquals(true, resultadoAgrega);
	}
	
	@Test
	@DisplayName("Insertar Moto en Ciudad")
	void test101MotoCiudad() {
		Motocicleta testMoto = new Motocicleta("verde",100,"MM01",ConstantesTipoMotocicleta.SCOOTER);
		Boolean resultadoAgrega = testCiudad.agregarMotocicleta(testMoto);
		assertEquals(true, resultadoAgrega);
	}
	
	@Test
	@DisplayName("Buscar Carros Verdes")
	void test102CarroVerde() {
		ArrayList<Carro> listaTmp;
		listaTmp = testCiudad.buscarCarro(c->c.getColor().equals("Verde"));
		assertEquals(1, listaTmp.size());
	}
	
	@Test
	@DisplayName("Buscar Pickup Verdes")
	void test103CarroPickupAzul() {
		ArrayList<Carro> listaTmp;
		listaTmp = testCiudad.buscarCarro(c->{
			return c.getColor().equals("Verde") &&
			c.getEstiloCarro().equals(ConstantesTipoCarro.PICKUP);
		} );
		assertEquals(0, listaTmp.size());
	}

	@Test
	@DisplayName("Guardar Ciudad en archivo Json")
	void test200GuardarCiudadJson() {
		AdministradorArchivosJson backend = new AdministradorArchivosJson();
		Boolean resultado = backend.guardarCiudad("/tmp/testCiudad1.json", testCiudad);
		assertEquals(true, resultado);
	}

	@Ignore("En progreso")
	@Test
	@DisplayName("Guardar Ciudad en archivo Txt")
	void test201GuardarCiudadTxt() {
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

	@Test
	@DisplayName("Guardar Ciudad en archivo Xml")
	void test202GuardarCiudadXml() {
		AdministradorArchivosXml backend = new AdministradorArchivosXml();
		/*
		 * TODO autoreconocer tipo
		 */
		Boolean resultado = backend.guardarCiudad("/tmp/testCiudad1.xml", testCiudad);
		assertEquals(true, resultado);
	}

	@Test
	@DisplayName("Sacar Lista de Carros de la Ciudad")
	void testCarro300Ciudad2() {
		ArrayList<Carro> listaCarros = testCiudad.getListaCarros();

		/*
		 * for (Carro carro : listaCarros) {
		 * System.out.println(carro.getNúmeroChasis()); }
		 */

		assertNotNull(listaCarros);
	}
}
