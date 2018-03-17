package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.application.AlertMessage;

/**
 * Class that handles the main menu scene
 * @author Mario
 *
 */

public class MainMenuController extends TransitionController{
	
	/**
	 * RadioButton to select user profile
	 */
	@FXML
	private RadioButton userRadioButton;

	/**
	 * RadioButton to select administrator profile
	 */
	@FXML
	private RadioButton adminRadioButton;
	
	/**
	 * Button to change to next scene
	 */
	@FXML
	private Button next;
	
	/**
	 * Button to exit the application
	 */
	@FXML
	private Button exit;
	
	/**
	 * ToggleGroup that is composed of two RadioButtons: user profile and administrator profile.
	 */
	final ToggleGroup typeOfUser = new ToggleGroup();

	/**
	 * Defines what happens when the button next is clicked.
	 * @param actionEvent the fired event
	 * @catch IOException
	 */
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			if(userRadioButton.isSelected()) {
				openMenu(actionEvent, "UserMenu.fxml");
			}else{
				openMenu(actionEvent, "AdminWindow.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new AlertMessage(Alert.AlertType.ERROR, "Error", "You must select a profile.").showAndWait();
		}
	}
	
	/**
	 * Defines what happens when the button exit is clicked.
	 */
	@FXML
	protected void handleExit() {
		Platform.exit();
	}
	
}
