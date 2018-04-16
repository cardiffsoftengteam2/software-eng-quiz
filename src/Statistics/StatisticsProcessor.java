package Statistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StatisticsProcessor {

    private String line;
    private List<Statistics> stats = new ArrayList<Statistics>();
    private String fileName;

    public List<Statistics> processStats(String fName) {
        fileName = fName;

        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(fName));
            while((line = fileIn.readLine()) != null) {
                // Split on Comma
                String[] statsArray = line.split(",");

                // create new weather object
                Statistics statsOb = new Statistics();

                statsOb.setCorrect(Integer.parseInt(statsArray[0]));
                statsOb.setIncorrect(Integer.parseInt(statsArray[1]));
                statsOb.setSchoolYear(statsArray[2]);
                statsOb.setSchoolName(statsArray[3]);
                statsOb.setNumberAnswered(Integer.parseInt(statsArray[4]));

                stats.add(statsOb);
            }
        } catch (IOException e) {
            System.out.println("File NOT found");
            e.printStackTrace();
        }

        return stats;

    }

}
