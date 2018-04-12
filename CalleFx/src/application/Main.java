package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
			Scene scene = new Scene(root,800,600);
			/*
			 * Hoja de estilos
			 * Debe descargar CSS de 
			 * 
			 * https://bitbucket.org/agix-material-fx/materialfx-material-design-for-javafx.git
			 * 
			 * O comentar en caso de no querer usar
			 */
			scene.getStylesheets().add(getClass().getResource("material-fx-v0_3.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
