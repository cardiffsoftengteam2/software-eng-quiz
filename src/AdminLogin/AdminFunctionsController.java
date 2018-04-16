package AdminLogin;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import settings.Main;
import Statistics.StatisticsUi;

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
	public void createQuestion(ActionEvent event) throws Exception {
		/**
		 * This should call the createQuestion method.
		 * Again not sure it's calling the right thing.
		 */
		 // FXMLMainViewController create = new FXMLMainViewController();
		 // create.changeCreateSceneButtonPushed();
		Stage stage = (Stage) adminFunctions.getScene().getWindow();
		Main ModifyCreate = new settings.Main();
		ModifyCreate.start(stage);
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void modifyQuestion(ActionEvent event) {
		/**
		 * Call the modifyQuestion method.
		 * Again not sure it's calling the right thing.
		 */

		 // FXMLMainViewController modify = new FXMLMainViewController();
		 // modify.changeModifySceneButtonPushed();
	}
}
