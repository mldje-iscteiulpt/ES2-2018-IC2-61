package pt.iscte.es2.decisionsoft.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pt.iscte.es2.decisionsoft.problem.ProblemInfo;

/**
 * Reads an .xml file and instantiates a {@link ProblemInfo} object with the info contained in the .xml file
 * @author Mario
 *
 */

public class XMLToProblem {
	
	ProblemInfo problem;


	public void createProblemWithSolution() {

		 try {

			File file = new File("C:\\file.xml"); //pôr path do ficheiro recebido do servidor
			JAXBContext jaxbContext = JAXBContext.newInstance(ProblemInfo.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			problem = (ProblemInfo) jaxbUnmarshaller.unmarshal(file);
			System.out.println(problem);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

}
