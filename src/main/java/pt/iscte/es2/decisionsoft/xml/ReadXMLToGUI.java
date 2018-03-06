package pt.iscte.es2.decisionsoft.xml;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Reads the .xml file and inserts its information in the GUI TextArea for the user to see
 * @author Mario
 *
 */

public class ReadXMLToGUI {

	public void readXMLToTextArea() {
		try { 
			BufferedReader in = new BufferedReader(new FileReader("c:\\myExample.xml")); 
			StringBuffer output = new StringBuffer(); 
			String st; 
			while ((st=in.readLine()) != null) { 
				output.append(st); 
			} 
			System.out.println(output.toString()); 
			in.close(); 
		
		} catch (Exception fx) { 
			System.out.println("Exception " + fx.toString()); 
		}
	}

}
