package settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ModifySelQController implements Initializable {
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
	
	public void changeCategoryCellEvent(CellEditEvent edittedCell)
    {
        Questions categorySelected =  tableView.getSelectionModel().getSelectedItem();
        categorySelected.setCategoryName(edittedCell.getNewValue().toString());
    }
    
	
	public void changeQuestionCellEvent(CellEditEvent edittedCell)
    {
        Questions questionSelected =  tableView.getSelectionModel().getSelectedItem();
        questionSelected.setQuestionInput(edittedCell.getNewValue().toString());
    }
    
	
	public void changeLetterLabelCellEvent(CellEditEvent edittedCell)
    {
        Questions letterLabelSelected =  tableView.getSelectionModel().getSelectedItem();
        letterLabelSelected.setletterLabel(edittedCell.getNewValue().toString());
    }
	
	public void changeLetterALabelCellEvent(CellEditEvent edittedCell)
    {
        Questions letterALabelSelected =  tableView.getSelectionModel().getSelectedItem();
        letterALabelSelected.setletterALabel(edittedCell.getNewValue().toString());
    }
    
	public void changeLetterBLabelCellEvent(CellEditEvent edittedCell)
    {
        Questions letterBLabelSelected =  tableView.getSelectionModel().getSelectedItem();
        letterBLabelSelected.setletterBLabel(edittedCell.getNewValue().toString());
    }
    
	public void changeLetterCLabelCellEvent(CellEditEvent edittedCell)
    {
        Questions letterCLabelSelected =  tableView.getSelectionModel().getSelectedItem();
        letterCLabelSelected.setletterCLabel(edittedCell.getNewValue().toString());
    }
	
	
	public void changeLetterDLabelCellEvent(CellEditEvent edittedCell)
    {
        Questions letterDLabelSelected =  tableView.getSelectionModel().getSelectedItem();
        letterDLabelSelected.setletterDLabel(edittedCell.getNewValue().toString());
    }
	
	
	//Add New Question Button	
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
		
	
		
	
	/**
	 * Method return an ObservableList of Question Objects
	 */
	
	public ObservableList<Questions> getQuestions()
	{
		 ObservableList<Questions> questions = FXCollections.observableArrayList();
		 questions.add(new Questions("categoryName", "questionInput", "letterLabel", "letterALabel", "letterBLabel", "letterCLabel", "letterDLabel"));
		
		 return questions;
	}
	
/**
 * Initializes the controller class.
 */
	
		 @Override
			public void initialize(URL location, ResourceBundle resources) {
			//set up the columns in the table
			categoryColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("categoryName"));
			questionColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("questionInput"));
			letterLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterLabel"));
			letterALabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterALabel"));
			letterBLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterBLabel"));
			letterCLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterCLabel"));
			letterDLabelColumn.setCellValueFactory(new PropertyValueFactory<Questions, String>("letterDLabel"));
	 
			//Update the table to allow for the fields to be editable
	        
	        tableView.setEditable(true);
	        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        questionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        letterLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        letterALabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        letterBLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        letterCLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	        letterDLabelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		 
		 
		 }

}
