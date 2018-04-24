package pt.iscte.es2.decisionsoft.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
	
	public boolean isBoolean(String str) {
		try {
	           Boolean.parseBoolean(str);
	           return true;
	       } catch (NullPointerException e) {
	           return false;
	       }
	}
	
	 public boolean isDouble(String str) {
	       try {
	           Double.parseDouble(str);
	           return true;
	       } catch (NumberFormatException e) {
	           return false;
	       }
	 }
	
	public boolean isInteger(String str) {
	    if(str == null || str.trim().isEmpty()) {
	        return false;
	    }
	    for (int i = 0; i < str.length(); i++) {
	        if(!Character.isDigit(str.charAt(i))) {
	            return false;
	        } 
	    }
	    return true;
	}
	
	public boolean isString(String str) {
		final Pattern p = Pattern.compile("[a-zA-Z]+");

		final Matcher m = p.matcher(str);

		if (m.find()) {
			return true;
		}
		return false;
	}

}
