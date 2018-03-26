/**
 * 
 */

package ArchivosCalle;

/**
 * @author amesegue
 *
 */
public class ArchivosCalle {
	private String rutaArchivo;
	private TiposArchivo tipoArchivo;
	private Boolean lectura;
	private Boolean escritura;
	AdministradorArchivos archivo;

	public ArchivosCalle(String nuevaRutaArchivo) {
		this.rutaArchivo = nuevaRutaArchivo;
		determinarTipoArchivo();

		switch (this.tipoArchivo) {
		case JSON:

			break;
		case TXT:
			break;
		/*
		 * TODO: terminar XML
		 */
		default:
			this.lectura = false;
			this.escritura = false;
			this.archivo = null;
			break;
		}
	}

	private Boolean determinarTipoArchivo() {
		return true;
	}

}
