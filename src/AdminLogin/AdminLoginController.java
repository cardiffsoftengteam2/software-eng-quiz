package AdminLogin;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

import Home.Home;
import AdminFunctions.AdminFunctions;

public class AdminLoginController {


	
	@FXML private AnchorPane mainLogin;
	
	@FXML 
	public PasswordField pw;
	
	@FXML 
	public Label message;
	
	// Event Listener on Button.onAction
	@FXML
	public void SubmitPassword(ActionEvent event) throws Exception {
		if (!pw.getText().equals("coMSCfun")) {
            message.setText("Your password is incorrect!");
            message.setTextFill(Color.rgb(210, 39, 30));
        } else {
            message.setText("Your password has been confirmed");
            message.setTextFill(Color.rgb(21, 117, 84));
            Stage stage = (Stage) mainLogin.getScene().getWindow();
			AdminFunctions AdminFunctions = new AdminFunctions();
			AdminFunctions.start(stage);

        }
        pw.clear();
	}
	
	// Event Listener on Button.onAction
		@FXML
		public void backToQuiz(ActionEvent event) throws Exception {
			Stage stage = (Stage) mainLogin.getScene().getWindow();
			Home Home = new Home();
			Home.start(stage);
		}
		
}
