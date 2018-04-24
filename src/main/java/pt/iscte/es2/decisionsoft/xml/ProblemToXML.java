package pt.iscte.es2.decisionsoft.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pt.iscte.es2.decisionsoft.domain.ProblemInfo;

/**
 * Class that transforms a problem information/attributos to an .xml file
 * @author Mario
 *
 */

public class ProblemToXML {
	
	ProblemInfo problem;
	  
	public void createXML() {
	  try {

		File file = new File("C:\\file.xml"); //alterar para ficheiro definido pelo user
		JAXBContext jaxbContext = JAXBContext.newInstance(ProblemInfo.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(problem, file);
		jaxbMarshaller.marshal(problem, System.out);

	      } catch (JAXBException e) {
	    	  e.printStackTrace();
	      }

	}
	
	

}
