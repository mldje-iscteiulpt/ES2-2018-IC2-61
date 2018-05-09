package pt.iscte.es2.decisionsoft.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pt.iscte.es2.decisionsoft.domain.Criteria;
public class CriteriaTest {

	Criteria criteria = new Criteria("Abc", "2");

	
	
	@Test
	void testGetName() {
		String output = criteria.getName();
		assertEquals(output, "Abc");		
	}
	
	@Test
	void getValue() {
	String output = criteria.getValue();
	assertEquals(output, "2");
		
	}
	
}
