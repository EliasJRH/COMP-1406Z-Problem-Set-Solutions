import java.util.ArrayList;

public class ArrayListTestProgram {
    public static void main(String args[]) {
        int total = 0;
        ArrayList<Integer> numbers;
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(45);
        numbers.add(23);
        numbers.add(87);
        numbers.add(89);
        numbers.add(213);
        for (Integer i: numbers){
            total += i;
        }
        System.out.println("The total is: " + total);
    }
}
