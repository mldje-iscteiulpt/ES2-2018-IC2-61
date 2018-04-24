package pt.iscte.es2.decisionsoft.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Context of AntiSpam configuration which includes needed values
 * for running NSGA-II and saving the rules file
 */
public class ExperimentContext {
	private static List<Criteria> criterias;
	private static List<Variable> variables;
	private final int SIZE = 400;
	//private static String contextPath;

	/**
	 * {@link ExperimentContext} constructor
	 * @param ham ham messages
	 * @param spam spam messages
	 * @param weightedRules rules and weights to populate the table
	 * @param rulesPath rules file used for saving
	 */
	public ExperimentContext() {
		ExperimentContext.criterias = new ArrayList<Criteria>();
		ExperimentContext.variables = new ArrayList<Variable>();
		for(int i = 0; i != SIZE; i++) {
			criterias.add(new Criteria("",""));
			variables.add(new Variable("",""));
		}
	}

	/**
	 * Get the weights and rules
	 * @return weights and rules
	 */
	public static List<Criteria> getCriterias() {
		return criterias;//Collections.unmodifiableList(criterias);
	}
	
	public static List<Variable> getVariables() {
		return variables; //Collections.unmodifiableList(variables);
	}
	
}