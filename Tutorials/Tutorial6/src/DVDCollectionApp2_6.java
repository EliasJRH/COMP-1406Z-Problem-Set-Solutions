//The view
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp2_6 extends Application {

    private DVDCollection model;
    ListView<DVD> tList;
    TextField tField;
    TextField yField;
    TextField lField;

    public DVDCollectionApp2_6(){
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10,10);

        Label label2 = new Label("Title");
        label2.relocate(10,202);

        Label label3 = new Label("Year");
        label3.relocate(10,242);

        Label label4 = new Label("Length");
        label4.relocate(120,242);

        // Create the TextFields
        tField = new TextField();
        tField.relocate(50,200);
        tField.setPrefSize(500,30);

        yField = new TextField();
        yField.relocate(50,240);
        yField.setPrefSize(55,30);

        lField = new TextField();
        lField.relocate(180,240);
        lField.setPrefSize(45,30);

        // Create the lists
        tList = new ListView<DVD>();
        tList.relocate(10,40);
        tList.setPrefSize(540,150);
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));

        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleTListSelection();
            }
        });

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250,240);

        buttonPane.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAddButtonPress();
            }
        });

        buttonPane.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleDeleteButtonPress();
            }
        });

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 560,290));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //The controllers
    public void update(){
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
    }

    private void handleAddButtonPress(){
        model.add(new DVD(tField.getText(), Integer.parseInt(yField.getText()), Integer.parseInt(lField.getText())));
        update();
    }

    private void handleDeleteButtonPress(){
        model.remove(tList.getSelectionModel().getSelectedItem().getTitle());
        update();
    }

    private void handleTListSelection(){
        DVD selectedMovie = tList.getSelectionModel().getSelectedItem();
        tField.setText(selectedMovie.getTitle());
        yField.setText(selectedMovie.getYear() + "");
        lField.setText(selectedMovie.getDuration() + "");
    }

}
