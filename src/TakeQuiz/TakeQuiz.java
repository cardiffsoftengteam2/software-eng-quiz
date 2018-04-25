package TakeQuiz;

import java.util.List;

import Statistics.Statistics;
import Statistics.StatisticsProcessor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author joshuadunn
 */
public class TakeQuiz {
	
	

    public Stage init(int SchoolYear, Stage stage2) throws Exception {


    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TakeQuiz.fxml"));
		Stage stage = stage2;
		stage.setScene(new Scene(
				(Pane) loader.load()
				));
		TakeQuizController takeQuizController = loader.<TakeQuizController>getController();
		takeQuizController.initData(SchoolYear);
		
		stage.show();
		
		return stage;
    }


  

}
