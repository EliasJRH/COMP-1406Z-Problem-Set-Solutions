package MVC;

import Other.createStoreMethod;
import Products.Product;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {

    Pane viewPane;
    ElectronicStore model;
    ElectronicStoreView view;

    public ElectronicStoreApp() {  }

    @Override
    public void start(Stage primaryStage) throws Exception{
        model = createStoreMethod.createStore();
        viewPane = new Pane();
        view = new ElectronicStoreView(model);

        viewPane.getChildren().add(view);

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setScene(new Scene(viewPane, 800, 400));
        primaryStage.show();
        primaryStage.setResizable(false);

        //Calls the update method for all of the sub panes
        view.getStoreStockPane().update((int)view.getStoreStockPane().getWidth(), model.determineCurrentStock());
        view.getCurrentCartPane().update((int)view.getCurrentCartPane().getWidth(), model.transferCartToArray());
        view.getPopularItemsPane().update((int)view.getPopularItemsPane().getWidth(), model.determinePopularProducts());
        view.getStoreInfoPane().update((int)view.getStoreInfoPane().getWidth(), model);

        view.getStoreStockPane().getItemView().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update();
            }
        });

        view.getCurrentCartPane().getItemView().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.update();
            }
        });

        view.getStoreButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleAddButton();
            }
        });

        view.getStoreButtonPane().getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleRemoveButton();
            }
        });

        view.getStoreButtonPane().getCompleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleCompleteButton();
            }
        });

        view.getStoreButtonPane().getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleResetButton();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handleAddButton(){
        //Gets the selected product from the storeStockPane
        Product selectedProduct = model.determineCurrentStock()[view.getStoreStockPane().getItemView().getSelectionModel().getSelectedIndex()];

        //adds the selected item to the cart
        model.getCurrentCart().add(selectedProduct);

        //removes 1 from the stock of the selected item
        selectedProduct.stockQuantity--;

        //because using the add button will always result in the cart not being empty, the complete sale button
        //always gets enabled
        view.getStoreButtonPane().getCompleteButton().setDisable(false);

        //Updates the current cart label to reflect the addition of the new item
        view.increaseCurrentCartCost(selectedProduct.getPrice());

        //disables the addButton
        view.getStoreStockPane().getItemView().getSelectionModel().clearSelection();
        view.update();

        //updates the view of storeStockPane and currentCartPane
        view.getStoreStockPane().update((int)view.getStoreStockPane().getWidth(), model.determineCurrentStock());
        view.getCurrentCartPane().update((int)view.getCurrentCartPane().getWidth(), model.transferCartToArray());
        view.getCurrentCartPane().getTitleLabel().setText("Current Cart: ($" + view.getCurrentCartCost() + "): ");
    }

    public void handleRemoveButton(){
        //Gets the product selected from the currentCartPane
        Product selectedProduct = model.getCurrentCart().get(view.getCurrentCartPane().getItemView().getSelectionModel().getSelectedIndex());

        //removes that product from the cart
        model.getCurrentCart().remove(view.getCurrentCartPane().getItemView().getSelectionModel().getSelectedIndex());

        //Adds 1 back to the quantity of the
        selectedProduct.stockQuantity++;

        //Disables the complete purchase button if there's nothing left in the cart
        if (model.getCurrentCart().size() < 1){
            view.getStoreButtonPane().getCompleteButton().setDisable(true);
        }

        //Updates the current cart label to reflect the remove of the item
        view.increaseCurrentCartCost(-selectedProduct.getPrice());

        //Disables the remove button
        view.getCurrentCartPane().getItemView().getSelectionModel().clearSelection();
        view.update();

        //updates the view of storeStockPane and currentCartPane
        view.getStoreStockPane().update((int)view.getStoreStockPane().getWidth(), model.determineCurrentStock());
        view.getCurrentCartPane().update((int)view.getCurrentCartPane().getWidth(), model.transferCartToArray());
        view.getCurrentCartPane().getTitleLabel().setText("Current Cart: ($" + view.getCurrentCartCost() + "): ");
    }

    public void handleCompleteButton(){
        //Sells each product in the cart
        for (Product p: model.getCurrentCart()){
            model.sellProducts(p, 1);
            view.increaseCurrentCartCost(-p.getPrice());
        }
        model.increaseSales();

        //Clears the cart
        model.getCurrentCart().clear();

        //Updates the store info
        view.getStoreInfoPane().update((int)view.getStoreInfoPane().getWidth(), model);

        //Updates current cart and stock
        view.getStoreStockPane().update((int)view.getStoreStockPane().getWidth(), model.determineCurrentStock());
        view.getCurrentCartPane().update((int)view.getCurrentCartPane().getWidth(), model.transferCartToArray());
        view.getCurrentCartPane().getTitleLabel().setText("Current Cart: ($" + view.getCurrentCartCost() + "): ");

        //Updates popular items
        view.getPopularItemsPane().update((int)view.getPopularItemsPane().getWidth(), model.determinePopularProducts());
    }

    public void handleResetButton(){
        //Resets the model to the original method
        model = createStoreMethod.createStore();
        //Updates all the components
        view.getStoreStockPane().update((int)view.getStoreStockPane().getWidth(), model.determineCurrentStock());
        view.getCurrentCartPane().update((int)view.getCurrentCartPane().getWidth(), model.transferCartToArray());
        view.getPopularItemsPane().update((int)view.getPopularItemsPane().getWidth(), model.determinePopularProducts());
        view.getStoreInfoPane().update((int)view.getStoreInfoPane().getWidth(), model);
    }
}
