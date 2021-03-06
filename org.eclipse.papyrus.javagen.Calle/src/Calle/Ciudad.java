// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Calle;

import Calle.Bicicleta;
import Calle.Carro;
import Calle.Motocicleta;
import Calle.Vehículo;
import Calle.Vía;
import java.util.ArrayList;
import java.util.function.Predicate;

/************************************************************/
/**
 * 
 */
public class Ciudad {

	/**
	 * 
	 */
	private ArrayList<Vehículo> listaVehículos;

	/**
	 * 
	 */
	private ArrayList<Vía> listaVías;

	/**
	 * 
	 */

	public Ciudad() {
		this.listaVehículos = new ArrayList<Vehículo>();
		this.listaVías = new ArrayList<Vía>();
	}

	/**
	 * @return the listaVehículos
	 */
	public ArrayList<Vehículo> getListaVehículos() {
		return listaVehículos;
	}

	/**
	 * @param listaVehículos
	 *            the listaVehículos to set
	 */
	public void setListaVehículos(ArrayList<Vehículo> listaVehículos) {
		this.listaVehículos = listaVehículos;
	}

	/**
	 * 
	 * @param nuevoCarro
	 * @return
	 */
	public boolean agregaCarro(Carro nuevoCarro) {
		return this.listaVehículos.add((Vehículo) nuevoCarro);
	}

	/**
	 * 
	 * @param nuevaMoto
	 * @return
	 */
	public boolean agregarMotocicleta(Motocicleta nuevaMoto) {
		return this.listaVehículos.add((Vehículo) nuevaMoto);
	}

	/**
	 * 
	 * @param nuevaBicicleta
	 * @return
	 */
	public boolean agregarBicicleta(Bicicleta nuevaBicicleta) {
		return this.listaVehículos.add((Vehículo) nuevaBicicleta);
	}

	/**
	 * 
	 * @return
	 * @param nuevaVía
	 */
	public boolean agregarVía(Vía nuevaVía) {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public Vía getListaVías() {
		return null;
	}

	/**
	 * 
	 * @return
	 * @param nuevoVehículo
	 */
	public boolean agregarVehículo(Vehículo nuevoVehículo) {
		return this.listaVehículos.add(nuevoVehículo);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Bicicleta> getListaBicicletas() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Carro> getListaCarros() {
		ArrayList<Carro> tmpListaCarros = new ArrayList<Carro>();
		this.listaVehículos.forEach((tmpCarro) -> {
			if (tmpCarro instanceof Carro) {
				tmpListaCarros.add((Carro) tmpCarro);
			} else {

			}
		});
		return tmpListaCarros;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Motocicleta> getListaMotocicletas() {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Carro> buscarCarro(Predicate<Carro> filtro){
		ArrayList<Carro> listaTmp = new ArrayList<Carro>();
		
		this.listaVehículos.forEach((tmpCarro) -> {
			if (tmpCarro instanceof Carro && filtro.test((Carro)tmpCarro)) {
				listaTmp.add((Carro) tmpCarro);
			} else {

			}
		});
		
		return listaTmp;
	}
	 
};
