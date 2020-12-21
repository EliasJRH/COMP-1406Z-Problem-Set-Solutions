public class Fridge {

    double size;
    boolean hasFreezer;
    String color;

    public Fridge(double initSize, boolean initHasFreezer, String initColor){
        size = initSize;
        hasFreezer = initHasFreezer;
        color = initColor;
    }

    public String toString(){
        String hasFreezerString = (hasFreezer) ? " with Freezer " : " ";
        return size + " cubic foot Fridge" + hasFreezerString + "(" + color + ")";
    }

//    public static void main(String[] args) {
//        Fridge f1 = new Fridge(15.6, true, "Gray");
//        Fridge f2 = new Fridge(10.5, false, "White");
//
//        System.out.println(f1);
//        System.out.println(f2);
//    }

}
