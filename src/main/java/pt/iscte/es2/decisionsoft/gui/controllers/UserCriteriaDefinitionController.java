package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
import pt.iscte.es2.decisionsoft.domain.Criteria;
import pt.iscte.es2.decisionsoft.domain.ExperimentContext;
import pt.iscte.es2.decisionsoft.domain.ProblemInfo;

public class UserCriteriaDefinitionController extends ProblemTabMenuController implements Initializable{
	
	@FXML private Button saveUserDefinedCriteria;
	@FXML private Button cancelUserDefinedCriteriaButton;
	@FXML private TableView<Criteria> userDefinedCriteriaTable;
	@FXML private TableColumn<Criteria, String> criteriaNameColumn;
	@FXML private TableColumn<Criteria, String> criteriaValue;
	//static ProblemInfo problemInfo; //TESTE
	
	@FXML
	public void handlesaveUserDefinedCriteria() throws IOException {
		String filePath = "c:/Users/Mario/Desktop/teste.txt";
		FileWriter fw = new FileWriter(filePath, false);
		CriteriaWriter rw = new CriteriaWriter(fw);
		rw.write(ExperimentContext.getCriterias());
		
		for(int i = 0; i != ExperimentContext.getCriterias().size(); i++) {
			System.out.println("Tenho isto: " + ExperimentContext.getCriterias().get(i).getName() + ExperimentContext.getCriterias().get(i).getValue());// + context.getVariables().get(i).getValue());
		}
		
		System.out.println("Saved User Defined Criteria");
		problemInfo.setCriterias(ExperimentContext.getCriterias());
		
		new AlertMessage(Alert.AlertType.INFORMATION, "Save Criteria", "Criterias saved with success!")
		.showAndWait();
	}
	
	@FXML
	public void handleCancelUserDefinedCriteriaButton() {
		Stage stage = (Stage) cancelUserDefinedCriteriaButton.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 0; i != ExperimentContext.getCriterias().size(); i++) {
			System.out.println(ExperimentContext.getCriterias().get(i).getName() + ExperimentContext.getCriterias().get(i).getValue());
		}
		
		userDefinedCriteriaTable.getItems().addAll(ExperimentContext.getCriterias());
		criteriaNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		criteriaNameColumn.setOnEditCommit(cell -> {
			try {
				final String value = cell.getNewValue();
				cell.getRowValue().setName(value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				new AlertMessage(Alert.AlertType.ERROR, "Error",
					e.getMessage()).showAndWait();
				userDefinedCriteriaTable.refresh();
			}
		});
		criteriaValue.setCellFactory(TextFieldTableCell.forTableColumn());
		criteriaValue.setOnEditCommit(cell -> {
			try {
				final String value = cell.getNewValue();
				cell.getRowValue().setValue(value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				new AlertMessage(Alert.AlertType.ERROR, "Error",
					e.getMessage()).showAndWait();
				userDefinedCriteriaTable.refresh();
			}
		});
		criteriaNameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
		criteriaValue.setCellValueFactory(cell -> new ReadOnlyStringWrapper(String.valueOf(cell.getValue().getValue())));
		
		//criteriaNameColumn.setEditable(true);
		//criteriaValue.setEditable(true);
		//userDefinedCriteriaTable.getColumns().get(0).setEditable(true); //.setEditable(true);
		//userDefinedCriteriaTable.getColumns().get(1).setEditable(true);
		//15userDefinedCriteriaTable.setEditable(true);
//		criteriaNameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("Criteria Name"));
//		criteriaValue.setCellValueFactory(new PropertyValueFactory<String, String>("Value"));
//		userDefinedCriteriaTable.setItems(criteriaList.getCriteriaListFirstColumn());
//		userDefinedCriteriaTable.setItems(criteriaList.getValuesListSecondColumn());
//		userDefinedCriteriaTable.setEditable(true);
//		criteriaNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//		criteriaValue.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	
//	//TESTE
//	/**
//	 * Hidrates this controller with necessary data
//	 *
//	 * @param parentScene reference to the file selector stage
//	 * @param context     context with spam, ham and rules
//	 */
//	void initData() {
//		userDefinedCriteriaTable.getItems().addAll(context.getCriterias());
//	}
}