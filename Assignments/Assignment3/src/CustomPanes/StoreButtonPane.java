package CustomPanes;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StoreButtonPane extends Pane {

    private Button resetButton;
    private Button addButton;
    private Button removeButton;
    private Button completeButton;

    public Button getResetButton() { return resetButton; }
    public Button getAddButton() { return addButton; }
    public Button getRemoveButton() { return removeButton; }
    public Button getCompleteButton() { return completeButton; }

    public StoreButtonPane(){
        setPrefSize(800, 50);

        resetButton = new Button("Reset Store");
        resetButton.relocate(20, 0);
        resetButton.setPrefSize(125,43);

        addButton = new Button("Add to Cart");
        addButton.relocate(250, 0);
        addButton.setPrefSize(125, 43);
        addButton.setDisable(true);

        removeButton = new Button("Remove from Cart");
        removeButton.relocate(480,0);
        removeButton.setPrefSize(151.5, 43);
        removeButton.setDisable(true);

        completeButton = new Button("Complete Sale");
        completeButton.relocate(631.5,0);
        completeButton.setPrefSize(152, 43);
        completeButton.setDisable(true);

        getChildren().addAll(resetButton, addButton, removeButton, completeButton);

    }

    public void update(){

    }

}
