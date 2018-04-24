package pt.iscte.es2.decisionsoft.xml;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import pt.iscte.es2.decisionsoft.domain.ProblemInfo;

public class XMLUtility {

	public static Document generateProblemRequestXml(ProblemInfo request)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		// root element
		Element rootElement = doc.createElement("problem");
		doc.appendChild(rootElement);

		// algorithms element
		Element problemInfo = doc.createElement("problem-info");
		rootElement.appendChild(problemInfo);

		Element problemName = doc.createElement("problem");
		problemInfo.appendChild(problemName);
		Attr attrType = doc.createAttribute("name");
		attrType.setValue(request.getProblemName());
		problemName.setAttributeNode(attrType);
		problemName.appendChild(doc.createTextNode(request.getProblemDescription()));
		// problemName.appendChild(newElement);

//		Element problemDescription = doc.createElement("problem-description");
//		problemInfo.appendChild(problemDescription);
//		Attr attrTypeDescription = doc.createAttribute("description");
//		attrTypeDescription.setValue("");
//		problemDescription.setAttributeNode(attrTypeDescription);
//		problemDescription.appendChild(doc.createTextNode(request.getProblemDescription()));

		Element algorithmMode = doc.createElement("algorithm");
		problemInfo.appendChild(algorithmMode);
		Attr attrTypeMode = doc.createAttribute("mode");
		attrTypeMode.setValue(request.getAlgorithmSelectionMode());
		algorithmMode.setAttributeNode(attrTypeMode);
		//algorithmMode.appendChild(doc.createTextNode(request.getAlgorithmSelectionMode()));

		Element variableGroup = doc.createElement("variable");
		problemInfo.appendChild(variableGroup);
		Attr attrTypeVariableGroupName = doc.createAttribute("name");
		attrTypeVariableGroupName.setValue(request.getVariableGroupName());
		variableGroup.setAttributeNode(attrTypeVariableGroupName);
		//variableGroup.appendChild(doc.createTextNode(request.getVariableGroupName()));
		Attr attrTypeOfVariable = doc.createAttribute("type");
		attrTypeOfVariable.setValue(request.getTypeOfVariable());
		variableGroup.setAttributeNode(attrTypeOfVariable);
		//variableGroup.appendChild(doc.createTextNode(String.valueOf(request.getTypeOfVariable())));
		Attr attrNumberOfVariables = doc.createAttribute("number-of-variables");
		attrNumberOfVariables.setValue(String.valueOf(request.getNumberOfDecisionVariables()));
		variableGroup.setAttributeNode(attrNumberOfVariables);
		Attr attrDecisionVarMin = doc.createAttribute("minimum");
		attrDecisionVarMin.setValue((String.valueOf(request.getDecisionVariableMin())));
		variableGroup.setAttributeNode(attrDecisionVarMin);
		Attr attrDecisionVarMax = doc.createAttribute("maximum");
		attrDecisionVarMax.setValue((String.valueOf(request.getDecisionVariableMax())));
		variableGroup.setAttributeNode(attrDecisionVarMax);


		Element time = doc.createElement("time");
		problemInfo.appendChild(time);
		Attr attrTypeDesTime = doc.createAttribute("desirable");
		time.setAttributeNode(attrTypeDesTime);
		attrTypeDesTime.setValue(String.valueOf(request.getDesirableTime()));
		//desirableTime.appendChild(doc.createTextNode(String.valueOf(request.getDesirableTime())));
		Attr attrTypeMaxTime = doc.createAttribute("max");
		time.setAttributeNode(attrTypeMaxTime);
		attrTypeMaxTime.setValue(String.valueOf(request.getMaxTime()));
		//desirableTime.appendChild(doc.createTextNode(String.valueOf(request.getMaxTime())));

//		Element maxTime = doc.createElement("max-time");
//		problemInfo.appendChild(maxTime);
//		Attr attrTypeMaxTime = doc.createAttribute("time");
//		maxTime.setAttributeNode(attrTypeMaxTime);
//		maxTime.appendChild(doc.createTextNode(String.valueOf(request.getMaxTime())));

