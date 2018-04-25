package Statistics;

import java.util.ArrayList;
import java.util.List;

import AdminFunctions.AdminFunctions;
import Home.Home;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class StatisticsUi extends Application {

    private StatisticsProcessor output = new StatisticsProcessor();
    private Stage window;
    private String statsFile = "stats.csv";
    private TableView<Statistics> statsTable;
    private Scene scene;


    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Quiz Statistics");

        // Set up label and table view
        Label nameLabel = new Label();
        statsTable = new TableView<>();

            ObservableList<Statistics> stats = getStats(statsFile);

            TableColumn<Statistics, String> correctColumn = new TableColumn<>("Number Correct");
            correctColumn.setMinWidth(100);
            correctColumn.setCellValueFactory(new PropertyValueFactory<>("correct"));

            TableColumn<Statistics, String> incorrectColumn = new TableColumn<>("Number Incorrect");
            incorrectColumn.setMinWidth(100);
            incorrectColumn.setCellValueFactory(new PropertyValueFactory<>("incorrect"));

            TableColumn<Statistics, String> yearColumn = new TableColumn<>("School Year");
            yearColumn.setMinWidth(100);
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("schoolYear"));

            TableColumn<Statistics, String> schoolColumn = new TableColumn<>("School Name");
            schoolColumn.setMinWidth(100);
            schoolColumn.setCellValueFactory(new PropertyValueFactory<>("schoolName"));

            TableColumn<Statistics, String> answeredColumn = new TableColumn<>("Number Answered");
            answeredColumn.setMinWidth(100);
            answeredColumn.setCellValueFactory(new PropertyValueFactory<>("numberAnswered"));

            statsTable.setItems(stats);
            statsTable.getColumns().addAll(correctColumn, incorrectColumn, yearColumn, schoolColumn, answeredColumn);

        // Button to return to admin page.
        Button returnAdmin = new Button();
        returnAdmin.setText("Back to Admin");
        returnAdmin.setOnAction(e -> {
			try {
				returnToAdminPage();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

        // Button to logout of programme.
        Button logout = new Button();
        logout.setText("Back to Quiz");
        logout.setOnAction(f -> {
			try {
				logout();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

        VBox vBox = new VBox(20);
        vBox.setSpacing(10);
        vBox.getChildren().addAll(returnAdmin, logout, statsTable);

        Scene scene = new Scene(vBox, 900, 600);
        window.setScene(scene);
        window.show();
    }

    private Object logout() throws Exception {
    	Stage stage = (Stage) window.getScene().getWindow();
		Home Home = new Home();
		Home.start(stage);
		return null;
	}

	public ObservableList<Statistics> getStats(String statsFile) {

        // New convertCSV object to convert data.
        List<Statistics> stats = output.processStats(statsFile);
        // Store java objects in an Array List.
        ObservableList<Statistics> allStats = FXCollections.observableArrayList(stats);

        return allStats;
    }

    public void returnToAdminPage() throws Exception {
    	Stage stage = window;
		AdminFunctions AdminFunctions = new AdminFunctions();
		AdminFunctions.start(stage);
    }

}
