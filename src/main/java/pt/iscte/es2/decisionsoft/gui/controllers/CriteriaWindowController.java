package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import pt.iscte.es2.decisionsoft.domain.Criteria;
import pt.iscte.es2.decisionsoft.domain.ExperimentContext;

public class CriteriaWindowController extends ProblemTabMenuController implements Initializable{
	
	@FXML private TableView<Criteria> criteriaTable;
	@FXML private TableColumn<Criteria, String> criteriaNameColumn;
	@FXML private Button cancelCriteriasButton;
	@FXML private Button userDefinedCriteriaButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		context = new ExperimentContext(criterias, criterias.size());
		//criteriaNameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
		criteriaNameColumn.setOnEditCommit(cell -> {
			try {
				final String value = cell.getNewValue();
				cell.getRowValue().setName(value);//.setValue(value); //.setWeight(weight);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				new AlertMessage(Alert.AlertType.ERROR, "Error",
					e.getMessage()).showAndWait();
				criteriaTable.refresh();
			}
		});
		criteriaNameColumn.setCellValueFactory(
			cell -> new ReadOnlyStringWrapper(String.valueOf(cell.getValue().getName())));
		criteriaNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		criteriaTable.getItems().addAll(ExperimentContext.getCriterias());
		criteriaTable.setEditable(true);
		
//		criteriaList = new SingleCriteriaList(400);
//		criteriaNameColumn.setCellValueFactory(new PropertyValueFactory<String, String>("Criteria Name"));
//		criteriaTable.setItems(criteriaList.getCriteriaList());
//		criteriaTable.setEditable(true);
//		criteriaNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	@FXML
	public void handleCancelCriterias() {
		Stage stage = (Stage) cancelCriteriasButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	protected void handleSaveOptimizationCriteria(ActionEvent actionEvent) throws IOException {
		String filePath = "c:/Users/Mario/Desktop/teste.txt";
		FileWriter fw = new FileWriter(filePath, false);
		CriteriaWriter rw = new CriteriaWriter(fw);
		rw.write(context.getCriterias());
		
		for(int i = 0; i != context.getCriterias().size(); i++) {
			System.out.println("Tenho isto: " + context.getCriterias().get(i).getName() + context.getCriterias().get(i).getValue());
		}
		
		System.out.println("Saving Optimization Criteria");
	}
	
	@FXML
	protected void handleUserDefinedCriteria(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "userCriteriaDefinition.fxml", "User Criteria Definition");
//			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("userCriteriaDefinition.fxml"));
//			Parent parent = loader.load();
//			Scene secondaryScene = new Scene(parent);
//
//	        secondStage.setTitle("User Criteria Definition");
//	        secondStage.setScene(secondaryScene);
//	         
//	        secondStage.show();
//			
//	        UserCriteriaDefinitionController userCriteriaDefinitionController = loader.getController();
//	        userCriteriaDefinitionController.initData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
