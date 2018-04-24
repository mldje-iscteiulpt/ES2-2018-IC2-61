package pt.iscte.es2.decisionsoft.domain;

public class Variable {
	
	private String name;
	private String value;
	
	public Variable(String name, String value) {
		this.name = name;
		if(value == null) {
			value = "null";
		}
	}
	
	public String getVariableName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
