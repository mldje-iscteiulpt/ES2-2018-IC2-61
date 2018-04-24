package pt.iscte.es2.decisionsoft.xml;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.scene.control.TextArea;

/**
 * Reads the .xml file and inserts its information in the GUI TextArea for the user to see
 * @author Mario
 *
 */

public class ReadXMLToGUI {

	public void readXMLToTextArea(String filePath, TextArea textArea) {
		try { 
			BufferedReader in = new BufferedReader(new FileReader(filePath)); 
			StringBuffer output = new StringBuffer(); 
			String st; 
			while ((st=in.readLine()) != null) { 
				output.append(st); 
			} 
			textArea.setText(output.toString());
//			System.out.println(output.toString()); 
			in.close(); 
		
		} catch (Exception fx) { 
			System.out.println("Exception " + fx.toString()); 
		}
	}

}
