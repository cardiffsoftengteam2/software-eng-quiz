package settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class FXMLMainViewController implements Initializable {
	
	@FXML private Button createButton;
	@FXML private Button modifyButton;
	
	
public void changeCreateSceneButtonPushed(ActionEvent event) throws IOException {
		
		Parent createQuestionsParent = FXMLLoader.load(getClass().getResource("CreateQuestions.fxml"));
		Scene createQuestionsScene = new Scene (createQuestionsParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(createQuestionsScene);
		window.show();
	}

public void changeModifySceneButtonPushed(ActionEvent event) throws IOException {
	
	Parent createCategoryParent = FXMLLoader.load(getClass().getResource("SelectModifyingQ.fxml"));
	Scene createCategoryScene = new Scene (createCategoryParent);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	window .setScene(createCategoryScene);
	window.show();
}

@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO Auto-generated method stub
	
}
}
