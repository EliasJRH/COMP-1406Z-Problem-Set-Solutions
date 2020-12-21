import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp_6 extends Application {
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label titleLabel = new Label("Title");
        titleLabel.relocate(10,10);

        Label yearLabel = new Label("Year");
        yearLabel.relocate(220, 10);

        Label lengthLabel = new Label("Length");
        lengthLabel.relocate(290, 10);
        // ... ADD CODE HERE ... //

        // Create the lists
        String[] titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        String[] years = {"1978", "2002", "1968", "1999"};
        String[] lengths = {"124", "93", "126", "148"};
        // ... ADD CODE HERE ... //
        ListView<String> movieTitlesView = new ListView<String>();
        ListView<String> movieYearsView = new ListView<String>();
        ListView<String> movieLengthsView = new ListView<String>();

        ObservableList<String> movieTitlesOList = FXCollections.observableArrayList(titles);
        ObservableList<String> movieYearsOList = FXCollections.observableArrayList(years);
        ObservableList<String> movieLengthsOList = FXCollections.observableArrayList(lengths);

        movieTitlesView.setItems(movieTitlesOList);
        movieYearsView.setItems(movieYearsOList);
        movieLengthsView.setItems(movieLengthsOList);

        movieTitlesView.setPrefSize(200, 150);
        movieTitlesView.relocate(10,35);

        movieYearsView.setPrefSize(60,150);
        movieYearsView.relocate(220, 35);

        movieLengthsView.setPrefSize(60, 150);
        movieLengthsView.relocate(290, 35);

        // Create the buttons
        // The following code shows how to set the font,
        // background color and text color of a button:
        // b.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " +
        //     "-fx-text-fill: rgb(255,255,255);");
        //the 3 rgb values represent the red/green/blue values for the color your want
        // ... ADD CODE HERE ... //
        Button addButton = new Button("Add");
        addButton.setAlignment(Pos.CENTER);
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(2,99,2); " +
                "-fx-text-fill: rgb(255,255,255);");
        addButton.relocate(10, 195);
        addButton.setPrefSize(95,30);

        Button deleteButton = new Button("Delete");
        deleteButton.setAlignment(Pos.CENTER);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(197,7,7); " +
                "-fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(115, 195);
        deleteButton.setPrefSize(95,30);

        Button statsButton = new Button("Stats");
        statsButton.setAlignment(Pos.CENTER);
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(230,230,230); " +
                "-fx-text-fill: rgb(0,0,0);");
        statsButton.relocate(290, 195);
        statsButton.setPrefSize(60,30);

        // Don't forget to add the components to the window, set the title,
        // make it non-resizable, set Scene dimensions and then show the stage
        // ... ADD CODE HERE ... //
        aPane.getChildren().addAll(titleLabel, yearLabel, lengthLabel, movieTitlesView,
                movieYearsView, movieLengthsView, addButton, deleteButton, statsButton);
        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 359, 235));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
