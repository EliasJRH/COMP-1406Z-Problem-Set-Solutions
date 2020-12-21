public class Desktop {

    double CPUSpeed;
    int RAM;
    int Storage;
    boolean storageIsSSD;

    public Desktop(double initCPUSpeed, int initRAM, int initStorage, boolean initStorageIsSSD){
        CPUSpeed = initCPUSpeed;
        RAM = initRAM;
        Storage = initStorage;
        storageIsSSD = initStorageIsSSD;
    }

    public String toString(){
        String SSDStirng = (storageIsSSD) ? "SSD":"HDD";
        return "Desktop PC with " + CPUSpeed + "ghz" + " CPU, " + RAM + "GB RAM, " + Storage + "GB  " + SSDStirng + " drive.";
    }

//    public static void main(String[] args) {
//        Desktop d1 = new Desktop(3.5, 8, 500, false);
//        Desktop d2 = new Desktop(3.0, 16, 250, true);
//
//        System.out.println(d1);
//        System.out.println(d2);
//    }

}
