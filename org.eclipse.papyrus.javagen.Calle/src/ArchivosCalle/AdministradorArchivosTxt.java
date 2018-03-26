/**
 * 
 */
package ArchivosCalle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Calle.Ciudad;

/**
 * @author amesegue
 *
 */
public class AdministradorArchivosTxt implements AdministradorArchivos {

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
	public Boolean guardarCiudad(String rutaArchivo, Ciudad ciudad) {
		// TODO Auto-generated method stub
		
		try {
			ObjectOutputStream out;
			out = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			out.writeObject(ciudad);
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	     
		return null;
	}


}
