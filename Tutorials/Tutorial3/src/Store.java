import java.util.ArrayList;

public class Store {
    private static final int MAX_CUSTOMERS = 500;
    private String name;
    private Customer[] customers;
    private int customerCount;
    private static int LATEST_ID = 100000;

    public Store(String n) {
        name = n;
        customers = new Customer[MAX_CUSTOMERS];
        customerCount= 0;
    }

    public void addCustomer(Customer c) {
        if (customerCount < MAX_CUSTOMERS)customers[customerCount++] = c;
        c.setId(LATEST_ID);
        LATEST_ID++;
    }

    public void listCustomers() {
        for (int i=0; i<customerCount; i++){
            System.out.println(customers[i]);
        }
    }


    public int averageCustomerAge(){
        int totalAge = 0;
        for (int i = 0; i < customerCount; i++){
            totalAge += customers[i].getAge();
        }
        return totalAge / customerCount;
    }

    public Customer richestCustomer(){
        Customer richestCustomerC = customers[0];
        for (int i = 1; i < customerCount; i++){
            if (customers[i].hasMoreMoneyThan(richestCustomerC)){
                richestCustomerC = customers[i];
            }
        }
        return richestCustomerC;
    }

    public Customer[]getCustomers() {
        return customers;
    }
    public int getCustomerCount() {
        return customerCount;
    }

    public Customer[] friendsFor(Customer lonelyCustomer){
        Customer[] listOfFriends;
        ArrayList<Customer> listOfFriendsAL = new ArrayList<Customer>();
        for (int c = 0; c < customerCount; c++){
            if (((lonelyCustomer.getAge() - 3) <= customers[c].getAge()) && (customers[c].getAge() <= lonelyCustomer.getAge() + 3) && (customers[c] != lonelyCustomer)){
                listOfFriendsAL.add(customers[c]);
            }
        }
        listOfFriends = new Customer[listOfFriendsAL.size()];
        for (int c = 0; c < listOfFriendsAL.size(); c++){
            listOfFriends[c] = listOfFriendsAL.get(c);
        }
        return listOfFriends;
    }


}
