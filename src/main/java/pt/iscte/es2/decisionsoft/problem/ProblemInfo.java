package pt.iscte.es2.decisionsoft.problem;

/**
 * Class that creates an object which contains the problem information
 * @author Mario
 *
 */

public class ProblemInfo {
	
	private String problemName, problemDescription, userEmail, algorithmSelectionMode, jarPath, variableGroupName; int desirableTime, 
	maxTime, numberOfDecisionVariables, decisionVariableMin, decisionVariableMax; String[] invalidValues, decisionVariables, 
	availableAlgorithms; 
	
	public String getProblemName() {
		return problemName;
	}
	
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAlgorithmSelectionMode() {
		return algorithmSelectionMode;
	}

	public void setAlgorithmSelectionMode(String algorithmSelectionMode) {
		this.algorithmSelectionMode = algorithmSelectionMode;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	public String getVariableGroupName() {
		return variableGroupName;
	}

	public void setVariableGroupName(String variableGroupName) {
		this.variableGroupName = variableGroupName;
	}

	public int getDesirableTime() {
		return desirableTime;
	}

	public void setDesirableTime(int desirableTime) {
		this.desirableTime = desirableTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public int getNumberOfDecisionVariables() {
		return numberOfDecisionVariables;
	}

	public void setNumberOfDecisionVariables(int numberOfDecisionVariables) {
		this.numberOfDecisionVariables = numberOfDecisionVariables;
	}

	public int getDecisionVariableMin() {
		return decisionVariableMin;
	}

	public void setDecisionVariableMin(int decisionVariableMin) {
		this.decisionVariableMin = decisionVariableMin;
	}

	public int getDecisionVariableMax() {
		return decisionVariableMax;
	}

	public void setDecisionVariableMax(int decisionVariableMax) {
		this.decisionVariableMax = decisionVariableMax;
	}

	public String[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(String[] invalidValues) {
		this.invalidValues = invalidValues;
	}

	public String[] getDecisionVariables() {
		return decisionVariables;
	}

	public void setDecisionVariables(String[] decisionVariables) {
		this.decisionVariables = decisionVariables;
	}

	public String[] getAvailableAlgorithms() {
		return availableAlgorithms;
	}

	public void setAvailableAlgorithms(String[] availableAlgorithms) {
		this.availableAlgorithms = availableAlgorithms;
	}

}
