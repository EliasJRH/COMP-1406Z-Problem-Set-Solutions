package MVC;

import CustomPanes.StoreButtonPane;
import CustomPanes.StoreInfoPane;
import CustomPanes.StoreListViewPane;
import javafx.scene.layout.Pane;


public class ElectronicStoreView extends Pane {

    private StoreListViewPane storeStockPane;
    private StoreListViewPane currentCartPane;
    private StoreListViewPane popularItemsPane;
    private StoreInfoPane storeInfoPane;
    private StoreButtonPane storeButtonPane;
    private double currentCartCost = 0.00;

    public StoreListViewPane getStoreStockPane() { return storeStockPane; }
    public StoreListViewPane getCurrentCartPane() { return currentCartPane; }
    public StoreListViewPane getPopularItemsPane() { return popularItemsPane; }
    public StoreInfoPane getStoreInfoPane() { return storeInfoPane; }
    public StoreButtonPane getStoreButtonPane() { return storeButtonPane; }
    public double getCurrentCartCost() { return currentCartCost; }
    public void increaseCurrentCartCost(double costIncrease){
        currentCartCost += costIncrease;
    }

    public ElectronicStoreView(ElectronicStore model){
        setPrefSize(800,400);

        storeStockPane = new StoreListViewPane("Store Stock:", 303, 300);
        storeStockPane.relocate(167,16);

        currentCartPane = new StoreListViewPane("Current Cart: ($" + currentCartCost + ")", 303, 300);
        currentCartPane.relocate(480,16);

        popularItemsPane = new StoreListViewPane("Most Popular Items", 147, 180);
        popularItemsPane.relocate(10,135);

        storeInfoPane = new StoreInfoPane();
        storeInfoPane.relocate(0,19);

        storeButtonPane = new StoreButtonPane();
        storeButtonPane.relocate(0,320);

        getChildren().addAll(storeStockPane, currentCartPane, popularItemsPane, storeInfoPane, storeButtonPane);
    }

    public void update(){ //method for updating view based on interactions with GUI
        if (storeStockPane.getItemView().getSelectionModel().getSelectedIndex() < 0){
            storeButtonPane.getAddButton().setDisable(true);
        }else{
            storeButtonPane.getAddButton().setDisable(false);
        }

        if (currentCartPane.getItemView().getSelectionModel().getSelectedIndex() < 0){
            storeButtonPane.getRemoveButton().setDisable(true);
        }else{
            storeButtonPane.getRemoveButton().setDisable(false);
        }
    }

}
