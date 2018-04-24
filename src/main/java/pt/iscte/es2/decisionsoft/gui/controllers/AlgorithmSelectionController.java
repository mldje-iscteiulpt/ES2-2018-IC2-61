package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import pt.iscte.es2.decisionsoft.algorithms.AlgorithmSelecter;
import pt.iscte.es2.decisionsoft.application.AlertMessage;

public class AlgorithmSelectionController extends TransitionController{
	
	@FXML private Button backButton;
	@FXML private Button nextButton;
	
	@FXML CheckBox abyssCB;
	@FXML CheckBox cellDECB;
	@FXML CheckBox dMPOSOCB;
	@FXML CheckBox gde3CB;
	@FXML CheckBox gwasfgaCB;
	@FXML CheckBox ibeaCB;
	@FXML CheckBox mochcCB;
	@FXML CheckBox moCellCB;
	@FXML CheckBox moeaDECB;
	@FXML CheckBox moeadDDCB;
	@FXML CheckBox moeaDRACB;
	@FXML CheckBox nsga2CB;
	@FXML CheckBox ssNSGA2CB;
	@FXML CheckBox nsga3CB;
	@FXML CheckBox pesa2CB;
	@FXML CheckBox paesCB;
	@FXML CheckBox omopsoCB;
	@FXML CheckBox smsemoaCB;
	@FXML CheckBox smpsoCB;
	@FXML CheckBox randomSearchCB;
	@FXML CheckBox spea2CB;
	@FXML CheckBox wasfgaCB;
	@FXML CheckBox mombi2CB;
	
	Map<String, CheckBox> checkBoxes;
	
	@FXML ChoiceBox<String> choiceBox;
	
	private void addCheckBoxesToList() {
		checkBoxes = new HashMap<String, CheckBox>();
		checkBoxes.put("AbYSS", abyssCB);
		checkBoxes.put("CellDE45", cellDECB);
		checkBoxes.put("DMOPSO", dMPOSOCB);
		checkBoxes.put("GDE3", gde3CB);
		checkBoxes.put("GWASFGA",gwasfgaCB);
		checkBoxes.put("IBEA",ibeaCB);
		checkBoxes.put("MOCHC", mochcCB);
		checkBoxes.put("MOCell",moCellCB);
		checkBoxes.put("MOEA/D", moeadDDCB);
		checkBoxes.put("MOEA/D-DRA",moeaDRACB);
		checkBoxes.put("NSGA-II",nsga2CB);
		checkBoxes.put("ssNSGA-II",ssNSGA2CB);
		checkBoxes.put("NSGA-III", nsga3CB);
		checkBoxes.put("PESA-2", pesa2CB);
		checkBoxes.put("PAES",paesCB);
		checkBoxes.put("OMOPSO", omopsoCB);
		checkBoxes.put("SMSEMOA", smsemoaCB);
		checkBoxes.put("SMPSO", smpsoCB);
		checkBoxes.put("RandomSearch", randomSearchCB);
		checkBoxes.put("SPEA2", spea2CB);
		checkBoxes.put("WASFGA", wasfgaCB);
		checkBoxes.put("mombi2CB",mombi2CB);
	}

	@FXML
	private void initialize(){
		addCheckBoxesToList();
		//choiceBox.getItems().addAll("a");
		List<String> algorithms = new ArrayList<String>();
		algorithms.addAll(AlgorithmSelecter.getSelectedAlgorithms());
		
		for (Map.Entry<String, CheckBox> pair : checkBoxes.entrySet()) {
			pair.getValue().setDisable(true);
		}
		
		for (Map.Entry<String, CheckBox> pair : checkBoxes.entrySet()) {
			for(int i = 0; i != algorithms.size(); i++) {
				if(pair.getKey().equals(algorithms.get(i))) {
					pair.getValue().setDisable(false);
					pair.getValue().setSelected(true);
				}
			}
		}
	}
	
	public int getNumberOfSelectedCheckBoxes() {
		int number = 0;
		for (Map.Entry<String, CheckBox> pair : checkBoxes.entrySet()) {
			if(pair.getValue().isSelected()) {
				number+=1;
			}
		}
		return number;
	}

	@FXML
	private void handleBackButton(ActionEvent actionEvent) throws IOException {
		openMenu(actionEvent, "ProblemTabMenu.fxml");
	}
	
	@FXML
	private void handleNextButton(ActionEvent actionEvent) throws IOException {
		//System.out.println("Selected Algorithm: " + selectedAlgorithm);
		if(getNumberOfSelectedCheckBoxes() != 1) {
			new AlertMessage(Alert.AlertType.ERROR, "Error", "You have selected " + getNumberOfSelectedCheckBoxes() + " algorithms. Please choose one.").showAndWait();
		}else {
			openMenu(actionEvent, "Dashboard.fxml");
		}
	}
}
