import java.util.Scanner;

public class ElectronicStoreTester {

    public static void main(String[] args) {
        ElectronicStore store = new ElectronicStore("Jimmys Thing-A-Ma-Jigs");
        store.printStock();
        String nextInput = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a term to search for: ");
        nextInput = input.nextLine();
        while (!nextInput.equalsIgnoreCase("quit")){
            System.out.println((store.searchStock(nextInput)) ? "A matching item is contained in the store's stock." : "No items in the store's stock match that term");
            System.out.print("Enter a term to search for: ");
            nextInput = input.nextLine();
        }
    }

}
