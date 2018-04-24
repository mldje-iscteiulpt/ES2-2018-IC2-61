package pt.iscte.es2.decisionsoft.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.control.TextArea;
import pt.iscte.es2.decisionsoft.gui.controllers.AdminWindowController;

public class SaveToXML {
	
	private AdminWindowController admin;
	private TextArea textArea;
	
	public SaveToXML(AdminWindowController admin) {
		this.admin = admin;
		textArea = admin.getTextArea();
	}

	public void writeStringToFile(File file, TextArea textArea) throws IOException {
	    if (file == null)
	        throw new IllegalArgumentException("file cannot be null");

	    if (textArea == null)
	        throw new IllegalArgumentException("text cannot be null");

	    String filePath = file.getAbsolutePath();

	    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
	        writer.write(textArea.getText());
	    }
	}
	
}
