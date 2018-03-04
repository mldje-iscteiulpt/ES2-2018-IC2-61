package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class that has the methods used in the ProblemTabMenu scene, specifically the problem definition tab
 * @author Mario
 *
 */

public class ProblemDefinition {
	
	/**
	 * Opens the algorithm selection scene
	 * @param actionEvent the fired event
	 * @throws IOException
	 */
	void openAlgorithmSelectionMenu(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
		Parent parent = loader.load();
		Scene mainMenuScene = new Scene(parent);

		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		window.setScene(mainMenuScene);
	}
	
	/**
	 * Opens the user menu scene
	 * @param actionEvent the fired event
	 * @throws IOException
	 */
	void openUserMenu(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("UserMenu.fxml"));
		Parent parent = loader.load();
		Scene problemTabMenu = new Scene(parent);

		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		window.setScene(problemTabMenu);
	}

}
