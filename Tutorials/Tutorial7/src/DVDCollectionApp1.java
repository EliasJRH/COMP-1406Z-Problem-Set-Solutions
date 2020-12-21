import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

/*
This is the "Control" part of the project. In this class a single pane is created
that contains all of the graphics that are created in DVDCollectionAppView1
that pane is used in the setScene method so essentially, everything in DVDCollectionAppView1 is everything
in aPane.

The constructor for this class also includes an instance of the model DVDCollection, the model can
be thought of as where all the information is being stored. The model is instantiated by using the return
from example1, a static method in DVDCollection.

In this control class, the eventhandlers for all of the buttons and listviews are included. Because each handler
needs to be added directly to the button or listview object itself, it is necesarry to first, retrieve the object. This
is done using getter methods from the view class. The handlers retrieve some input from the view, then update the model,
then update the view again to reflect the changes in the model which the view represents.
 */

public class DVDCollectionApp1 extends Application {

    DVDCollection model;

    public DVDCollectionApp1() {
      model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();


        // Create the view
        DVDCollectionAppView1 view = new DVDCollectionAppView1();
        view.update(model, 0);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAddButton(view);
            }
        });

        view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleDeleteButton(view);
            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getTitleList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getYearList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getYearList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getLengthList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update(model, view.getLengthList().getSelectionModel().getSelectedIndex());
            }
        });

        aPane.getChildren().add(view);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handleAddButton(DVDCollectionAppView1 view){
        String title = JOptionPane.showInputDialog("Enter the movie title");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year the movie was released"));
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of the movie in minutes"));

        model.add(new DVD(title, year, duration));
        view.update(model, 0);
    }

    public void handleDeleteButton(DVDCollectionAppView1 view){
        model.remove(view.getTitleList().getSelectionModel().getSelectedItem());
        view.update(model, 0);
    }
}