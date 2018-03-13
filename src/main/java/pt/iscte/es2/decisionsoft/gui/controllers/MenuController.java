package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
	
	/**
	 * Opens the a menu scene
	 * @param actionEvent the fired event
	 * @param fileName String which contains the name of the .fxml that defines the menu design
	 * @throws IOException
	 */
	void openMenu(ActionEvent actionEvent, String fileName) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fileName));
		Parent parent = loader.load();
		Scene mainMenuScene = new Scene(parent);

		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		window.setScene(mainMenuScene);
	}

}
