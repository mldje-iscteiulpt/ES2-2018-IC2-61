package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardController extends TransitionController {
	
	@FXML
	private Button backButton;
	
	@FXML
	void handleBackButton(ActionEvent actionEvent) throws IOException {
		openMenu(actionEvent,"AlgorithmSelection.fxml");
	}

}
