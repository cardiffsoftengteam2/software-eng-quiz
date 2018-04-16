/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author joshuadunn
 */
public class QuizController implements Initializable {

    @FXML
    private BorderPane rootPane;
    @FXML
    private Stage primaryStage;
    @FXML
    private Button nextQuestion;
    @FXML
    private Label questionLabel;
    private int questionCount = 0;
    final String questionNumbers[] = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};


    @FXML
    private void handleNextQuestionClick(ActionEvent event) throws IOException {
        questionCount++;
        if (questionCount < questionNumbers.length) {
            questionLabel.setText("Question " + questionNumbers[questionCount]);
        } else {
            this.loadResultsScreen(event);
        }
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void loadResultsScreen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Resources/ResultsScreen.fxml"));

        Scene resultsScene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(resultsScene);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
