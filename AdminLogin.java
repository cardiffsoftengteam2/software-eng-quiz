package AdminLogin;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminLogin extends Application {
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Admin");
	    primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
