package application;

import java.io.FileInputStream;

import Calle.Carro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public final class ConstantesAnimación {

	private static Image scooterImage;
	private static Image sedanImage;
	private static Image pickupImage;
	private static Image semáforoImage;
	private static Image biciImage;
	private static Image motoImage;
	
	 public final static String SEDAN="src/application/imágenes/icons8-sedan-30.png";
	 public final static String SUV="src/application/imágenes/icons8-suv-30.png";
	 public final static String PICKUP="src/application/imágenes/icons8-pickup-30.png";
	 public final static String BICI="src/application/imágenes/icons8-bicycle-30.png";
	 public final static String MOTO="src/application/imágenes/icons8-motorcycle-30.png";
	 public final static String SCOOTER="src/application/imágenes/icons8-SCOOTER-30.png";
	 public final static String SEMÁFORO="src/application/imágenes/icons8-traffic-light-30.png";
	 
	 
		
		
		public  void dibujarCarro(final int x, final int y, final Carro carro , GraphicsContext contextoGráfico) {
			/*
			 * TODO  cambiar colores a colores gc
			 */
			contextoGráfico.setFill(Color.GREEN);
			contextoGráfico.setStroke(Color.BLUE);
			contextoGráfico.setLineWidth(5);
			//determinar tipo
			contextoGráfico.drawImage(sedanImage, x, y);
			
		}

}
