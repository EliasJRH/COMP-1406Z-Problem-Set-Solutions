package Products;

public abstract class Appliance extends Product{

    int wattage; //Integer value representing the wattage of the Fridge/Toaster Over
    String color; //String value of the color of the Fridge/Toaster Over
    String brand; //String value of the brand of the Fridge/Toaster Over

    public Appliance(double initPrice, int initQuantity, int initWattage, String initColor, String initBrand){
        super(initPrice, initQuantity); //calls the constructor for product passing in the price and the stock quantity
        //Sets the wattage, color and brand
        wattage = initWattage;
        color = initColor;
        brand = initBrand;
    }


}
