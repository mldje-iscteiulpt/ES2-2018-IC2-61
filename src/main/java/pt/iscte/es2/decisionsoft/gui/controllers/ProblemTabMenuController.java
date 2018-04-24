package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.algorithms.AlgorithmSelecter;
import pt.iscte.es2.decisionsoft.application.AlertMessage;
import pt.iscte.es2.decisionsoft.data.DataValidation;
import pt.iscte.es2.decisionsoft.domain.Criteria;
import pt.iscte.es2.decisionsoft.domain.ExperimentContext;
import pt.iscte.es2.decisionsoft.domain.ProblemInfo;
import pt.iscte.es2.decisionsoft.domain.Variable;
import pt.iscte.es2.decisionsoft.xml.XMLUtility;

/**
 * Class that handles all of the tabs in ProblemTabMenu scene
 * @author Mario
 *
 */

public class ProblemTabMenuController extends TransitionController {

	/** TextField that has the name of the problem */
	@FXML private TextField problemNameTextField;

	/** TextField which contains the problem description */
	@FXML private TextArea problemDescriptionTextArea;
	
	/** TextField which contains the user email */
	@FXML private TextField userEmailTextField;
	
	/** Button to return to previous scene */
	@FXML private Button backButton;
	
	/** Button to advance to next scene */
	@FXML private Button nextButton;
	
	/** TextField for the desirable time (in seconds) that the user wishes to wait for the solution */
	@FXML private TextField desirableTimeText;
	
	/** TextField for the maximum time (in seconds) that the user is willing to wait for the solution */
	@FXML private TextField maximumTimeText;
	
	/** Button that closes the FAQ secondary window */
	@FXML private Button closeAboutButton;
	
	@FXML private Button closeFAQButton;
	
	@FXML private Button saveButton;
	
	@FXML private MenuItem aboutMenuItem;

	@FXML private Button cancelVariablesNamesButton;
	
	@FXML private Button closeFAQ;
	
	@FXML private Button cancelAdminEmailButton;

	@FXML private Button sendEmailButton;
	
	@FXML private TextField numberDecisionVariablesText;
	
	@FXML private TextField variableGroupNameText;
	
	@FXML private TextField decisionVariableMin;
	
	@FXML private TextField decisionVariableMax;
	
	@FXML private RadioButton manualRadioButton;
	
	@FXML private RadioButton mixedRadioButton;
	
	@FXML private RadioButton autoRadioButton;
	
	@FXML private TextField jarFilePathTextField;
	
	@FXML private Button browseJar;
	
	@FXML final ToggleGroup algorithmModeGroup = new ToggleGroup();
	
	static ProblemInfo problemInfo;
	
	Stage secondStage;
	
	@FXML private RadioButton integerRadioButton;
	
	@FXML private RadioButton doubleRadioButton;
	
	@FXML private TextField invalidValues;
	
	@FXML private RadioButton booleanRadioButton;
	
	@FXML final ToggleGroup typeModeGroup = new ToggleGroup();
	
	List<String> invalidValuesList;
	
	DataValidation dataValidation;
	
	static ExperimentContext context;
	static AlgorithmSelecter algorithmSelecter;
	
	/**
	 * Instantiates the controller with a {@link ProblemDefinition} and {@link TimePreferences} objects
	 */
	
	public ProblemTabMenuController() {
		problemInfo = new ProblemInfo();
		//algorithmSelecter = new AlgorithmSelecter();
		this.secondStage = new Stage();
		dataValidation = new DataValidation();
		context = new ExperimentContext();
	}
	
