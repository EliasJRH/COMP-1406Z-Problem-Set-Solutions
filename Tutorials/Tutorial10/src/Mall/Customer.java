package Mall;

import java.io.*;
import java.nio.Buffer;

public class Customer implements Serializable{
    private String name;
    private int age;
    private double money;
    private int id;

    public Customer(String n, int a, double m) {
        name = n;
        age = a;
        money = m;
        id = -1;
    }

    public void setID(int newID) {
        id = newID;
    }

    public String toString() {
        return "Mall.Customer " + name + ": a " + age + " year old with $" + money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() { return money; }

    public int getId() { return id; }

    public boolean hasMoreMoneyThan(Customer c) {
        return money > c.money;
    }

//    public void saveTo (PrintWriter aFile) throws IOException{
////        aFile.println(name);
////        aFile.println(age);
////        aFile.println(money);
////        aFile.println("");
//        aFile.println(id + "," + name + "," + age + "," + money);
//    }
//
//    public static Customer readFrom (BufferedReader aFile) throws IOException{
//        String[] info = aFile.readLine().split(",");
//        return new Customer(info[1], Integer.parseInt(info[2]), Float.parseFloat(info[3]));
////        return new Customer(aFile.readLine(), Integer.parseInt(aFile.readLine()), Float.parseFloat(aFile.readLine()));
//    }
}
