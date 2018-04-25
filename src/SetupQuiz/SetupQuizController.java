package SetupQuiz;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import settings.CreateQuestionsController;
import settings.Questions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import AdminFunctions.AdminFunctions;
import Home.Home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Statistics.Statistics;
import Statistics.StatisticsProcessor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SetupQuizController {
	@FXML
	private AnchorPane setupScreen;
	@FXML
	private ListView <String> questionCat;
	@FXML
	private TableView <Statistics> SchoolYearList;
	@FXML
	private TableColumn <Statistics, String> school;
	@FXML
	private TableColumn <Statistics, String> year;
	@FXML
	private TableColumn <Statistics, String> shown;
	@FXML
	private TextField SchoolYear;
	@FXML
	private TextField School;
	@FXML 
	private Button toggleButton;
	@FXML 
	private Button toggleButton1;

	
	private StatisticsProcessor StatsList = new StatisticsProcessor();
    private String statsFile = "stats.csv";
  

	ObservableList<Statistics> stats = getStats(statsFile);
	ObservableList<Questions> observableQuestionsList = CreateQuestionsController.getMyList();
	
	
	//Delimiter used in CSV file
	  private static final String COMMA_DELIMITER = ",";
	  private static final String NEW_LINE_SEPARATOR = "\n";

        //CSV file header
private static final String FILE_HEADER = "correct,incorrect,schoolYear,schoolName,questionsAnswered, showHide";

	
	@FXML
    public void initialize() {
		
	
        
	    
		Set<String> questionsSet = new HashSet<String>();
		 for (Questions p : observableQuestionsList) {
		     questionsSet.add(p.getCategoryName());
		 }

		 // if yo want a list:
		 ObservableList<String> allCategories = FXCollections.observableArrayList(questionsSet);
		 
		 questionCat.setItems(allCategories);
		 
		 questionCat.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			 if(newSelection != null) {
	    			toggleButton1.setDisable(false);
	    		} else {
	    			toggleButton1.setDisable(true);
	    		}
			 
			 FileWriter fileWriterCat = null;
			 try {
				fileWriterCat = new FileWriter("questionCat.txt");
				fileWriterCat.append(newSelection);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
				fileWriterCat.flush();
				fileWriterCat.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
				}
			 
        });
		
		school.setCellValueFactory(new PropertyValueFactory<Statistics, String>("schoolYear"));
		year.setCellValueFactory(new PropertyValueFactory<Statistics, String>("schoolName"));
		shown.setCellValueFactory(new PropertyValueFactory<Statistics, String>("showHide"));
	       
        SchoolYearList.setItems(stats);

	    
	    SchoolYearList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	    		if(newSelection != null) {
	    			toggleButton.setDisable(false);
	    		} else {
	    			toggleButton.setDisable(true);
	    		}
        });
	    		
	    
		BufferedReader fileIn;
		try {
			fileIn = new BufferedReader(new FileReader("questionCat.txt"));
			String line=null;
			while((line = fileIn.readLine()) != null) {
			questionCat.getSelectionModel().select(line);
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    }
	

	@FXML
	public void clearCats(ActionEvent event) {
		questionCat.getSelectionModel().clearSelection();
	}
	
	// Event Listener on Button.onAction
		@FXML
		public void toggleSelected(ActionEvent event) {
			if(stats.get(SchoolYearList.getSelectionModel().getSelectedIndex()).getShowHide() == true) {
				stats.get(SchoolYearList.getSelectionModel().getSelectedIndex()).setShowHide(false);
			} else {
				stats.get(SchoolYearList.getSelectionModel().getSelectedIndex()).setShowHide(true);
			}
			SchoolYearList.refresh();
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(statsFile);
				// set up headers
				fileWriter.append(FILE_HEADER.toString());
				//new line after headers
				fileWriter.append(NEW_LINE_SEPARATOR);
				//Write the object list to the CSV file
				for (Statistics school : stats) {
				fileWriter.append(String.valueOf(school.getCorrect()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(school.getIncorrect()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(school.getSchoolYear());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(school.getSchoolName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(school.getNumberAnswered()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(school.getShowHide()));
				fileWriter.append(NEW_LINE_SEPARATOR);
				            }

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
				fileWriter.flush();
				fileWriter.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
				}
		}
		
	
	
	// Event Listener on Button.onAction
	@FXML
	public void AddSchoolYear(ActionEvent event) {
		Statistics newSchoolYear = new Statistics();
		newSchoolYear.setSchoolName(School.getText().toUpperCase());
		newSchoolYear.setSchoolYear(SchoolYear.getText());
		stats.add(newSchoolYear);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(statsFile);
			// set up headers
			fileWriter.append(FILE_HEADER.toString());
			//new line after headers
			fileWriter.append(NEW_LINE_SEPARATOR);
			//Write the object list to the CSV file
			for (Statistics school : stats) {
			fileWriter.append(String.valueOf(school.getCorrect()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(school.getIncorrect()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(school.getSchoolYear());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(school.getSchoolName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(school.getNumberAnswered()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(school.getShowHide()));
			fileWriter.append(NEW_LINE_SEPARATOR);
			            }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			fileWriter.flush();
			fileWriter.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
			}
		
	}
	
	   public ObservableList<Statistics> getStats(String statsFile) {

	        // New convertCSV object to convert data.
	        List<Statistics> stats = StatsList.processStats(statsFile);
	        // Store java objects in an Array List.
	        ObservableList<Statistics> allStats = FXCollections.observableArrayList(stats);

	        return allStats;
	    }
	   
	// Event Listener on Button.onAction
				@FXML
				public void backToQuiz(ActionEvent event) throws Exception {
					Stage stage = (Stage) setupScreen.getScene().getWindow();
					Home Home = new Home();
					Home.start(stage);
				}
				
				// Event Listener on Button.onAction
				@FXML
				public void backToAdmin(ActionEvent event) throws Exception {
					Stage stage = (Stage) setupScreen.getScene().getWindow();
					AdminFunctions AdminFunctions = new AdminFunctions();
					AdminFunctions.start(stage);
				}
}
