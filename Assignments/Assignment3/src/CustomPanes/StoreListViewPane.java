package CustomPanes;

import Products.Product;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.ArrayList;

public class StoreListViewPane extends Pane {

    private Label titleLabel;
    private ListView<String> itemView;

    public Label getTitleLabel() { return titleLabel; }
    public ListView<String> getItemView() { return itemView; }

    public StoreListViewPane(String title, int width, int height){
        this.setPrefSize(width, height);
        titleLabel = new Label(title);

        itemView = new ListView<String>();
        itemView.setPrefSize(width, height - 20);
        itemView.relocate(0,20);

        getChildren().addAll(titleLabel, itemView);
    }

    public void update(int width, Product[] relevantList){ //method for updating list view based on model
        titleLabel.relocate((width / 2) - (titleLabel.getWidth() / 2), 0);
        ArrayList<String> toStringList = new ArrayList<String>();
        for (int i = 0; i < relevantList.length; i++){
            toStringList.add(relevantList[i].toString());
        }
        itemView.setItems(FXCollections.observableArrayList(toStringList));
    }

}
