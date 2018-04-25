package settings;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;

import java.util.logging.Level;
import java.util.logging.Logger;

import AdminFunctions.AdminFunctions;
import AdminLogin.AdminLogin;
import Home.Home;
import Statistics.Statistics;
import Statistics.StatisticsProcessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.FileChooser;


public class CreateQuestionsController implements Initializable {
	
	
	
	final FileChooser fileChooser = new FileChooser();
	private File file;
	private final Desktop desktop = Desktop.getDesktop();
	
	private static QuestionReader QuestionList = new QuestionReader();
	


	
	//Buttons
	
	@FXML private Button addButton;
	@FXML private Button HomePgButton;
	@FXML private Button SaveButton;
	@FXML private Button openButton;
	
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
	
	
private boolean letterALabelPic = false;
private boolean letterBLabelPic = false;
private boolean letterCLabelPic = false;
private boolean letterDLabelPic = false;


private static String questionsFile = "questions.csv";

public static ObservableList<Questions> observableQuestionsList = getQuestions(questionsFile);


@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO Auto-generated method stub
	
	tableView.getItems().addAll(observableQuestionsList);
	
	
	categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	questionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	letterLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	letterALabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	letterBLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	letterCLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	letterDLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		
	categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());
	questionColumn.setCellValueFactory(cellData -> cellData.getValue().questionInputProperty());
	letterLabelColumn.setCellValueFactory(cellData -> cellData.getValue().letterLabelProperty());
	letterALabelColumn.setCellValueFactory(cellData -> cellData.getValue().letterALabelProperty());
	letterBLabelColumn.setCellValueFactory(cellData -> cellData.getValue().letterBLabelProperty());
	letterCLabelColumn.setCellValueFactory(cellData -> cellData.getValue().letterCLabelProperty());
	letterDLabelColumn.setCellValueFactory(cellData -> cellData.getValue().letterDLabelProperty());

}



public void addQuestionButtonPushed (ActionEvent event) {

		Questions question = new Questions();
		question.setCategoryName(categoryInputTextField.getText());
		question.setQuestionInput(questionInputTextField.getText());
		question.setLetterLabel(inputLabelTextField.getText());
		question.setLetterALabel(letterALabelTextField.getText());
		question.setLetterBLabel(letterBLabelTextField.getText());
		question.setLetterCLabel(letterCLabelTextField.getText());
		question.setLetterDLabel(letterDLabelTextField.getText());
		
		question.setLetterALabelPic(letterALabelPic);
		question.setLetterBLabelPic(letterBLabelPic);
		question.setLetterCLabelPic(letterCLabelPic);
		question.setLetterDLabelPic(letterDLabelPic);
		
		observableQuestionsList.add(question);
		tableView.getItems().add(question);
		
		QuestionWriter.write(observableQuestionsList);
		
		categoryInputTextField.clear();
		questionInputTextField.clear();
		inputLabelTextField.clear();
		letterALabelTextField.clear();
		letterBLabelTextField.clear();
		letterCLabelTextField.clear();
		letterDLabelTextField.clear();
		
		
}

//CALLS OBSERVABLE LIST TO MODIFY QUESTIONS PAGE 

public void start(Stage stage) throws Exception{
	ObservableList<Questions> setMyList = (observableQuestionsList);
	URL location = getClass().getResource("SelectModifyingQ.fxml");
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(location);
	loader.setBuilderFactory(new JavaFXBuilderFactory());
	Parent root = FXMLLoader.load(location);
	Scene scene = new Scene (root);
	stage.setScene(scene);
	stage.show();
	
}

//Event Listener on Button.onAction
		@FXML
		public void toAdmin(ActionEvent event) throws Exception {
			Stage stage = (Stage) HomePgButton.getScene().getWindow();
			AdminFunctions AdminFunctions = new AdminFunctions();
			AdminFunctions.start(stage);
		}

		// Event Listener on Button.onAction
					@FXML
					public void backToQuiz(ActionEvent event) throws Exception {
						Stage stage = (Stage) HomePgButton.getScene().getWindow();
						Home Home = new Home();
						Home.start(stage);
					}
		
public static ObservableList getMyList() {
	return observableQuestionsList;
}

public static void setMyList(ObservableList myList) {
	CreateQuestionsController.observableQuestionsList = myList;
}



// BUTTON METHODS TO OPEN FILES 
public void openButtonPushedA () {
	//Single file selection
	configureFileChooser(fileChooser);
	List<File> list = 
			fileChooser.showOpenMultipleDialog(new Stage());
	if (list!= null) {
		for (File file : list){
			
			String fileName = file.toString();
			letterALabelTextField.setText(fileName);
			letterALabelPic = true;
			
			}
		}
}

public void openButtonPushedB () {
	//Single file selection
	configureFileChooser(fileChooser);
	List<File> list = 
			fileChooser.showOpenMultipleDialog(new Stage());
	if (list!= null) {
		for (File file : list){
			String fileName = file.toString();
			letterBLabelTextField.setText(fileName);
			letterBLabelPic = true;
			
			}
		}
}

public void openButtonPushedC () {
	//Single file selection
	configureFileChooser(fileChooser);
	List<File> list = 
			fileChooser.showOpenMultipleDialog(new Stage());
	if (list!= null) {
		for (File file : list){
			String fileName = file.toString();
			letterCLabelTextField.setText(fileName);
			letterCLabelPic = true;
			
			}
		}
}

public void openButtonPushedD () {
	//Single file selection
	configureFileChooser(fileChooser);
	List<File> list = 
			fileChooser.showOpenMultipleDialog(new Stage());
	if (list!= null) {
		for (File file : list){
			String fileName = file.toString();
			letterDLabelTextField.setText(fileName);
			letterDLabelPic = true;
			}
		}
}

	private static void configureFileChooser(
 	        final FileChooser fileChooser) {      
 	            fileChooser.setTitle("View Pictures");
 	            fileChooser.setInitialDirectory(
 	                new File(System.getProperty("user.home"))
 	            );                 
 	            fileChooser.getExtensionFilters().addAll(
 	                new FileChooser.ExtensionFilter("All Images", "*.*"),
 	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
 	                new FileChooser.ExtensionFilter("PNG", "*.png")
 	            );
 	    }
	

public void doneButtonPushed(ActionEvent event) throws IOException {
		
	Parent SummaryViewParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
	Scene SummaryViewScene = new Scene (SummaryViewParent);	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(SummaryViewScene);
	window.show();	

}

public static ObservableList<Questions> getQuestions(String questionsFile) {

    // New convertCSV object to convert data.
    List<Questions> questions = QuestionList.getQuestions(questionsFile);
    // Store java objects in an Array List.
    ObservableList<Questions> allQs = FXCollections.observableArrayList(questions);

    return allQs;
}

}


