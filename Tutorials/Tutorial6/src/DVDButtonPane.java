import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

//The view
public class DVDButtonPane extends Pane {

    Button addButton;
    Button deleteButton;
    Button statsButton;

    public DVDButtonPane(){
        setPrefSize(300, 30);
        addButton = new Button("Add");
        addButton.setAlignment(Pos.CENTER);
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(2,99,2); " +
                "-fx-text-fill: rgb(255,255,255);");
        addButton.relocate(0, 0);
        addButton.setPrefSize(90,30);

        deleteButton = new Button("Delete");
        deleteButton.setAlignment(Pos.CENTER);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(197,7,7); " +
                "-fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(100, 0);
        deleteButton.setPrefSize(90,30);

        statsButton = new Button("Stats");
        statsButton.setAlignment(Pos.CENTER);
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(230,230,230); " +
                "-fx-text-fill: rgb(0,0,0);");
        statsButton.relocate(210, 0);
        statsButton.setPrefSize(90,30);

        this.getChildren().addAll(addButton,deleteButton, statsButton);
    }

    public Button getAddButton(){ return addButton; }
    public Button getDeleteButton(){ return deleteButton; }
    public Button getStatsButton(){ return statsButton; }

}
