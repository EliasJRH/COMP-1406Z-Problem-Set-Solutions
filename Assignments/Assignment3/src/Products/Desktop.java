package Products;

public class Desktop extends Computer {

    String profile; //a string describing the size of the desktop case

    public Desktop(double initPrice, int initQuantity, double initCpuSpeed, int initRam, boolean initSSD, int initStorage, String initProfile){
        super(initPrice, initQuantity, initCpuSpeed, initRam, initSSD, initStorage); //Calls the constructor for computer passing in these values
        //Constructor for desktop sets profile
        profile = initProfile;
    }

    public String toString(){
        String ssdString = (super.ssd) ? "SSD":"HDD";
        return profile + " Desktop PC with " + super.cpuSpeed + "ghz CPU, " + super.ram + "GB RAM, " + super.storage + "GB " + ssdString + " drive. \n";
    }

}
