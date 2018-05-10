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
	void getNameNotNull() {
		Rule rule = new Rule("regra");
		String output = rule.getName();
		assertNotNull(output);
		
	}
	@Test
	void isEquals() {
		Object obj = null;
		Rule rule = new Rule("name");
		boolean b = rule.equals(obj);
		assertFalse(b);
		assertNull(obj);
	}
	
	@Test
	void isNotEquals() {
		Object obj = new Object();
		Rule rule = new Rule("name");
		boolean b = rule.equals(obj);
		assertFalse(b);
	}
	
	@Test
	void getWeight() {
		Rule rule = new Rule("name", 3.00);
		double d = rule.getWeight();
		assertEquals(d, 3.00, 0);

	}

}
