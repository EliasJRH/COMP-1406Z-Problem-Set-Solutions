import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/*
This is the "view" part of the project. This class extends pane and creates all of the graphical objects that are
displayed when the program runs. Essentially, this pane object has all of the other objects added onto itself, when
the program runs, we get this pane object and display it all on the window.

In this class you will find instances of all of the graphical components of the projects as well as all of the methods
to change their size, location etc. You will also find the getter and setter methods for all of those components.

Lastly, in this class is the update method that updates the components in this "view" class, with the information that is
stored in the "model" class. The update method is called from the "control" class, and has the "model" and the index of the
selected item passed into it from the "control" class as well. What's happening in the update class is the changing of
the components created here to represent the information that is stored in the "model" class.
 */


public class DVDCollectionAppView1 extends Pane implements DVDView{
    private ListView<String> tList;
    private ListView<Integer> yList, lList;
    private DVDButtonPane buttonPane;

    public ListView<String> getTitleList() { return tList; }
    public ListView<Integer> getYearList() { return yList; }
    public ListView<Integer> getLengthList() { return lList; }
    public DVDButtonPane getButtonPane() { return buttonPane; }

    public DVDCollectionAppView1() {
            // Create the labels
            Label label1 = new Label("Title");
            label1.relocate(10, 10);
            Label label2 = new Label("Year");
            label2.relocate(220, 10);
            Label label3 = new Label("Length");
            label3.relocate(290, 10);

            // Create the lists
            tList = new ListView<String>();
            tList.relocate(10, 40);
            tList.setPrefSize(200,150);

            yList = new ListView<Integer>();
            yList.relocate(220, 40);
            yList.setPrefSize(60,150);

            lList = new ListView<Integer>();
            lList.relocate(290, 40);
            lList.setPrefSize(60,150);

            // Create the button pane
            buttonPane = new DVDButtonPane();
            buttonPane.relocate(30, 200);
            buttonPane.setPrefSize(305,30);

            // Add all the components to the Pane
            getChildren().addAll(label1, label2, label3, tList, yList, lList, buttonPane);

            setPrefSize(360, 240);
        }

    @Override
    public void update(DVDCollection model, int selectedDVD) {
        DVD[] dvdList = model.getDVDList();
        String[] titleArray = new String[model.getDvdCount()];
        Integer[] yearArray = new Integer[model.getDvdCount()];
        Integer[] durationArray = new Integer[model.getDvdCount()];

        for (int i = 0; i < dvdList.length; i++){
            titleArray[i] = dvdList[i].getTitle();
            yearArray[i] = dvdList[i].getYear();
            durationArray[i] = dvdList[i].getDuration();
        }

        tList.setItems(FXCollections.observableArrayList(titleArray));
        yList.setItems(FXCollections.observableArrayList(yearArray));
        lList.setItems(FXCollections.observableArrayList(durationArray));

        tList.getSelectionModel().select(selectedDVD);
        yList.getSelectionModel().select(selectedDVD);
        lList.getSelectionModel().select(selectedDVD);

    }
}