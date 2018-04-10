package AdminLogin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AdminLoginController {


	
	@FXML private AnchorPane mainLogin;
	
	@FXML 
	public PasswordField pw;
	
	@FXML 
	public Label message;
	
	// Event Listener on Button.onAction
	@FXML
	public void SubmitPassword(ActionEvent event) throws IOException {
		if (!pw.getText().equals("coMSCfun")) {
            message.setText("Your password is incorrect!");
            message.setTextFill(Color.rgb(210, 39, 30));
        } else {
            message.setText("Your password has been confirmed");
            message.setTextFill(Color.rgb(21, 117, 84));
            Stage stage = (Stage) mainLogin.getScene().getWindow();
            AnchorPane root;
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminFunctions.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);

        }
        pw.clear();
	}
}
