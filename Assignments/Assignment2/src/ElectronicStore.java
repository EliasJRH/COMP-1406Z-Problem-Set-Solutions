import java.util.Arrays;

public class ElectronicStore {

    final int MAX_PRODUCTS = 10;
    private String name;
    double revenue;
    Product[] products = new Product[MAX_PRODUCTS];
    int productCount = 0;

    public ElectronicStore(String initName){
        name = initName;
        //Constructor for ElectronicStore sets the name
    }

    public String getName(){ return name; }
    //Getter function returns name of the store

    public boolean addProduct(Product p){
        //Add products
        for (int i = 0; i < MAX_PRODUCTS; i++){
            //For each item in the array
            if (products[i] == null){
                //If their exists an index in the array which is null
                products[i] = p;
                //The product is added into that slot
                productCount++;
                //Product count is increased by 1
                return true;
            }
        }
        //Otherwise just return false
        return false;
    }

    public void sellProducts(int item, int amount){
        if ((0 <= item && item < productCount) && (amount <= products[item].stockQuantity && amount > 0)){
            /*
            If:
                - The index of item is between 0 (inclusive) and the number of total products (exclusive)
                - The amount asked for of the selected item is less than or equal the current quantity of the selected
                and that number is greater than 0 (positive)
             */
            revenue += products[item].sellUnits(amount);
            //Then revenue is increased by the value returned by sellUnits
            products[item].stockQuantity -= amount;
            products[item].soldQuantity += amount;
            //Stock is updated
        }
    }

    public double getRevenue(){ return revenue; }
    //Getter function returns revenue of store

    public void printStock(){
        for(int i = 0; i < productCount; i++){
            //Prints out all stock that is not null
            System.out.print(i + ". " + products[i]);
        }
    }

}
