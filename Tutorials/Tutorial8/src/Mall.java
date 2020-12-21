import java.util.ArrayList;

public class Mall {
    public static final int MAX_STORES = 100;
    private String name;
    private ArrayList<Store> stores;

    public Mall(String n) {
        name = n;
        stores = new ArrayList<Store>();
    }

    public void addStore(Store s) {
        if (stores.size() < MAX_STORES) {
            stores.add(s);
        }
    }

    public int getUniqueCustomerCount(){
        // First determine how many customers are in the stores
        int total = 0;
        for (int i=0; i<stores.size(); i++) {
            total += stores.get(i).getCustomerCount();
        }

        // Now go through and add all the customers to an array, as long as they are not already in there
        // Keep track of unique ones
        int unique = 0;
        ArrayList<Customer> uniqueCustomers = new ArrayList<Customer>();

        for (int i=0; i<stores.size(); i++) {
            ArrayList<Customer> customersInStore = stores.get(i).getCustomers();
            int numInStore = stores.get(i).getCustomerCount();
            for (int j=0; j<numInStore; j++) {
                boolean found = false;
                for(int k=0; k<unique; k++) {
                    if (customersInStore.get(j) == uniqueCustomers.get(k))
                        found = true;
                }
                if (!found) {
                    uniqueCustomers.add(customersInStore.get(j));
                    unique++;
                }

            }
        }
        return unique;
    }

    public boolean shoppedAtSameStore(Customer c1, Customer c2){
        for(int i = 0; i < stores.size(); i++){
            ArrayList<Customer> temp = stores.get(i).getCustomers();
            boolean didC1 = false;
            boolean didC2 = false;
            for(int j = 0; j < temp.size(); j++){
                if(temp.get(j) == c1){
                    didC1 = true;
                }
                if(temp.get(j) == c2){
                    didC2 = true;
                }

            }
            if(didC1 && didC2){
                return true;
            }

        }
        return false;
    }
}
