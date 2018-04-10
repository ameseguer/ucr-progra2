// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Calle;

import Calle.Riteve;
import Calle.VehículoAutomotor;
import Calle.ConstantesTipoCarro;

/************************************************************/
/**
 * 
 */
public class Carro extends VehículoAutomotor implements Riteve {
	/**
	 * 
	 */
	private String númeroChasis;
	/**
	 * 
	 */
	private ConstantesTipoCarro estiloCarro;

	/**
	 * 
	 */
	public Carro() {
	}

	/**
	 * @param color
	 * @param velocidad
	 */
	public Carro(String color, int velocidad) {
		super(color, velocidad);
	}

	/**
	 * @param color
	 * @param velocidad
	 * @param númeroChasis
	 * @param estiloCarro
	 */
	public Carro(String color, int velocidad, String númeroChasis, ConstantesTipoCarro estiloCarro) {
		super(color, velocidad);
		this.númeroChasis = númeroChasis;
		this.estiloCarro = estiloCarro;
	}

	public String getNúmeroChasis() {
		return númeroChasis;
	}

	public void setNúmeroChasis(String númeroChasis) {
		this.númeroChasis = númeroChasis;
	}

	public ConstantesTipoCarro getEstiloCarro() {
		return estiloCarro;
	}

	public void setEstiloCarro(ConstantesTipoCarro estiloCarro) {
		this.estiloCarro = estiloCarro;
	}

	/**
	 * 
	 * @return 
	 */
	public boolean activarAlarma() {
		return false;
	}

	/**
	 * 
	 * @return 
	 */
	public boolean desactivarAlarma() {
		return false;
	}

	/**
	 * 
	 * @return 
	 */
	public int sacarCitaRiteve() {
		return 0;
	}

	/**
	 * 
	 * @return 
	 * @param idCita 
	 */
	public boolean cancelarCitaRiteve(int idCita) {
		return false;
	}

};
