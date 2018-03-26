/**
 * 
 */
package ArchivosCalle;

import Calle.Ciudad;

/**
 * @author amesegue
 *
 */
interface AdministradorArchivos {

	public Ciudad cargarCiudad(String rutaArchivo);
	public Boolean guardarCiudad(String rutaArchivo, Ciudad ciudad);
}
