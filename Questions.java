package settings;

import javafx.beans.property.SimpleStringProperty;

public class Questions {
	
	private SimpleStringProperty categoryName, questionInput, letterLabel, letterALabel, letterBLabel, letterCLabel, letterDLabel;
	
	
	public Questions (String categoryName, String questionInput, String letterLabel, String letterALabel, String letterBLabel, String letterCLabel, String letterDLabel) {
		this.categoryName = new SimpleStringProperty(categoryName);
	
		this.questionInput = new SimpleStringProperty(questionInput);
	
		this.letterLabel = new SimpleStringProperty(letterLabel);
	
		this.letterALabel = new SimpleStringProperty(letterALabel);

		this.letterBLabel = new SimpleStringProperty(letterBLabel);
	
		this.letterCLabel = new SimpleStringProperty(letterCLabel);
	
		this.letterDLabel = new SimpleStringProperty(letterDLabel);
	}
	
	

	public String getCategoryName() {
        return categoryName.get();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = new SimpleStringProperty(categoryName);
    }
    
	public String getQuestionInput() {
        return questionInput.get();
    }

    public void setQuestionInput(String questionInput) {
        this.questionInput = new SimpleStringProperty(questionInput);
    }
	
    public String getLetterLabel() {
        return letterLabel.get();
    }

    public void setletterLabel(String letterLabel) {
        this.letterLabel = new SimpleStringProperty(letterLabel);
    }
	
    public String getLetterALabel() {
        return letterALabel.get();
    }

    public void setletterALabel(String letterALabel) {
        this.letterALabel = new SimpleStringProperty(letterALabel);
    }
    
    public String getLetterBLabel() {
        return letterBLabel.get();
    }

    public void setletterBLabel(String letterBLabel) {
        this.letterBLabel = new SimpleStringProperty(letterBLabel);
    }
    
    public String getLetterCLabel() {
        return letterCLabel.get();
    }

    public void setletterCLabel(String letterCLabel) {
        this.letterCLabel = new SimpleStringProperty(letterCLabel);
    }
    
    public String getLetterDLabel() {
        return letterDLabel.get();
    }

    public void setletterDLabel(String letterDLabel) {
        this.letterDLabel = new SimpleStringProperty(letterDLabel);
    }
	
   
}
