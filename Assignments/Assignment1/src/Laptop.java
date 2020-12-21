public class Laptop {

    double CPUSpeed;
    int RAM;
    int Storage;
    boolean storageIsSSD;
    int screenSize;

    public Laptop(double initCPUSpeed, int initRAM, int initStorage, boolean initStorageIsSSD, int initScreenSize){
        CPUSpeed = initCPUSpeed;
        RAM = initRAM;
        Storage = initStorage;
        storageIsSSD = initStorageIsSSD;
        screenSize = initScreenSize;
    }

    public String toString(){
        String SSDStirng = (storageIsSSD) ? "SSD":"HDD";
        return screenSize + "\" Laptop PC with " + CPUSpeed + "ghz CPU, " + RAM + "GB RAM, " + Storage + "GB " + SSDStirng + " drive.";
    }

//    public static void main(String[] args) {
//        Laptop l1 = new Laptop(3.1, 32, 500, true, 15);
//        Laptop l2 = new Laptop(2.5, 8, 250, false, 13);
//
//        System.out.println(l1);
//        System.out.println(l2);
//    }

}
