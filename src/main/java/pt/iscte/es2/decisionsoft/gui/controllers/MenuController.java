package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.File;
import java.util.prefs.Preferences;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController {
	
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
	 * FileChooser which returns a File that the user selected.
	 * @param stage - Primary Stage which is associated with the main Stage where the buttons are located
	 * @param title - File chooser title
	 * @param name - File name example
	 * @param extensions - Extensions allowed
	 * @return the selected file or null if no file has been selected
	 */
	protected File fileChooser(Stage stage, String title, String name, String extensions) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		fileChooser.setInitialDirectory(new File(
			USER_PREFERENCES.get(LAST_USED_FOLDER, System.getProperty("user.home"))
		));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(name, extensions));
		return fileChooser.showOpenDialog(stage);
	}

	/**
	 * Changes the last used folder (when opening a file) to the file being opened
	 * @param lastUsedFolder last used folder for opening a file
	 */
	protected static void updateLastFolderPreference(String lastUsedFolder) {
		USER_PREFERENCES.put(LAST_USED_FOLDER, lastUsedFolder);
	}
	
	/**
	 * @return the current stage
	 */
	protected Stage getStage(TextField tf) {
		return (Stage) tf.getScene().getWindow();
	}
}
