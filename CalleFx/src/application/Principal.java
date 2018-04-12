/**
 * 
 */
package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * @author amesegue
 *
 */
public class Principal {
	
	@FXML
	private MenuItem principalMenuAcercaDe;
	@FXML
	private MenuBar principalMenuBar;
	@FXML
	private Parent raizPrincipal;
	
	/*
	 * Menú principal
	 */
	@FXML
	void principalMenuAcercaDeAction(ActionEvent event) throws IOException {		
		Stage  escenarioAcercaDe = new Stage();
		Parent raizAcercaDe = FXMLLoader.load(getClass().getResource("AcercaDe.fxml"));
		Scene escenaAcercaDe = new Scene(raizAcercaDe,300,200);
		escenaAcercaDe.getStylesheets().add(getClass().getResource("material-fx-v0_3.css").toExternalForm());
		
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
	
	/*
	 * 
	 */
}
