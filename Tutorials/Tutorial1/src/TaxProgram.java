import java.util.Scanner;

public class TaxProgram {
    public static void main(String[] args) {
        double income, fedTax, provTax;
        int dependants;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your taxable income: ");
        income = input.nextDouble();
        System.out.println();

        System.out.print("Please enter your number of dependants: ");
        dependants = input.nextInt();
        System.out.println();

        fedTax = calculateFedTax(income);
        provTax = calculateProvTax(fedTax, dependants);
        printOutput(income, dependants, fedTax, provTax);

    }

    public static double calculateFedTax(double income){
        double fedTax = 0;
        if (income <= 29590.00){
            fedTax = (income * 0.17);
        }else if ((29590.01 < income) && (income < 59179.99)){
            fedTax = 5030.3 + ((income - 29590) * 0.26);
        }else if (income >= 59180.00){
            fedTax = 12723.7 + ((income - 59180) * 0.29);
        }
        return fedTax;
    }

    public static double calculateProvTax(double fedTax, int dependants){
        return ((fedTax * 0.425) - (160.50 + (328 * dependants)));
    }

    public static void printOutput(double income, int dependants, double fedTax, double provTax){
        System.out.println("Here is your tax breakdown:");
        System.out.println();
        System.out.println(String.format("%-" + (27 - (String.format("%,1.2f", income)).length()) + "s%" + (1 + (String.format("%,1.2f", income)).length()) + "s", "Income", "$" + String.format("%,1.2f", income)));
        System.out.println(String.format("%-" + (28 - (String.format("%,d", dependants)).length()) +"s%,d", "Dependants", dependants));
        System.out.println("----------------------------");
        System.out.println(String.format("%-" + (27 - (String.format("%,1.2f", fedTax)).length()) + "s%" + (1 + (String.format("%,1.2f", fedTax)).length()) + "s", "Federal Tax", "$" + String.format("%,1.2f", fedTax)));
        System.out.println(String.format("%-" + (27 - (String.format("%,1.2f", provTax)).length()) +"s%" + (1 + (String.format("%,1.2f", provTax)).length()) + "s", "Provincial Tax", "$" + String.format("%,1.2f", provTax)));
        System.out.println("============================");
        System.out.println(String.format("%-" + (27 - (String.format("%,1.2f", (fedTax + provTax))).length()) +"s%" + (1 + (String.format("%,1.2f", (fedTax + provTax))).length()) + "s", "Total Tax", "$" + String.format("%,1.2f", (fedTax + provTax))));
    }
}
