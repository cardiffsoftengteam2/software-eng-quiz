package AdminLogin;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

public class AdminFunctionsController {
	@FXML
	private AnchorPane adminFunctions;

	// Event Listener on Button.onAction
	@FXML
	public void viewStats(ActionEvent event) {
		/**
		 * Use this to fire the stats class - I think.
		 * Not sure if this is calling the correct method
		 * though.
		 */
		// Statistics stats = new Statistics();
		// stats.start();
	}
	// Event Listener on Button.onAction
	@FXML
	public void createQuestion(ActionEvent event) {
		/**
		 * This should call the createQuestion method.
		 * Again not sure it's calling the right thing.
		 */
		 // FXMLMainViewController create = new FXMLMainViewController();
		 // create.changeCreateSceneButtonPushed();

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
