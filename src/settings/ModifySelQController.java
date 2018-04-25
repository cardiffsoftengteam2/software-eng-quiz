package settings;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import AdminFunctions.AdminFunctions;
import Home.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;

public class ModifySelQController implements Initializable {
	
	BorderPane rootLayout;
	
	@FXML private Button HomePgButton;
	@FXML private Button deleteQuestionButton;
	
	//Configure Table
	@FXML private TableView<Questions> tableView;
	@FXML private TableColumn<Questions, String> categoryColumn;
	@FXML private TableColumn<Questions, String> questionColumn;
	@FXML private TableColumn<Questions, String> letterLabelColumn;
	@FXML private TableColumn<Questions, String> letterALabelColumn;
	@FXML private TableColumn<Questions, String> letterBLabelColumn;
	@FXML private TableColumn<Questions, String> letterCLabelColumn;
	@FXML private TableColumn<Questions, String> letterDLabelColumn;
	
	public ObservableList<Questions> observableQuestionsList = FXCollections.observableArrayList();

	
	 int selectedRowIndex;
		
	
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
	
						

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		deleteQuestionButton.setDisable(true);
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        		if(newSelection != null) {
        			deleteQuestionButton.setDisable(false);
        			 selectedRowIndex = tableView.getSelectionModel().getSelectedIndex();
        				
        		} else {
        			deleteQuestionButton.setDisable(true);
        		}
        });
		observableQuestionsList = CreateQuestionsController.getMyList();
		tableView.setItems(observableQuestionsList);
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setPlaceholder(new Label("Your Table is Empty"));
		
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

	
//Return to Homepage Button		 
	public void changeHomeSceneButtonPushed(ActionEvent event) throws IOException {	
		Parent MainViewParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene MainViewScene = new Scene (MainViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();	
		window.setScene(MainViewScene);
		window.show();
		
	}

	 /***
	  * Method to edit Data Cells
	  *
	  */
	
	@FXML
	public void saveQuestionCat(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setCategoryName(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	
	@FXML
	public void saveQuestionInput(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setQuestionInput(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	// Event Listener on TableColumn[#letterLabelColumn].onEditCommit
	@FXML
	public void saveQuestionAns(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setLetterLabel(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	// Event Listener on TableColumn[#letterALabelColumn].onEditCommit
	@FXML
	public void saveQuestionA(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setLetterALabel(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	// Event Listener on TableColumn[#letterBLabelColumn].onEditCommit
	@FXML
	public void saveQuestionB(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setLetterBLabel(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	// Event Listener on TableColumn[#letterCLabelColumn].onEditCommit
	@FXML
	public void saveQuestionC(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setLetterCLabel(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	// Event Listener on TableColumn[#letterDLabelColumn].onEditCommit
	@FXML
	public void saveQuestionD(CellEditEvent<?,?> event) {
		observableQuestionsList.get(selectedRowIndex).setLetterDLabel(event.getNewValue().toString());
		QuestionWriter.write(observableQuestionsList);
	}
	
/**
 * DELETE
 */
	
	public void deleteButtonPushed() {
		
		
		
       
       observableQuestionsList.remove(selectedRowIndex);
       QuestionWriter.write(observableQuestionsList);
       
        
        
    }
	
    }
