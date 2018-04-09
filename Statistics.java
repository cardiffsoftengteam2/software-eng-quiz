public class Statistics {

    private int correct;
    private int incorrect;
    private String schoolYear;

    public Weather() {
        this.correct = 0;
        this.incorrect = 0;
        this.schoolYear = "";
    }

    public Weather(int correct, int incorrect, String year) {

        this.correct = correct;
        this.incorrect = incorrect;
        this.schoolYear = year;
    }

}
