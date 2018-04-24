package pt.iscte.es2.decisionsoft.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmSelecter {
	
	private static  List<String> pickedAlgorithms;
	
	public static void pickAlgorithms(String typeOfInput){
		
		pickedAlgorithms = new ArrayList<String>();
		
		if(typeOfInput.equals("int")) {
			pickedAlgorithms.add("GWASFGA");
			pickedAlgorithms.add("IBEA");
			pickedAlgorithms.add("MOCell");
			pickedAlgorithms.add("MOMBI2");
			pickedAlgorithms.add("NSGA-II");
			pickedAlgorithms.add("ssNSGA-II");
			pickedAlgorithms.add("NSGA-III");
			pickedAlgorithms.add("PAES");
			pickedAlgorithms.add("PESA-2");
			pickedAlgorithms.add("RandomSearch");
			pickedAlgorithms.add("SMSEMOA");
			pickedAlgorithms.add("SPEA2");
			pickedAlgorithms.add("WASFGA");
			
		}else if(typeOfInput.equals("double")) {
			pickedAlgorithms.add("AbYSS");
			pickedAlgorithms.add("CellDE45");
			pickedAlgorithms.add("DMOPSO");
			pickedAlgorithms.add("GDE3");
			pickedAlgorithms.add("MOEA/D");
			pickedAlgorithms.add("MOEA/D-DRA");
			pickedAlgorithms.add("OMOPSO");
			pickedAlgorithms.add("SMPSO");
			
			pickedAlgorithms.add("GWASFGA");
			pickedAlgorithms.add("IBEA");
			pickedAlgorithms.add("MOCell");
			pickedAlgorithms.add("MOMBI2");
			pickedAlgorithms.add("NSGA-II");
			pickedAlgorithms.add("ssNSGA-II");
			pickedAlgorithms.add("NSGA-III");
			pickedAlgorithms.add("PAES");
			pickedAlgorithms.add("PESA-2");
			pickedAlgorithms.add("RandomSearch");
			pickedAlgorithms.add("SMSEMOA");
			pickedAlgorithms.add("SPEA2");
			pickedAlgorithms.add("WASFGA");
			
		}else {
			pickedAlgorithms.add("MOCHC45");
		}
		
	}
	
	public static List<String> getSelectedAlgorithms(){
		return pickedAlgorithms;
	}

}
