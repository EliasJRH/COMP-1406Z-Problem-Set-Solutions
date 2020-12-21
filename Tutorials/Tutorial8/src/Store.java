import java.util.ArrayList;

public class Store {
  private static int LATEST_ID = 100000;
  private String name;
  private ArrayList<Customer> customers;
  
  public Store(String n) {
    name = n;
    customers = new ArrayList<>();
  }
  
  public ArrayList<Customer> getCustomers() {
    return customers;
  }
  
  public int getCustomerCount() {
    return customers.size();
  }
  
  
  public void addCustomer(Customer c) {
    customers.add(c);
    c.setID(LATEST_ID);
    LATEST_ID++;
  }
  
  public void listCustomers() {
    for (int i=0; i<customers.size(); i++)
      System.out.println(customers.get(i));
    
  }
  
  public int averageCustomerAge(){
    int total = 0;
    for(int i = 0; i < customers.size(); i++){
      total += customers.get(i).getAge();
    }
    System.out.println(total + " / " + customers.size());
    return total / customers.size();
  }
  
  public Customer richestCustomer(){
    Customer richest = null;
    for(int i = 0; i < customers.size(); i++){
      if(richest == null || customers.get(i).hasMoreMoneyThan(richest)){
        richest = customers.get(i);
      }
    }
    return richest;
  }
  
  public ArrayList<Customer> friendsFor(Customer c){
    int friendCount = 0;
    
    for(int i =0; i < customers.size(); i++){
      if(Math.abs(customers.get(i).getAge() - c.getAge()) <= 3 && c != customers.get(i)){
        friendCount++;
      }
    }
    ArrayList<Customer> friends = new ArrayList<Customer>();
    friendCount = 0;
    for(int i = 0; i < customers.size(); i++){
      if(Math.abs(customers.get(i).getAge() - c.getAge()) <= 3 && c != customers.get(i)){
        friends.add(customers.get(i));
        friendCount++;
      }
    }
    return friends;
  }
}
