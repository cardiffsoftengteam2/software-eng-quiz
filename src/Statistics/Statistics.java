package Statistics;

public class Statistics {

    private int correct;
    private int incorrect;
    private String schoolYear;
    private String schoolName;
    private int questionsAnswered;
    private boolean showHide;

    public Statistics() {
        this.correct = 0;
        this.incorrect = 0;
        this.schoolYear = "";
        this.schoolName = "";
        this.questionsAnswered = 0;
        this.showHide = true;
    }

    public Statistics(int correct, int incorrect, String year, String sName, int answered) {

        this.correct = correct;
        this.incorrect = incorrect;
        this.schoolYear = year;
        this.schoolName = sName;
        this.questionsAnswered = answered;
    }

    // GETTERS

    public boolean getShowHide() {
    		return showHide;
    }
    
    public void setShowHide(boolean showHide) {
    	  this.showHide = showHide;
    }
    
    
    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getNumberAnswered() {
        return questionsAnswered;
    }

    // SETTERS

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public void setSchoolYear(String year) {
        this.schoolYear = year;
    }

    public void setSchoolName(String name) {
        this.schoolName = name;
    }

    public void setNumberAnswered(int answered) {
        this.questionsAnswered = answered;
    }

    @Override
 public String toString() {
  
 return schoolName + " - " + schoolYear;
    }
    
}
