/**
 * 
 */
package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Calle.Carro;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


/**
 * @author amesegue
 *
 */
public  class Animación {
	
	private static Image scooterImage;
	private static Image sedanImage;
	private static Image pickupImage;
	private static Image semáforoImage;
	private static Image biciImage;
	private static Image motoImage;
	

	
	Animación() {
	try {
		scooterImage=new Image(new FileInputStream(ConstantesAnimación.SCOOTER));
		sedanImage =new Image(new FileInputStream(ConstantesAnimación.SEDAN));
		pickupImage =new Image(new FileInputStream(ConstantesAnimación.PICKUP));
		semáforoImage =new Image(new FileInputStream(ConstantesAnimación.SEMÁFORO));
		biciImage=new Image(new FileInputStream(ConstantesAnimación.BICI));
		motoImage=new Image(new FileInputStream(ConstantesAnimación.MOTO));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	
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
