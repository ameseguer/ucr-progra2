// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Calle;

/************************************************************/
/**
 * 
 */
public class Vehículo {
	/**
	 * 
	 */
	private String color;
	/**
	 * 
	 */
	private int velocidad;

	
	/**
	 * 
	 */
	public Vehículo() {
	}
	/**
	 * @param color
	 * @param velocidad
	 */
	public Vehículo(String color, int velocidad) {
		this.color = color;
		this.velocidad = velocidad;
	}
	/**
	 * 
	 * @return 
	 */
	public boolean mover() {
		return true;
	}
	/**
	 * 
	 * @return 
	 */
	public boolean detener() {
		return true;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
};
