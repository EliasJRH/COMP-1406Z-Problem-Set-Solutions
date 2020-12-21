public class Customer {

    String name;
    int age;
    float money;
    boolean admitted;

    public Customer(String initName){
        name = initName;
        age = 0;
        money = 0;
        admitted = false;
    }

    public Customer(String initName, int initAge){
        name = initName;
        age = initAge;
        money = 0;
        admitted = false;
    }

    public Customer(String initName, int initAge, float initMoney){
        name = initName;
        age = initAge;
        money = initMoney;
        admitted = false;
    }

    public Customer(){
        name = "Jimmy John";
        age = 100;
        money = 7.50f;
        admitted = false;
    }

    public float computeFee(){
        if (age >= 18 && age < 65){
            return 12.75f;
        }else if (age <= 3){
            return 0;
        }else if (age >= 65){
            return 6.38f;
        }else if (age >= 4 && age <= 17){
            return 8.50f;
        }
        return 0;
    }

    public boolean spend(float amount){
        if (amount <= money && amount >= 0){
            money -= amount;
            return true;
        }
        return false;
    }

    public boolean hasMoreMoneyThan(Customer c){
        if (money > c.money){
            return true;
        }
        return false;
    }

    public void payAdmission(){
        if(spend(computeFee())) admitted = true;
    }

    public String toString(){
        String admittedString = (admitted) ? "" : "not ";
        return "Customer" + name + ": a " + age + " year old with $" + money + " who has " + admittedString + "been admitted";
    }


}
