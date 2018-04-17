package settings;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

	
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		   
		
		System.out.print(observableQuestionsList); 
	
		tableView.setItems(CreateQuestionsController.getMyList());
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
	
	public void categoryColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setCategoryName(cellEditEvent.getNewValue());
    }
	
	public void questionColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setQuestionInput(cellEditEvent.getNewValue());
    }
	
	public void letterLabelColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setLetterLabel(cellEditEvent.getNewValue());
    }
	
	public void letterALabelColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setLetterALabel(cellEditEvent.getNewValue());
    }
	
	public void letterBLabelColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setLetterBLabel(cellEditEvent.getNewValue());
    }
	
	public void letterLabelCColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setLetterCLabel(cellEditEvent.getNewValue());
    }
	
	public void letterDLabelColumn_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<Questions, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Questions, String>) e;
        Questions question = cellEditEvent.getRowValue();
        question.setLetterDLabel(cellEditEvent.getNewValue());
    }
	
/**
 * DELETE
 */
	
	public void deleteButtonPushed() {
		ObservableList<Questions> selectedRows, allQuestions;
		allQuestions = tableView.getItems();
	
		//this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Questions questions: selectedRows)
        {
            allQuestions.remove(questions);
        }
    }
	
    }
