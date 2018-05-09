package pt.iscte.es2.decisionsoft.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pt.iscte.es2.decisionsoft.domain.Variable;


public class VariableTest {
	
	Variable var = new Variable("H2O", null);
	
	@Test
	void testGetName() {
		String output = var.getVariableName();
		assertEquals(output, "H2O");
		
	}
	
	@Test
	void testGetValue() {
		String output = var.getValue();
		assertEquals(output, null);
	}
	

}
