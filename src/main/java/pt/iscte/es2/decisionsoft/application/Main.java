package pt.iscte.es2.decisionsoft.application;
	
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pt.iscte.es2.decisionsoft.domain.Criteria;
import pt.iscte.es2.decisionsoft.domain.ExperimentContext;
import pt.iscte.es2.decisionsoft.domain.ProblemInfo;
import pt.iscte.es2.decisionsoft.domain.Variable;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static ProblemInfo problemInfo;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			problemInfo = new ProblemInfo();
			primaryStage.setTitle("Decision-making software");
			URL url = getClass().getClassLoader().getResource("MainMenu.fxml");
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,600,400);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
