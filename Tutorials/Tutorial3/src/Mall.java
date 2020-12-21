import java.util.HashMap;

public class Mall {
    public static final int MAX_STORES = 100;

    private String   name;
    private Store[]  stores;
    private int      storeCount;

    public Mall(String n) {
        name = n;
        stores = new Store[MAX_STORES];
        storeCount = 0;
    }

    public void addStore(Store s) {
        if (storeCount < MAX_STORES) {
            stores[storeCount++] =s;
        }
    }

    public boolean shoppedAtSameStore(Customer c1, Customer c2){
        boolean foundC1 = false;
        boolean foundC2 = false;
        for (int s = 0; s < storeCount; s++){
            for (int c = 0; c < stores[s].getCustomerCount(); c++){
                if (stores[s].getCustomers()[c] == c1){
                    foundC1 = true;
                }else if (stores[s].getCustomers()[c] == c2){
                    foundC2 = true;
                }
            }
            if (foundC1 && foundC2){
                return true;
            }
            foundC1 = false;
            foundC2 = false;
        }
        return false;
    }

    public int getUniqueCustomerCount(){
        HashMap<Customer, Boolean> uniqueCustomers = new HashMap<Customer, Boolean>();
        for (int s = 0; s < storeCount; s++) {
            for (int c = 0; c < stores[s].getCustomerCount(); c++) {
                if (!uniqueCustomers.containsKey(stores[s].getCustomers()[c])){
                    uniqueCustomers.put(stores[s].getCustomers()[c], true);
                }
            }
        }
        return uniqueCustomers.size();
    }

}
