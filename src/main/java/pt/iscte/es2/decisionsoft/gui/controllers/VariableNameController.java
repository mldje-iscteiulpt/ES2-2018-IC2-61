package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.application.AlertMessage;
import pt.iscte.es2.decisionsoft.data.CriteriaWriter;
import pt.iscte.es2.decisionsoft.data.VariableWriter;
import pt.iscte.es2.decisionsoft.domain.ExperimentContext;
import pt.iscte.es2.decisionsoft.domain.Variable;

public class VariableNameController extends ProblemTabMenuController implements Initializable{
	
	@FXML private TableView<Variable> variableNameTable;
	
	@FXML private TableColumn<Variable, String> variableNameColumn;

	@FXML private Button cancelVariablesNamesButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		variableNameColumn.setOnEditCommit(cell -> {
			try {
				final String value = cell.getNewValue();
				cell.getRowValue().setName(value); //.setValue(value); //.setWeight(weight);
				//variableNameTable.refresh();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				new AlertMessage(Alert.AlertType.ERROR, "Error",
					e.getMessage()).showAndWait();
				variableNameTable.refresh();
			}
		});
		variableNameColumn.setCellValueFactory(
			cell -> new ReadOnlyStringWrapper(String.valueOf(cell.getValue().getVariableName())));
		variableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		variableNameTable.getItems().addAll(ExperimentContext.getVariables());
		variableNameTable.setEditable(true);
//		criteriaList = new SingleCriteriaList(400);
//		variableNameColumn.setCellValueFactory(new PropertyValueFactory<Variable, String>("GetVariables"));
//		variableNameTable.setItems(criteriaList.getCriteriaList());
//		variableNameTable.setEditable(true);
//		variableNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	@FXML
	protected void handleSaveVariableNames(ActionEvent actionEvent) throws IOException {
		String filePath = "c:/Users/Mario/Desktop/teste.txt";
		FileWriter fw = new FileWriter(filePath, false);
		VariableWriter rw = new VariableWriter(fw);
		rw.write(ExperimentContext.getVariables());
		
		for(int i = 0; i != ExperimentContext.getVariables().size(); i++) {
			System.out.println("Tenho isto: " + ExperimentContext.getVariables().get(i).getVariableName());// + context.getVariables().get(i).getValue());
		}
		
		System.out.println("Saving Optimization Variables");
		problemInfo.setVariables(ExperimentContext.getVariables());
		
		new AlertMessage(Alert.AlertType.INFORMATION, "Save Variable", "Variables saved with success!")
		.showAndWait();
	}
	
	@FXML
	public void handleCancelVariablesButtons() {
		Stage stage = (Stage) cancelVariablesNamesButton.getScene().getWindow();
		stage.close();
	}
	
}
