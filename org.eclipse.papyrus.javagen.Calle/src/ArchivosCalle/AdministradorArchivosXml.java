/**
 * 
 */
package ArchivosCalle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import Calle.Carro;
import Calle.Ciudad;
import Calle.Motocicleta;
import Calle.Vía;


/**
 * @author amesegue
 *
 */
public class AdministradorArchivosXml implements AdministradorArchivos {
	
	private final String etiquetaCiudad = "ciudad";

	/* (non-Javadoc)
	 * @see ArchivosCalle.AdministradorArchivos#cargarCiudad(java.lang.String)
	 */
	@Override
	public Ciudad cargarCiudad(String rutaArchivo) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ArchivosCalle.AdministradorArchivos#guardarCiudad(java.lang.String, Calle.Ciudad)
	 */
	@Override
	public Boolean guardarCiudad(final String rutaArchivo, final Ciudad ciudad) {
		try {
			
			Path archivo = Paths.get(rutaArchivo);
			BufferedWriter escritorXml = new BufferedWriter(Files.newBufferedWriter(archivo, StandardCharsets.UTF_8));		
			/*
			 * Es necesario agregar las subclases para que JAXB pueda crear las etiquetas apropiadas
			 */
			JAXBContext jaxContext = JAXBContext.newInstance( Ciudad.class, Carro.class,Motocicleta.class, Vía.class);
			Marshaller marshaller = jaxContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			QName etiquetaRaiz = new QName(ciudad.getClass().toString());
			JAXBElement<Ciudad> ciudadXml =new JAXBElement<Ciudad>(etiquetaRaiz,Ciudad.class, ciudad);
			
			marshaller.marshal(ciudadXml, escritorXml);
			
			marshaller.marshal(ciudadXml, System.out);
			//cerrar descriptor de archivos
			escritorXml.close();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
