package Products;

public class Fridge extends Appliance{

    double cubicFeet; //The volume of the fridge in cubic feet
    boolean hasFreezer; //Whether the fridge has a freezer or not

    public Fridge(double initPrice, int initQuantity, int initWattage, String initColor, String initBrand, double initFeet, boolean initFreezer){
        super(initPrice, initQuantity, initWattage, initColor, initBrand); //calls the constructor for appliance
        //Sets cubic feet and hasFreezer
        cubicFeet = initFeet;
        hasFreezer = initFreezer;
    }

    public String toString(){
        String freezerString = (hasFreezer) ? " with Frezzer " : " ";
        return cubicFeet + " cu. ft. " + super.brand + " Fridge" + freezerString + "(" + super.color + ", " + super.wattage + " watts)\n";
    }

}
