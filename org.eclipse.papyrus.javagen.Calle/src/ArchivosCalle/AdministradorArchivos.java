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

	public Ciudad cargarCiudad(final String rutaArchivo);
	public Boolean guardarCiudad(final String rutaArchivo, final Ciudad ciudad);
}
