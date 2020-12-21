package Products;

public abstract class Product {

    private double price; //The price of the product
    public int stockQuantity; //Integer value of how much of the product is in stock
    private int soldQuantity; //Integer value of how much of the product has been sold

    public int getSoldQuantity() { return soldQuantity; }
    public void increaseSoldQuantity(int amnt){
        soldQuantity += amnt;
    }
    public double getPrice() { return price; }

    public Product(double initPrice, int initQuantity){
        //Constructor for all products, sets their price and stock quantity
        price = initPrice;
        stockQuantity = initQuantity;
    }

    public double sellUnits(int amount){
        //Method that each product has, sellUnits
        if (stockQuantity >= amount){
            //If the stockQuantity is greater than or equal to the passed in amount
            return amount * price;
            //Return the amount of the items times the price per each item, as that's the total amount being paid
        }
        return 0.0;
        //otherwise return 0, because the product can't be sold
    }

}
