package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pt.iscte.es2.decisionsoft.xml.ReadXMLToGUI;
import pt.iscte.es2.decisionsoft.xml.SaveToXML;

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
	private TextArea xmlTextArea;
	
	private SaveToXML saveXML;
	
	private ReadXMLToGUI readXML;
	
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
		readXML = new ReadXMLToGUI();
		readXML.readXMLToTextArea(xmlPathTextField.getText(), xmlTextArea);
	}
	
	@FXML
	protected void handleSaveButton(ActionEvent actionEvent) {
		System.out.println(xmlPathTextField.getText());
		System.out.println(xmlTextArea.getText());
		saveXML = new SaveToXML(this);
		try {
			saveXML.writeStringToFile(new File(xmlPathTextField.getText()), xmlTextArea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public TextArea getTextArea() {
		return xmlTextArea;
	}
}
