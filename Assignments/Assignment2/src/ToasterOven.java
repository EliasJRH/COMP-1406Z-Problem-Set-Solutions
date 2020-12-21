public class ToasterOven extends Appliance{

    int width; // the width of the toaster oven
    boolean convection; // whether the toaster has convection heating or not

    public ToasterOven(double initPrice, int initQuantity, int initWattage, String initColor, String initBrand, int initWidth, boolean initConvection){
        super(initPrice, initQuantity, initWattage, initColor, initBrand); //calls the constructor for appliance
        //sets width and if the toaster is convection or not
        width = initWidth;
        convection = initConvection;
    }

    public String toString(){
        return width + " inch " + super.brand + " Toaster (" + super.color + ", " + super.wattage + " watts)\n" +
                "(" + super.price + " dollars each, " + super.stockQuantity + " in stock, " + super.soldQuantity + "sold)\n";
    }


}
