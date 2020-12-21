package CustomPanes;

import MVC.ElectronicStore;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class StoreInfoPane extends Pane {

    private Label storeSummaryLabel;
    private Label numOfSalesLabel;
    private Label revenueLabel;
    private Label moneyPerSaleLabel;

    private TextField numOfSalesTField;
    private TextField revenueTField;
    private TextField moneyPerSaleTField;

    public TextField getNumOfSalesTField() { return numOfSalesTField; }
    public TextField getRevenueTField() { return revenueTField; }
    public TextField getMoneyPerSaleTField() { return moneyPerSaleTField; }

    public StoreInfoPane(){
        setPrefSize(170,140);
        storeSummaryLabel = new Label("Store Summary:");

        numOfSalesLabel = new Label("# Sales:");
        numOfSalesLabel.relocate(32, 21);

        numOfSalesTField = new TextField("0");
        numOfSalesTField.relocate(76,17);
        numOfSalesTField.setPrefSize(83,10);
        numOfSalesTField.setEditable(false);

        revenueLabel = new Label("Revenue:");
        revenueLabel.relocate(24, 50);

        revenueTField = new TextField();
        revenueTField.relocate(76,45);
        revenueTField.setPrefSize(83,10);
        revenueTField.setEditable(false);

        moneyPerSaleLabel = new Label("$ / Sale:");
        moneyPerSaleLabel.relocate(30, 79);

        moneyPerSaleTField = new TextField("N/A");
        moneyPerSaleTField.relocate(76,73);
        moneyPerSaleTField.setPrefSize(83,10);
        moneyPerSaleTField.setEditable(false);

        getChildren().addAll(storeSummaryLabel, numOfSalesLabel, numOfSalesTField, revenueLabel, revenueTField,
                moneyPerSaleLabel, moneyPerSaleTField);
    }

    public void update(int width, ElectronicStore model){
        storeSummaryLabel.relocate((width / 2) - (storeSummaryLabel.getWidth() / 2), -5);
        numOfSalesTField.setText(String.valueOf(model.getSales()));
        revenueTField.setText(String.valueOf(model.getRevenue()));
        moneyPerSaleTField.setText(String.valueOf(model.getRevenue() / model.getSales()));
    }

}
