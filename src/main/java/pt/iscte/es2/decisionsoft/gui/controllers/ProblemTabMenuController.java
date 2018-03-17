package pt.iscte.es2.decisionsoft.gui.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.application.AlertMessage;

/**
 * Class that handles all of the tabs in ProblemTabMenu scene
 * @author Mario
 *
 */

public class ProblemTabMenuController extends TransitionController {

	/**
	 * TextField that has the name of the problem
	 */
	
	@FXML
	private TextField problemNameTextField;

	/**
	 * TextField which contains the problem description
	 */
	
	@FXML
	private TextArea problemDescriptionTextArea;
	
	/**
	 * TextField which contains the user email
	 */
	
	@FXML
	private TextField userEmailTextField;
	
	/**
	 * Button to return to previous scene
	 */
	
	@FXML
	private Button backButton;
	
	/**
	 * Button to advance to next scene
	 */
	
	@FXML
	private Button nextButton;
	
	/**
	 * TextField for the desirable time (in seconds) that the user wishes to wait for the solution
	 */
	
	@FXML
	private TextField desirableTimeText;
	
	/**
	 * TextField for the maximum time (in seconds) that the user is willing to wait for the solution
	 */
	
	@FXML
	private TextField maximumTimeText;
	
	/**
	 * Button that closes the FAQ secondary window
	 */
	
	@FXML
	private Button closeAboutButton;
	
	@FXML
	private Button closeFAQButton;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private MenuItem aboutMenuItem;
	
	@FXML
	private Button userDefinedCriteriaButton;
	
	@FXML
	private Button cancelVariablesNamesButton;
	
	@FXML
	private Button cancelCriteriasButton;
	
	@FXML
	private Button saveUserDefinedCriteria;
	
	@FXML
	private Button cancelUserDefinedCriteriaButton;
	
	@FXML
	private Button closeFAQ;
	
	@FXML
	private Button cancelAdminEmailButton;
	
	@FXML
	private Button sendEmailButton;
	
	@FXML
	private TextField numberDecisionVariablesText;
	
	@FXML
	private TextField variableGroupNameText;
	
	@FXML
	private TextField decisionVariableMin;
	
	@FXML
	private TextField decisionVariableMax;
	
	Stage secondStage;
	
	/**
	 * Instantiates the controller with a {@link ProblemDefinition} and {@link TimePreferences} objects
	 */
	
	public ProblemTabMenuController() {
		//windowManager = new WindowManager();
		this.secondStage = new Stage();
	}
	
	/**
	 * Method that handles the action of clicking the next button
	 * @param actionEvent
	 */
	
	@FXML
	protected void handleNext(ActionEvent actionEvent) {
		try {
			if(allDataItemsFilled()) {
				openMenu(actionEvent,"AlgorithmSelection.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new AlertMessage(Alert.AlertType.ERROR, "Error", "You must select an algorithm.").showAndWait();
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
			//generalItemsMenu.openFAQ(actionEvent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleContactAdminButton(ActionEvent actionEvent) {
		try {
			//generalItemsMenu.openContactAdmin(actionEvent);
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
	protected void handleSaveOptimizationCriteria(ActionEvent actionEvent) {
		System.out.println("Saving Optimization Criteria");
	}
	
	@FXML
	protected void handleSaveVariableNames(ActionEvent actionEvent) {
		System.out.println("Saving Variables Names");
	}
	
	
	@FXML
	protected void handleUserDefinedCriteria(ActionEvent actionEvent) {
		try {
			openSecondaryStage(actionEvent, "userCriteriaDefinition.fxml", "User Criteria Definition");
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
	
	
//	/**
//	 * Opens the a menu scene
//	 * @param actionEvent the fired event
//	 * @param fileName String which contains the name of the .fxml that defines the menu design
//	 * @throws IOException
//	 */
//	void openMenu(ActionEvent actionEvent, String fileName) throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fileName));
//		Parent parent = loader.load();
//		Scene mainMenuScene = new Scene(parent);
//
//		Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//		window.setScene(mainMenuScene);
//	}
	
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
		// get a handle to the stage
	    Stage stage = (Stage) closeAboutButton.getScene().getWindow();
	    //System.out.println(closeAboutButton.getId());
	    // do what you have to do
	    stage.close();
	}
	
	@FXML
	public void handleCancelVariablesButtons() {
		Stage stage = (Stage) cancelVariablesNamesButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void handleCancelCriterias() {
		Stage stage = (Stage) cancelCriteriasButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void handlesaveUserDefinedCriteria() {
		System.out.println("Saved User Defined Criteria");
	}
	
	@FXML
	public void handleCancelUserDefinedCriteriaButton() {
		Stage stage = (Stage) cancelUserDefinedCriteriaButton.getScene().getWindow();
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
	
	protected boolean allDataItemsFilled() {
		if(problemNameTextField.getText().equals("") || problemDescriptionTextArea.getText().equals("") ||
				userEmailTextField.getText().equals("") || desirableTimeText.getText().equals("") || 
				maximumTimeText.getText().equals("") || numberDecisionVariablesText.getText().equals("") || 
				variableGroupNameText.getText().equals("") || decisionVariableMin.getText().equals("") || 
				decisionVariableMax.getText().equals("")) {
			return false;
		}
		
		return true;
	}
	
}
