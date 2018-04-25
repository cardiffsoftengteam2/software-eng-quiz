package Home;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

import Statistics.Statistics;
import Statistics.StatisticsProcessor;
import TakeQuiz.TakeQuiz;
import AdminLogin.AdminLogin;

public class HomeController {
	@FXML
	private AnchorPane Home;
	@FXML
	private ChoiceBox<Statistics> SchoolYear;
	@FXML
	private Label message;
	@FXML
	private Button startBtn;
	
	
	private StatisticsProcessor StatsList = new StatisticsProcessor();
    private String statsFile = "stats.csv";

	ObservableList<Statistics> stats = getStats(statsFile);

	
	@FXML
    public void initialize() {
		startBtn.setDisable(true);
	    SchoolYear.setItems(stats);
	    SchoolYear.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			 if(newSelection != null) {
				 startBtn.setDisable(false);
	    		} else {
	    			startBtn.setDisable(true);
	    		}
			 }
			 );
	}

	// Event Listener on Button.onAction
	@FXML
	public void startQuiz(ActionEvent event) throws Exception {
		Stage stage = (Stage) Home.getScene().getWindow();
		TakeQuiz takeQuiz = new TakeQuiz();
		takeQuiz.init(SchoolYear.getSelectionModel().getSelectedIndex(), stage);
	}
	
	// Event Listener on Button.onAction
		@FXML
		public void toAdmin(ActionEvent event) throws Exception {
			Stage stage = (Stage) Home.getScene().getWindow();
			AdminLogin AdminLogin = new AdminLogin();
			AdminLogin.start(stage);
		}
	
	   public ObservableList<Statistics> getStats(String statsFile) {

	        // New convertCSV object to convert data.
	        List<Statistics> stats = StatsList.processStats(statsFile);
	        List<Statistics> showStats = new ArrayList<Statistics>();
	        for(Statistics stat : stats) {
	        		if(stat.getShowHide() == true) {
	        			showStats.add(stat);
	        		}
	        }
	        // Store java objects in an Array List.
	        ObservableList<Statistics> allStats = FXCollections.observableArrayList(showStats);

	        return allStats;
	    }
}
