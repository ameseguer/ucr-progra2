/**
 * 
 */
package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

import Calle.Carro;
import Calle.ConstantesTipoCarro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author amesegue
 *
 */
public class Principal {
	
	@FXML
	private MenuItem principalMenuAcercaDe;
	@FXML
	private MenuItem principalImportarMenuItem;
	@FXML
	private MenuBar principalMenuBar;
	@FXML
	private Parent raizPrincipal;
	@FXML
	private Canvas principalCanvas;
	@FXML
	private TextArea princpalLogTextArea;
	@FXML
	private RadioMenuItem principalMenuDebug;
	
	private File archivo;
	
	private static boolean DEBUG = false;
	private Animación animación= new Animación();

	/*
	 * Menú principal
	 */
	
	@FXML 
	void principalImportarMenuItemAction(ActionEvent event){
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    chooser.getExtensionFilters().addAll(
	            new ExtensionFilter("City", "*.txt", "*.xml", "*.json"),
	            new ExtensionFilter("All Files", "*.*")
	            );
	    
	  //Open directory from existing directory
        if(archivo != null){
            File existDirectory = archivo.getParentFile();
            chooser.setInitialDirectory(existDirectory);
        }

	   File archivo = chooser.showOpenDialog(principalImportarMenuItem.getParentPopup().getScene().getWindow());
	   
	   String nombreArchivo = archivo.getPath();
	   
	   if(DEBUG) {
		   princpalLogTextArea.appendText("Opening "+nombreArchivo+System.lineSeparator());
	   }
	   
	   
	
	}
	
	@FXML
	void principalMenuDebugAction(ActionEvent event) {
		if (DEBUG) {
			DEBUG=false;
		}
		else {
			DEBUG=true;
		}
		princpalLogTextArea.appendText("Debug "+DEBUG);
	}
	
	@FXML
	void principalMenuAcercaDeAction(ActionEvent event) throws IOException {		
		Stage  escenarioAcercaDe = new Stage();
		Parent raizAcercaDe = FXMLLoader.load(getClass().getResource("AcercaDe.fxml"));
		Scene escenaAcercaDe = new Scene(raizAcercaDe,300,200);
		//escenaAcercaDe.getStylesheets().add(getClass().getResource("material-fx-v0_3.css").toExternalForm());
		
		/*
		 * Función lambda para cerrar ventana 'Acerca de'
		 */
		escenarioAcercaDe.focusedProperty().addListener((observable, oldValue, newValue) -> {
			//bloquear ventana principal mientras se muestra el acerca de
			raizPrincipal.disableProperty().bind(escenarioAcercaDe.showingProperty());
			/*
			 * TODO: cerrar acerca de cuando pierde foco
			 */
			
        });
		/*
		 * Fin de función lambda 
		 */
		
		escenarioAcercaDe.setScene(escenaAcercaDe);
		escenarioAcercaDe.show();
		//escenarioAcercaDe.showAndWait();
	}
	
	@FXML
	void principalCanvasMouseClicked(MouseEvent event) throws FileNotFoundException {
		if (DEBUG) {
			princpalLogTextArea.appendText("Dibujando Carro");
		}
		int y = (int)event.getSceneY();
		int x = (int)event.getSceneX();
		GraphicsContext gc= principalCanvas.getGraphicsContext2D();
		
		animación.dibujarCarro(x,y,null,gc);
	}
	
	@FXML 
	void principalCanvasMouseReleased(MouseEvent event) throws FileNotFoundException{
		principalCanvasMouseClicked(event);
	}
	

}
