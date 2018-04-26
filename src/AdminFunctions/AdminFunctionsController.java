package AdminFunctions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import settings.Main;
import Statistics.StatisticsUi;
import Home.Home;
import SetupQuiz.SetupQuiz;

public class AdminFunctionsController {
	@FXML
	private AnchorPane adminFunctions;

	// Event Listener on Button.onAction
	@FXML
	public void viewStats(ActionEvent event) throws Exception {
		Stage stage = (Stage) adminFunctions.getScene().getWindow();
		StatisticsUi Statistics = new Statistics.StatisticsUi();
		Statistics.start(stage);
	}
	// Event Listener on Button.onAction
		@FXML
		public void modifyQuestion(ActionEvent event) throws Exception {
			/**
			 * This should call the createQuestion method.
			 * Again not sure it's calling the right thing.
			 */
			 // FXMLMainViewController create = new FXMLMainViewController();
			 // create.changeCreateSceneButtonPushed();
			Stage window = (Stage) adminFunctions.getScene().getWindow();
			Parent createCategoryParent = FXMLLoader.load(getClass().getResource("/settings/SelectModifyingQ.fxml"));
			Scene createCategoryScene = new Scene (createCategoryParent);
			window .setScene(createCategoryScene);
			window.show();
			
		}
	
	// Event Listener on Button.onAction
	@FXML
	public void createQuestion(ActionEvent event) throws Exception {
		/**
		 * This should call the createQuestion method.
		 * Again not sure it's calling the right thing.
		 */
		 // FXMLMainViewController create = new FXMLMainViewController();
		 // create.changeCreateSceneButtonPushed();
		Stage window = (Stage) adminFunctions.getScene().getWindow();
		Parent createCategoryParent = FXMLLoader.load(getClass().getResource("/settings/CreateQuestions.fxml"));
		Scene createCategoryScene = new Scene (createCategoryParent);
		window .setScene(createCategoryScene);
		window.show();
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void toSetup(ActionEvent event) throws Exception {
		Stage stage = (Stage) adminFunctions.getScene().getWindow();
		SetupQuiz SetupQuiz = new SetupQuiz();
		SetupQuiz.start(stage);
	}
	
	// Event Listener on Button.onAction
			@FXML
			public void backToQuiz(ActionEvent event) throws Exception {
				Stage stage = (Stage) adminFunctions.getScene().getWindow();
				Home Home = new Home();
				Home.start(stage);
			}
}
