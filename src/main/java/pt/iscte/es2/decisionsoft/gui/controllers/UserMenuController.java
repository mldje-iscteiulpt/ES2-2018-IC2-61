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

public class UserMenuController {
	
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
	
	/**
	 * Loads the user home folder
	 */
	
	private static final Preferences USER_PREFERENCES = Preferences.userRoot()
			.node(UserMenuController.class.getName());
	
	/**
	 * Contains the previous used folder
	 */
	
	private static final String LAST_USED_FOLDER = "LAST_USED_FOLDER";
	
	/**
	 * Handles the actions that occur when clicking the next button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			openProblemTabMenu(actionEvent);
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
			openMainMenu(actionEvent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Opens the main menu scene
	 * @param actionEvent the fired event
	 * @throws IOException
	 */
	private void openMainMenu(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
		Parent parent = loader.load();
		Scene mainMenuScene = new Scene(parent);

		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		window.setScene(mainMenuScene);
	}
	
	/**
	 * Opens the problem tab menu scene
	 * @param actionEvent the fired event
	 * @throws IOException
	 */
	private void openProblemTabMenu(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ProblemTabMenu.fxml"));
		Parent parent = loader.load();
		Scene problemTabMenu = new Scene(parent);

		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		window.setScene(problemTabMenu);
	}
	
	/**
	 * FileChooser which returns a File that the user selected.
	 * @param stage - Primary Stage which is associated with the main Stage where the buttons are located
	 * @param title - File chooser title
	 * @param name - File name example
	 * @param extensions - Extensions allowed
	 * @return the selected file or null if no file has been selected
	 */
	private File fileChooser(Stage stage, String title, String name, String extensions) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		fileChooser.setInitialDirectory(new File(
			USER_PREFERENCES.get(LAST_USED_FOLDER, System.getProperty("user.home"))
		));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(name, extensions));
		return fileChooser.showOpenDialog(stage);
	}
	
	/**
	 * Handles the browse Button for creating a configuration file
	 */
	
	@FXML
	protected void handleBrowseCreateConfig() {
		File file = fileChooser(getStage(), ".cf", "Rules.cf", "*.cf");
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
		File file = fileChooser(getStage(), ".cf", "Rules2.cf", "*.cf");
		if (file != null) {
			loadConfigField.setText(file.getAbsolutePath());
			updateLastFolderPreference(file.getParent());
		}
	}

	
	/**
	 * @return the current stage
	 */
	private Stage getStage() {
		return (Stage) newConfigField.getScene().getWindow();
	}
	
	/**
	 * Changes the last used folder (when opening a file) to the file being opened
	 * @param lastUsedFolder last used folder for opening a file
	 */
	private static void updateLastFolderPreference(String lastUsedFolder) {
		USER_PREFERENCES.put(LAST_USED_FOLDER, lastUsedFolder);
	}

}
