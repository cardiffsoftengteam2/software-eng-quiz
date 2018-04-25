package settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuestionReader {

	private String line;
    private List<Questions> questions = new ArrayList<Questions>();
    private String fileName;

    public List<Questions> getQuestions(String fName) {
        fileName = fName;

        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(fName));
            fileIn.readLine(); // this will read the first line
            String line=null;
            while((line = fileIn.readLine()) != null) {
                // Split on Comma
                String[] statsArray = line.split(",");

                // create new weather object
                Questions statsOb = new Questions();

                statsOb.setCategoryName(statsArray[0]);
                statsOb.setQuestionInput(statsArray[1]);
                statsOb.setLetterLabel(statsArray[2]);
                statsOb.setLetterALabel(statsArray[3]);
                statsOb.setLetterBLabel(statsArray[4]);
                statsOb.setLetterCLabel(statsArray[5]);
                statsOb.setLetterDLabel(statsArray[6]);
                
                statsOb.setLetterALabelPic(Boolean.valueOf(statsArray[7]));
                statsOb.setLetterBLabelPic(Boolean.valueOf(statsArray[8]));
                statsOb.setLetterCLabelPic(Boolean.valueOf(statsArray[9]));
                statsOb.setLetterDLabelPic(Boolean.valueOf(statsArray[10]));

                questions.add(statsOb);
            }
        } catch (IOException e) {
            System.out.println("File NOT found");
            e.printStackTrace();
        }

        return questions;

    }

}
