package settings;

import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.ObservableList;


public class QuestionWriter {
	

private static String questionsFile = "questions.csv";
//Delimiter used in CSV file
private static final String COMMA_DELIMITER = ",";
private static final String NEW_LINE_SEPARATOR = "\n";

//CSV file header
private static final String FILE_HEADER = "category,question,letterLabel,letterALabel,letterBLabel, letterCLabel, letterDLabel, letterALabelPic,letterBLabelPic, letterCLabelPic, letterDLabelPic";

	
	public static void write(ObservableList<Questions> observableQuestionsList) {

	FileWriter fileWriter = null;
	try {
		fileWriter = new FileWriter(questionsFile);
		// set up headers
		fileWriter.append(FILE_HEADER.toString());
		//new line after headers
		fileWriter.append(NEW_LINE_SEPARATOR);
		//Write the object list to the CSV file
		for (Questions q : observableQuestionsList) {
		fileWriter.append(String.valueOf(q.getCategoryName()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getQuestionInput()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getLetterLabel()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getLetterALabel()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getLetterBLabel()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getLetterCLabel()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.getLetterDLabel()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.isLetterALabelPic()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.isLetterBLabelPic()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.isLetterCLabelPic()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(q.isLetterDLabelPic()));
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
