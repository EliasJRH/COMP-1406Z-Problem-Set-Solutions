public class Customer {

    private String name;
    private int age;
    private float money;
    int id;

    public Customer(String n, int a, float m){
        name = n;
        age = a;
        money = m;
        id = -1;
    }

    public String toString(){
        return "Customer " + name + ": a " + age + " year old with $" + money;
    }

    public String getName(){ return name; }

    public int getAge(){ return age; }

    public int getId(){ return id; }

    public void setId(int initID){
        id = initID;
    }

    public boolean hasMoreMoneyThan(Customer c){
        return (money > c.money) ? true: false;
    }

}
