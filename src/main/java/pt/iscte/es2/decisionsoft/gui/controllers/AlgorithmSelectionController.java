package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AlgorithmSelectionController extends MenuController{
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button nextButton;
	
	@FXML
	private void handleBackButton(ActionEvent actionEvent) throws IOException {
		openMenu(actionEvent, "ProblemTabMenu.fxml");
	}
	
	@FXML
	private void handleNextButton(ActionEvent actionEvent) throws IOException {
		openMenu(actionEvent, "Dashboard.fxml");
	}

}
