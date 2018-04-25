package settings;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Questions {
	
	boolean letterALabelPic;
	boolean letterBLabelPic;
	boolean letterCLabelPic;
	boolean letterDLabelPic;
	
	
	
	public boolean isLetterALabelPic() {
		return letterALabelPic;
	}
	public void setLetterALabelPic(boolean letterALabelPic) {
		this.letterALabelPic = letterALabelPic;
	}
	public boolean isLetterBLabelPic() {
		return letterBLabelPic;
	}
	public void setLetterBLabelPic(boolean letterBLabelPic) {
		this.letterBLabelPic = letterBLabelPic;
	}
	public boolean isLetterCLabelPic() {
		return letterCLabelPic;
	}
	public void setLetterCLabelPic(boolean letterCLabelPic) {
		this.letterCLabelPic = letterCLabelPic;
	}
	public boolean isLetterDLabelPic() {
		return letterDLabelPic;
	}
	public void setLetterDLabelPic(boolean letterDLabelPic) {
		this.letterDLabelPic = letterDLabelPic;
	}

	private StringProperty categoryName = new SimpleStringProperty(this, "categoryName", "");
	
	public String getCategoryName() {
		return categoryName.get();
	}
	public StringProperty categoryNameProperty() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName.set(categoryName);
	}
	
	private StringProperty questionInput = new SimpleStringProperty(this, "questionInput", "");
	public String getQuestionInput() {
		return questionInput.get();
	}
	public StringProperty questionInputProperty() {
		return questionInput;
	}
	public void setQuestionInput(String questionInput) {
		this.questionInput.set(questionInput);
	}
	private StringProperty letterLabel = new SimpleStringProperty(this, "letterLabel", "");
	public String getLetterLabel() {
		return letterLabel.get();
	}
	public StringProperty letterLabelProperty() {
		return letterLabel;
	}
	public void setLetterLabel(String letterLabel) {
		this.letterLabel.set(letterLabel);
	}
	private StringProperty letterALabel = new SimpleStringProperty(this, "letterALabel", "");
	public String getLetterALabel() {
		return letterALabel.get();
	}
	public StringProperty letterALabelProperty() {
		return letterALabel;
	}
	public void setLetterALabel(String letterALabel) {
		this.letterALabel.set(letterALabel);
	}
	private StringProperty letterBLabel = new SimpleStringProperty(this, "letterBLabel", "");
	public String getLetterBLabel() {
		return letterBLabel.get();
	}
	public StringProperty letterBLabelProperty() {
		return letterBLabel;
	}
	public void setLetterBLabel(String letterBLabel) {
		this.letterBLabel.set(letterBLabel);
	}
	private StringProperty letterCLabel = new SimpleStringProperty(this, "letterCLabel", "");
	public String getLetterCLabel() {
		return letterCLabel.get();
	}
	public StringProperty letterCLabelProperty() {
		return letterCLabel;
	}
	public void setLetterCLabel(String letterCLabel) {
		this.letterCLabel.set(letterCLabel);
	}
	private StringProperty letterDLabel = new SimpleStringProperty(this, "letterDLabel", "");
	public String getLetterDLabel() {
		return letterDLabel.get();
	}
	public StringProperty letterDLabelProperty() {
		return letterDLabel;
	}
	public void setLetterDLabel(String letterDLabel) {
		this.letterDLabel.set(letterDLabel);
	}
	
	//ObservableList<Questions> observableQuestionsList = FXCollections.observableArrayList();
	
	//for console printing purposes
    public String toString() {
    	return getCategoryName();
		
	}
}