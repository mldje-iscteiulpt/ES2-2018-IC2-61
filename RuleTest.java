package pt.iscte.es2.decisionsoft.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pt.iscte.es2.decisionsoft.domain.Rule;

public class RuleTest {
	
	
	@Test
	void getName() {
		Rule rule = new Rule("regra");
		String output = rule.getName();
		assertEquals(output, "regra");
		
	}
	
	@Test
	void getNameNull() {
		Rule rule = new Rule("regra");
		String output = rule.getName();
		assertNotNull(output);
		
	}

}
