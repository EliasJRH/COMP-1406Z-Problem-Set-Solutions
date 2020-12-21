public abstract class Computer extends Product {

    double cpuSpeed; //Double value of the CPU speed of the Desktop/Laptop
    int ram; //Integer value of the RAM in GB in the Desktop/Laptop
    boolean ssd; //Boolean value whether the Desktop/Laptop has (true) or doesn't have (false) an ssd storage
    int storage; //Integer value of storage in GB in the Desktop/Laptop

    public Computer(double initPrice, int initQuantity, double initCpuSpeed, int initRam, boolean initSSD, int initStorage){
        super(initPrice, initQuantity); //calls the constructor for product passing in the price and the stock quantity
        //Constructor for computer sets cpuSpeed, RAM, SSD boolean and storage
        cpuSpeed = initCpuSpeed;
        ram = initRam;
        ssd = initSSD;
        storage = initStorage;
    }

}
