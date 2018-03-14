package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminWindowController extends TransitionController{
	
	@FXML
	private Button loadButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button browseButton;
	
	@FXML
	private TextField xmlPathTextField;
	
	@FXML
	protected void handleBackButton(ActionEvent actionEvent) {
		try {
			openMenu(actionEvent, "UserMenu.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@FXML
	protected void handleLoadButton(ActionEvent actionEvent) {

	}
	
	@FXML
	protected void handleSaveButton(ActionEvent actionEvent) {
		System.out.println("Saving the xml file");
	}
	
	@FXML
	protected void handleBrowseButton(ActionEvent actionEvent) {
		File file = fileChooser(getStage(xmlPathTextField), ".cf", "Rules2.cf", "*.cf");
		if (file != null) {
			xmlPathTextField.setText(file.getAbsolutePath());
			updateLastFolderPreference(file.getParent());
		}
	}
}