		if (request.getInvalidValues() != null) {

			Element invalidValues = doc.createElement("invalid-values");
			rootElement.appendChild(invalidValues);

			for (int i = 0; i != request.getInvalidValues().length; i++) {
				Element newElement = doc.createElement("value" + 1);
				Attr attrTypeInvalidValue = doc.createAttribute("value");
				attrTypeInvalidValue.setValue(request.getInvalidValues()[i]);
				newElement.setAttributeNode(attrTypeInvalidValue);
				newElement.appendChild(doc.createTextNode(request.getInvalidValues()[i]));
				invalidValues.appendChild(newElement);
			}
		}

		if (request.getInvalidValues() != null) {

			Element decisionValues = doc.createElement("decision-values");
			rootElement.appendChild(decisionValues);

			for (int i = 0; i != request.getDecisionVariables().length; i++) {
				Element newElement = doc.createElement("variable" + 1);
				Attr attrTypeDecisionName = doc.createAttribute("name");
				attrTypeDecisionName.setValue(request.getDecisionVariables()[i]);
				newElement.setAttributeNode(attrTypeDecisionName);
				newElement.appendChild(doc.createTextNode(request.getDecisionVariables()[i]));
				decisionValues.appendChild(newElement);
			}
		}

		// problem-name OK
		// problem-description OK
		// email ????
		// algorithm-mode OK
		// jar-path ????
		// variable-group ?????
		// desirable-time OK
		// max-time OK
		// variable-type OK
		// number-decision variables OK
		// decision-var-min OK
		// decision-var-max OK
		// gerar invalid-values OK
		// gerar decision-values OK

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\users\\Mario\\Desktop\\problem.xml"));
		transformer.transform(source, result);

		// Output to console for testing
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);

		return doc;

	}

	public static Document generateProblemResponseXml(List<String> availableAlgorithmsList)
			throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		// root element
		Element rootElement = doc.createElement("algorithms");
		doc.appendChild(rootElement);

		// algorithms element
		Element availableAlgorithms = doc.createElement("available-algorithms");
		rootElement.appendChild(availableAlgorithms);

		for (int i = 0; i != availableAlgorithmsList.size(); i++) {
			Element newElement = doc.createElement("algorithm" + i);
			Attr attrType = doc.createAttribute("name");
			attrType.setValue(availableAlgorithmsList.get(i));
			newElement.setAttributeNode(attrType);
			newElement.appendChild(doc.createTextNode(availableAlgorithmsList.get(i)));
			availableAlgorithms.appendChild(newElement);
		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\users\\Mario\\Desktop\\algorithms.xml"));
		transformer.transform(source, result);

		// Output to console for testing
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);

		return doc;
	}

	public static Document generateCriteriumRequestXml(String selectedAlgorithm)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		// root element
		Element rootElement = doc.createElement("algorithm-selection");
		doc.appendChild(rootElement);

		Element problemName = doc.createElement("algorithm");
		rootElement.appendChild(problemName);
		Attr attrType = doc.createAttribute("name");
		attrType.setValue(selectedAlgorithm);
		problemName.setAttributeNode(attrType);
		problemName.appendChild(doc.createTextNode(selectedAlgorithm));

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\users\\Mario\\Desktop\\selectedAlgorithm.xml"));
		transformer.transform(source, result);

		// Output to console for testing
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);

		return doc;
	}

	// public static Document generateCriteriumResponse(List<Criterium>
	// criteriumList) {
	// vai retornar lista de número de FP e FN + os respetivos valores para os pesos
	// gerados dessa melhor configuracao
	// for(int i = 0; i != criteriumList.size(); i++) {
	//
	// }
	// }

	// XML:
	//
	// <criterium>
	// <criteria name="FP">1</criteria>
	// <criteria name="FN">1</criteria>
	// </criterium>
	// <variables>
	// <weight number="1">0.22</weight>
	// <weight number="2">0.33</weight>
	// (...)
	// </variables>

}
