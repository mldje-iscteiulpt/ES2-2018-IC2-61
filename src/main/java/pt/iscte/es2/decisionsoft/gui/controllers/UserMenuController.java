package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.application.AlertMessage;

public class UserMenuController extends TransitionController{
	
	/**
	 * RadioButton used to select creating a configuration file
	 */
	
	@FXML
	private RadioButton createConfig;

	/**
	 * RadioButton used to select loading a configuration file
	 */
	
	@FXML
	private RadioButton loadConfig;
	
	/**
	 * Button used to browse a path where to create a configuration file
	 */
	
	@FXML
	private Button browseCreate;
	
	/**
	 * Button used to browse a configuration file to load
	 */
	
	@FXML
	private Button browseLoad;
	
	/**
	 * TextField that shows the path for the new configuration file
	 */
	
	@FXML
	private TextField newConfigField;
	
	/**
	 * TextField that shows the path for the loaded configuration file
	 */
	
	@FXML
	private TextField loadConfigField;
	
	/**
	 * Button for the next scene
	 */
	
	@FXML
	private Button next;
	
	/**
	 * Button to return to previous scene
	 */
	
	@FXML
	private Button back;
	
	/**
	 * Groups the create configuration file and load configuration file RadioButtons
	 */
	
	final ToggleGroup defineConfig = new ToggleGroup();
	
	protected boolean allDataItemsFilled() {
		if(newConfigField.getText().equals("") || loadConfigField.getText().equals("")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Handles the actions that occur when clicking the next button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			if(allDataItemsFilled()) {
				openMenu(actionEvent, "ProblemTabMenu.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new AlertMessage(Alert.AlertType.ERROR, "Error", "You must select a profile.").showAndWait();
		}
	}
	
	/**
	 * Handles the actions that occur when clicking the previous button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleBack(ActionEvent actionEvent) {
		try {
			openMenu(actionEvent, "MainMenu.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Handles the browse Button for creating a configuration file
	 */
	
	@FXML
	protected void handleBrowseCreateConfig() {
		File file = fileChooser(getStage(newConfigField), ".cf", "Rules.cf", "*.cf");
		if (file != null) {
			newConfigField.setText(file.getAbsolutePath());
			updateLastFolderPreference(file.getParent());
		}
	}
	
	/**
	 * Handles the browse Button for loading a configuration file
	 */
	@FXML
	protected void handleBrowseLoadConfig() {
		File file = fileChooser(getStage(loadConfigField), ".cf", "Rules2.cf", "*.cf");
		if (file != null) {
			loadConfigField.setText(file.getAbsolutePath());
			updateLastFolderPreference(file.getParent());
		}
	}

}
