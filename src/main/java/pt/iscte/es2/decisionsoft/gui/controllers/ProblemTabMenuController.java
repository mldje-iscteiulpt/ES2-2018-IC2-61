package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pt.iscte.es2.decisionsoft.application.AlertMessage;

/**
 * Class that handles all of the tabs in ProblemTabMenu scene
 * @author Mario
 *
 */

public class ProblemTabMenuController {
	
	/**
	 * Instantiation of the Problem object
	 */
	
	private ProblemDefinition problemDefinition;
	
	/**
	 * TextField that has the name of the problem
	 */
	
	@FXML
	private TextField problemNameTextField;

	/**
	 * TextField which contains the problem description
	 */
	
	@FXML
	private TextArea problemDescriptionTextArea;
	
	/**
	 * TextField which contains the user email
	 */
	
	@FXML
	private TextField userEmailTextField;
	
	/**
	 * Button to return to previous scene
	 */
	
	@FXML
	private Button backButton;
	
	/**
	 * Button to advance to next scene
	 */
	
	@FXML
	private Button nextButton;
	
	/**
	 * Instantiates the controller with a {@link ProblemDefinition} object
	 */
	
	public ProblemTabMenuController() {
		problemDefinition = new ProblemDefinition();
	}
	
	/**
	 * Method that handles the action of clicking the next button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			//problemDefinition.openAlgorithmSelectionMenu(actionEvent);
		} catch (Exception e) {
			e.printStackTrace();
			new AlertMessage(Alert.AlertType.ERROR, "Error", "You must select an algorithm.").showAndWait();
		}
	}
	
	/**
	 * Method that handles the action of clicking the back button
	 * @param actionEvent
	 */
	@FXML
	protected void handleBack(ActionEvent actionEvent) {
		try {
			problemDefinition.openUserMenu(actionEvent);
			System.out.println("Back");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