	/**
	 * Method that handles the action of clicking the next button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			List<String> listaTeste = new ArrayList<String>();
			listaTeste.add("NSGA-II");
			listaTeste.add("outro algoritmo");
			XMLUtility.generateProblemResponseXml(listaTeste);
			XMLUtility.generateCriteriumRequestXml("NSGA-II");
			
			if(allDataItemsFilled() && verifyProblemInfoData()) {
				setProblemInfoData();
				
				XMLUtility.generateProblemRequestXml(problemInfo);
				
				openMenu(actionEvent,"AlgorithmSelection.fxml");
			}else if (!allDataItemsFilled()){
				new AlertMessage(Alert.AlertType.ERROR, "Incomplete Definition of Problem Parameters", "Please define all the problem items.").showAndWait();
			}
			else if(!verifyProblemInfoData()) {
				new AlertMessage(Alert.AlertType.ERROR, "Incorrect Data in Problem Parameters", "Please correct all the items of the problem.").showAndWait();
			}
		} catch (Exception e) {
			e.printStackTrace();
			new AlertMessage(Alert.AlertType.ERROR, "Error", "There's been an error in the problem configuration").showAndWait();
		}
	}
	
	
	/**
	 * Method that handles the action of clicking the back button
	 * @param actionEvent
	 */
	@FXML
	protected void handleBack(ActionEvent actionEvent) {
		try {
			openMenu(actionEvent, "UserMenu.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleFaqButton(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "FaqWindow.fxml", "FAQ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleContactAdminButton(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "ContactAdmin.fxml", "Contact Admin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleSetCriteria(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "CriteriaWindow.fxml", "Criteria Definition");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleSetVariableName(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "VariableNamesWindow.fxml", "Variable(s) Name(s)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void handleAbout(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "AboutMenu.fxml", "About");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleExit() {
		Platform.exit();
	}
	
	/**
	 * Opens the user menu scene
	 * @param actionEvent the fired event
	 * @param fileName that contains the .fxml file name that contains the design of the secondary window
	 * @param title is a string that contains the title for the secondary window
	 * @throws IOException
	 */
	void openSecondaryStage(ActionEvent actionEvent, String fileName, String title) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fileName));
		Parent parent = loader.load();
		Scene secondaryScene = new Scene(parent);

        secondStage.setTitle(title);
        secondStage.setScene(secondaryScene);
         
        secondStage.show();
	}
	
	@FXML
	public void handleAboutClose() {
	    Stage stage = (Stage) closeAboutButton.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void handleCloseFAQ() {
		Stage stage = (Stage) closeFAQ.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void handleCancelAdminEmailButton() {
		Stage stage = (Stage) cancelAdminEmailButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void handleSendEmailButton() {
		System.out.println("Email sent");
		Stage stage = (Stage) cancelAdminEmailButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void handleBrowseJar() {
		File file = fileChooser(getStage(jarFilePathTextField), ".jar", "Jar File (.jar)", "*.jar");
		if (file != null) {
			jarFilePathTextField.setText(file.getAbsolutePath());
			updateLastFolderPreference(file.getParent());
		}
	}
	
	protected boolean allDataItemsFilled() {
		if(problemNameTextField.getText().equals("") || problemDescriptionTextArea.getText().equals("") ||
				userEmailTextField.getText().equals("") || desirableTimeText.getText().equals("") || 
				maximumTimeText.getText().equals("") || numberDecisionVariablesText.getText().equals("") || 
				variableGroupNameText.getText().equals("") || decisionVariableMin.getText().equals("") || 
				decisionVariableMax.getText().equals("") || !checkInvalidValues()) {
			return false;
		}
		
		return true;
	}
	
	protected void setProblemInfoData() {
		System.out.println("Problem Name: " + problemNameTextField.getText());
		System.out.println("Problem Description: " + problemDescriptionTextArea.getText());
		System.out.println("User Email: " + userEmailTextField.getText());
		System.out.println("Desirable Time: " + Integer.parseInt(desirableTimeText.getText()));
		System.out.println("Max Time: " + Integer.parseInt(maximumTimeText.getText()));
		System.out.println("Number of Decision Variables: " + Integer.parseInt(numberDecisionVariablesText.getText()));
		System.out.println("Min Decision Variable: " + Integer.parseInt(decisionVariableMin.getText()));
		System.out.println("Max Decision Variable: " + Integer.parseInt(decisionVariableMax.getText()));
		problemInfo.setProblemName(problemNameTextField.getText());
		problemInfo.setProblemDescription(problemDescriptionTextArea.getText());
		problemInfo.setUserEmail(userEmailTextField.getText());
		problemInfo.setDesirableTime(Integer.parseInt(desirableTimeText.getText()));
		problemInfo.setMaxTime(Integer.parseInt(maximumTimeText.getText()));
		problemInfo.setNumberOfDecisionVariables(Integer.parseInt(numberDecisionVariablesText.getText()));
		problemInfo.setJarPath(jarFilePathTextField.getText());
		System.out.println("JAR: " + problemInfo.getJarPath());
		
		if(integerRadioButton.isSelected()) {
			problemInfo.setTypeOfVariable("int");
			System.out.println("int");
		}else if(doubleRadioButton.isSelected()) {
			problemInfo.setTypeOfVariable("double");
			System.out.println("double");
		}else {
			problemInfo.setTypeOfVariable("boolean");
			System.out.println("boolean");
		}
		
		problemInfo.setVariableGroupName(variableGroupNameText.getText());
		problemInfo.setDecisionVariableMin(Integer.parseInt(decisionVariableMin.getText()));
		problemInfo.setDecisionVariableMax(Integer.parseInt(decisionVariableMax.getText()));
		
		if(manualRadioButton.isSelected()) {
			problemInfo.setAlgorithmSelectionMode("manual");
			System.out.println("manual");
		}else if(mixedRadioButton.isSelected()) {
			algorithmSelecter.pickAlgorithms(problemInfo.getTypeOfVariable());
			problemInfo.setAlgorithmSelectionMode("mixed");
			System.out.println("mixed");
		}else {
			problemInfo.setAlgorithmSelectionMode("auto");
			System.out.println("auto");
		}
	}
	
	private boolean verifyProblemInfoData() {
		if(!userEmailTextField.getText().contains("@") || !dataValidation.isInteger(desirableTimeText.getText()) || !dataValidation.isInteger(maximumTimeText.getText()) || !dataValidation.isInteger(numberDecisionVariablesText.getText())
				|| !dataValidation.isString(variableGroupNameText.getText()) || !(dataValidation.isDouble(decisionVariableMin.getText())) || !(dataValidation.isDouble(decisionVariableMax.getText())) ){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public boolean checkInvalidValues() {
		if(!invalidValues.getText().equals("")) {
			invalidValuesList = Arrays.asList(invalidValues.getText().split(","));
			for(int i = 0; i != invalidValuesList.size(); i++) {
				if((integerRadioButton.isSelected() && !dataValidation.isInteger(invalidValuesList.get(i))) || doubleRadioButton.isSelected() && 
						!dataValidation.isInteger(invalidValuesList.get(i))) {
					return false;
				}if(booleanRadioButton.isSelected()) {
					if(!dataValidation.isBoolean(invalidValuesList.get(i))){
						return false;
					}
				}
			}
		}
		return true;
	}
}
