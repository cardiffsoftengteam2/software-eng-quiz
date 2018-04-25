package TakeQuiz;

import AdminLogin.AdminLogin;
import Home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ResultsController {
	@FXML
	private BorderPane resultsPane;
	@FXML
	private Label resultString;

	public void init(int correct, int answered) {
		resultString.setText("Score:\n" + Integer.toString(correct) + "/" + Integer.toString(answered));
	}
	
	@FXML
	public void goHome(ActionEvent event) throws Exception {
		Stage stage = (Stage) resultsPane.getScene().getWindow();
		Home Home = new Home();
		Home.start(stage);
	}
	
	
}
