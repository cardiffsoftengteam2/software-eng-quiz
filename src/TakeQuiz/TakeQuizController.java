package TakeQuiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import Statistics.Statistics;
import Statistics.StatisticsProcessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import settings.QuestionReader;
import settings.Questions;

/**
 *
 * @author joshuadunn
 */

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class TakeQuizController {
	@FXML
	private Button endQuiz;
	@FXML
	private Button nextQuestion;
	@FXML
	private ToggleGroup answerGroup;
	@FXML
	private Label questionLabel1;
	@FXML
	private Label questionLabel;
	@FXML
	private RadioButton answer1Label;
	@FXML
	private RadioButton answer2Label;
	@FXML
	private RadioButton answer3Label;
	@FXML
	private RadioButton answer4Label;
	
	@FXML 
	public Label message;

	private int questionCount = 0;
    final String questionNumbers[] = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

	private static QuestionReader QuestionList = new QuestionReader();
	
    private static String questionsFile = "questions.csv";
    
    int sessionAnswered;
    int sessionCorrect;
    String questionCategory;

	private StatisticsProcessor StatsList = new StatisticsProcessor();
	 private String statsFile = "stats.csv";
	ObservableList<Statistics> stats = getStats(statsFile);
	
	//Delimiter used in CSV file
	  private static final String COMMA_DELIMITER = ",";
	  private static final String NEW_LINE_SEPARATOR = "\n";

      //CSV file header
private static final String FILE_HEADER = "correct,incorrect,schoolYear,schoolName,questionsAnswered, showHide";


public static ObservableList<Questions> observableQuestionsList = getQuestions(questionsFile);


Statistics statToUpdate = new Statistics();



@FXML
    private void handleNextQuestionClick(ActionEvent event) throws IOException {
    	int ans = statToUpdate.getNumberAnswered();
		ans++;
		statToUpdate.setNumberAnswered(ans);
		
		sessionAnswered++;
		
    		if(observableQuestionsList.get(questionCount).getLetterLabel().toUpperCase().equals("A")) {
    				if(answer1Label.isSelected() == true) {
    					message.setText("Correct!");
    		            message.setTextFill(Color.rgb(21, 117, 84));
    					sessionCorrect++;
    					int correct = statToUpdate.getCorrect();
    					correct++;
    					statToUpdate.setCorrect(correct);
    				} else {
    					message.setText("Incorrect!");
    		            message.setTextFill(Color.rgb(210, 39, 30));
    					int incorrect = statToUpdate.getIncorrect();
    					incorrect++;
    					statToUpdate.setIncorrect(incorrect);
    				}
    		} else if(observableQuestionsList.get(questionCount).getLetterLabel().toUpperCase().equals("B")) {
				if(answer2Label.isSelected() == true) {
					sessionCorrect++;
					message.setText("Correct!");
		            message.setTextFill(Color.rgb(21, 117, 84));
					
					int correct = statToUpdate.getCorrect();
					correct++;
					statToUpdate.setCorrect(correct);
				} else {
					message.setText("Incorrect!");
		            message.setTextFill(Color.rgb(210, 39, 30));
					int incorrect = statToUpdate.getIncorrect();
					incorrect++;
					statToUpdate.setIncorrect(incorrect);
				}
		} else if(observableQuestionsList.get(questionCount).getLetterLabel().toUpperCase().equals("C")) {
			if(answer3Label.isSelected() == true) {
				message.setText("Correct!");
	            message.setTextFill(Color.rgb(21, 117, 84));
				sessionCorrect++;
				int correct = statToUpdate.getCorrect();
				correct++;
				statToUpdate.setCorrect(correct);
			} else {
				message.setText("Incorrect!");
	            message.setTextFill(Color.rgb(210, 39, 30));
				int incorrect = statToUpdate.getIncorrect();
				incorrect++;
				statToUpdate.setIncorrect(incorrect);
			}
	} else if(observableQuestionsList.get(questionCount).getLetterLabel().toUpperCase().equals("D")) {
		if(answer4Label.isSelected() == true) {
			 message.setText("Correct!");
	            message.setTextFill(Color.rgb(21, 117, 84));
			sessionCorrect++;
			int correct = statToUpdate.getCorrect();
			correct++;
			statToUpdate.setCorrect(correct);
		} else {
			message.setText("Incorrect!");
            message.setTextFill(Color.rgb(210, 39, 30));
			int incorrect = statToUpdate.getIncorrect();
			incorrect++;
			statToUpdate.setIncorrect(incorrect);
		}
} else {
	int incorrect = statToUpdate.getIncorrect();
	incorrect++;
	statToUpdate.setIncorrect(incorrect);
}
        
    		Task<Void> timer = new Task<Void>() {
    		    @Override
    		    protected Void call() throws Exception {
    		       try {
    		            Thread.sleep(2000);
    		       } catch (InterruptedException e) {}
    		       return null;    
    		    }
    		};
    		
    		timer.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    			@Override
                public void handle(WorkerStateEvent event) {
    			try {
					finishedSleeping();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			}
    		});
    		new Thread(timer).start();
    		
    		
    }

    private void finishedSleeping() throws FileNotFoundException {
    	updateStats(statToUpdate);
		
		message.setText(null);
		
		questionCount++;

		
    
    if (questionCount < observableQuestionsList.size() && questionCount < 10) {
        questionLabel.setText("Question " + questionNumbers[questionCount]);
        questionLabel1.setText(observableQuestionsList.get(questionCount).getQuestionInput());
       
	        if(observableQuestionsList.get(questionCount).isLetterALabelPic() == true) {
	        	FileInputStream stream = new FileInputStream(observableQuestionsList.get(questionCount).getLetterALabel());
	        		Image image = new Image(stream, 150, 150, true, true);
	    		answer1Label.setGraphic(new ImageView(image));	
	         }else {
	        	 answer1Label.setGraphic(null);
	    		answer1Label.setText(observableQuestionsList.get(questionCount).getLetterALabel());
	    		}
	    		if(observableQuestionsList.get(questionCount).isLetterBLabelPic() == true) {
	    			FileInputStream stream = new FileInputStream(observableQuestionsList.get(questionCount).getLetterBLabel());
	        		Image image = new Image(stream, 150, 150, true, true);
	    		answer2Label.setGraphic(new ImageView(image));	
	    		}else {
	    			answer2Label.setGraphic(null);
	    		answer2Label.setText(observableQuestionsList.get(questionCount).getLetterBLabel());
	    		}
	    		if(observableQuestionsList.get(questionCount).isLetterCLabelPic() == true) {
	    			FileInputStream stream = new FileInputStream(observableQuestionsList.get(questionCount).getLetterCLabel());
	        		Image image = new Image(stream, 150, 150, true, true);
	    		answer3Label.setGraphic(new ImageView(image));	
	    		}else {
	    			answer3Label.setGraphic(null);
	    		answer3Label.setText(observableQuestionsList.get(questionCount).getLetterCLabel());
	    		}
	    		if(observableQuestionsList.get(questionCount).isLetterDLabelPic() == true) {
	    			FileInputStream stream = new FileInputStream(observableQuestionsList.get(questionCount).getLetterDLabel());
	        		Image image = new Image(stream, 150, 150, true, true);
	    		answer4Label.setGraphic(new ImageView(image));	
	    		}else {
	    			answer4Label.setGraphic(null);
	    		answer4Label.setText(observableQuestionsList.get(questionCount).getLetterDLabel());
	    		}
    } else {
        try {
			loadResultsScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

	@FXML
    private void handleCloseButtonAction(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void handleEndQuizClick(ActionEvent event) throws IOException {
    	Stage window = (Stage) endQuiz.getScene().getWindow();
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultsScreen.fxml"));
    	 Parent root;
 		
    	 try {
    		    root = loader.load();
    		} catch (IOException ioe) {
    		    System.out.print(ioe);
    		    return;
    		}

 		ResultsController resultsController = loader.<ResultsController>getController();
 		resultsController.init(sessionCorrect, sessionAnswered);
 		
 		window.setScene(new Scene(root));

    }
    
    private void loadResultsScreen() throws IOException {

    	Stage window = (Stage) endQuiz.getScene().getWindow();
   	 FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultsScreen.fxml"));
   	 Parent root;
		
   	 try {
   		    root = loader.load();
   		} catch (IOException ioe) {
   		    System.out.print(ioe);
   		    return;
   		}

		ResultsController resultsController = loader.<ResultsController>getController();
		resultsController.init(sessionCorrect, sessionAnswered);
		
		window.setScene(new Scene(root));

    }

    public ObservableList<Questions> findCat(String categoryName) {
    		ObservableList<Questions> newQuestions = FXCollections.observableArrayList();
	    for(Questions question : observableQuestionsList) {
	        if(question.getCategoryName().equals(categoryName)) {
	            newQuestions.add(question);
	        }
	    }
	    return newQuestions;
	}
    
    public void initData(int schoolYear) {
    	
    	BufferedReader fileIn;
		try {
			fileIn = new BufferedReader(new FileReader("questionCat.txt"));
			String line=null;
			while((line = fileIn.readLine()) != null) {
			questionCategory = line;
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
    	
    		shuffleQs(observableQuestionsList);
    		
    		observableQuestionsList = findCat(questionCategory);
    		
    		
    		statToUpdate = setStats(schoolYear);
    		questionLabel1.setText(observableQuestionsList.get(0).getQuestionInput());
    		if(observableQuestionsList.get(0).isLetterALabelPic() == true) {
    			FileInputStream stream;
				try {
					stream = new FileInputStream(observableQuestionsList.get(0).getLetterALabel());
					Image image = new Image(stream, 150, 150, true, true);
		    		answer1Label.setGraphic(new ImageView(image));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        				

    		}else {
    		answer1Label.setText(observableQuestionsList.get(0).getLetterALabel());
    		}
    		if(observableQuestionsList.get(0).isLetterBLabelPic() == true) {
    			
    			FileInputStream stream;
				try {
					stream = new FileInputStream(observableQuestionsList.get(0).getLetterBLabel());
					Image image = new Image(stream, 150, 150, true, true);
		    		answer2Label.setGraphic(new ImageView(image));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    		
    		}else {
    		answer2Label.setText(observableQuestionsList.get(0).getLetterBLabel());
    		}
    		if(observableQuestionsList.get(0).isLetterCLabelPic() == true) {
    			
    			FileInputStream stream;
				try {
					stream = new FileInputStream(observableQuestionsList.get(0).getLetterCLabel());
					Image image = new Image(stream, 150, 150, true, true);
		    		answer3Label.setGraphic(new ImageView(image));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    		}else {
    		answer3Label.setText(observableQuestionsList.get(0).getLetterCLabel());
    		}
    		if(observableQuestionsList.get(0).isLetterDLabelPic() == true) {
   		
    			FileInputStream stream;
				try {
					stream = new FileInputStream(observableQuestionsList.get(0).getLetterDLabel());
					Image image = new Image(stream, 150, 150, true, true);
		    		answer4Label.setGraphic(new ImageView(image));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    		}else {
    		answer4Label.setText(observableQuestionsList.get(0).getLetterDLabel());
    		}
    }
    
    private void shuffleQs(ObservableList<Questions> list) {
    	Random rng = new Random();
        int n = list.size();
        while (n > 1)
        {
            n--;
            int k = rng.nextInt(n+1);
            Questions value = list.get(k);
            list.remove(k);
            list.add(n, value);
        }
		
	}

	public static ObservableList<Questions> getQuestions(String questionsFile) {

        // New convertCSV object to convert data.
        List<Questions> questions = QuestionList.getQuestions(questionsFile);
        // Store java objects in an Array List.
        ObservableList<Questions> allQs = FXCollections.observableArrayList(questions);

        return allQs;
    }
    
    public ObservableList<Statistics> getStats(String statsFile) {

        // New convertCSV object to convert data.
        List<Statistics> stats = StatsList.processStats(statsFile);
        // Store java objects in an Array List.
        ObservableList<Statistics> allStats = FXCollections.observableArrayList(stats);

        return allStats;
    }
    
    public Statistics setStats(int index) {
    		Statistics statToUpdate = stats.get(index);
			return statToUpdate;
    }
    
    public void updateStats(Statistics statToUpdate) {
    	
    	int index = stats.indexOf(statToUpdate);
 	stats.set(index, statToUpdate);
    	
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
}
