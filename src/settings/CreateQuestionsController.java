package settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreateQuestionsController implements Initializable {
	//Buttons
	//@FXML private Button nextQuestionButton;
	@FXML private Button addButton;
	@FXML private Button HomePgButton;
	@FXML private Button SaveButton;
	
	//Configure Table
	@FXML private TableView<Questions> tableView;
	@FXML private TableColumn<Questions, String> categoryColumn;
	@FXML private TableColumn<Questions, String> questionColumn;
	@FXML private TableColumn<Questions, String> letterLabelColumn;
	@FXML private TableColumn<Questions, String> letterALabelColumn;
	@FXML private TableColumn<Questions, String> letterBLabelColumn;
	@FXML private TableColumn<Questions, String> letterCLabelColumn;
	@FXML private TableColumn<Questions, String> letterDLabelColumn;
	
	//TextFields
	@FXML private TextField categoryInputTextField;
	@FXML private TextField questionInputTextField;
	@FXML private TextField inputLabelTextField;
	@FXML private TextField letterALabelTextField;
	@FXML private TextField letterBLabelTextField;
	@FXML private TextField letterCLabelTextField;
	@FXML private TextField letterDLabelTextField;
	
public void addQuestionButtonPushed () {
	
	Questions newQuestion = new Questions(categoryInputTextField.getText(),
										  questionInputTextField.getText(),
										  inputLabelTextField.getText(),
										  letterALabelTextField.getText(),
										  letterBLabelTextField.getText(),
										  letterCLabelTextField.getText(),
										  letterDLabelTextField.getText());
			
	
	//Get all the questions in the list and add new question
	tableView.getItems().add(newQuestion);
	categoryInputTextField.clear();
	questionInputTextField.clear();
	inputLabelTextField.clear();
	letterALabelTextField.clear();
	letterBLabelTextField.clear();
	letterCLabelTextField.clear();
	letterDLabelTextField.clear();
	
}



public void doneButtonPushed(ActionEvent event) throws IOException {
		
		Parent SummaryViewParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene SummaryViewScene = new Scene (SummaryViewParent);	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(SummaryViewScene);
		window.show();	
	}

@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO Auto-generated method stub
	
	categoryColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("categoryName"));
	questionColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("questionInput"));
	letterLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterLabel"));
	letterALabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterALabel"));
	letterBLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterBLabel"));
	letterCLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterCLabel"));
	letterDLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterDLabel"));
} 	
}



