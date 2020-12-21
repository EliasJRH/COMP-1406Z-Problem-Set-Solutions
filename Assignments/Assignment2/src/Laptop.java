public class Laptop extends Computer{

    double screenSize; // the size of the screen in inches

    public Laptop(double initPrice, int initQuantity, double initCpuSpeed, int initRam, boolean initSSD, int initStorage, double initScreenSize){
        super(initPrice, initQuantity, initCpuSpeed, initRam, initSSD, initStorage); //calls the constructor for computer
        //sets the screen size of the laptop
        screenSize = initScreenSize;
    }

    public String toString(){
        String ssdString = (super.ssd) ? "SSD":"HDD";
        return screenSize + " inch Laptop PC with " + super.cpuSpeed + "ghz CPU, " + super.ram + "GB RAM, " + super.storage + "GB " + ssdString + " drive.\n" +
                "(" + super.price + " dollars each, " + super.stockQuantity + " in stock, " + super.soldQuantity + " sold)\n";
    }

}
