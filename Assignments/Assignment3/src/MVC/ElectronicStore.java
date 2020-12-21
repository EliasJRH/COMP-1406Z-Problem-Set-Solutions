package MVC;

import Products.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ElectronicStore {

    final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue;
    private int sales;
    private Product[] products = new Product[MAX_PRODUCTS];
    private ArrayList<Product> currentCart = new ArrayList<Product>();
    int productCount = 0;

    public String getName(){ return name; }
    public double getRevenue(){ return revenue; }
    public int getSales() { return sales; }
    public void increaseSales(){ sales++; }
    public Product[] getProducts() { return products; }
    public ArrayList<Product> getCurrentCart() {return currentCart; }

    public ElectronicStore(String initName){
        name = initName;
        //Constructor for ElectronicStore sets the name
    }

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
            products[item].increaseSoldQuantity(amount);
            //Stock is updated
        }
    } //sell products when GUI isn't used

    public void sellProducts(Product product, int amount){ //sell products when GUI is used, passes in product instead of index
        //Then revenue is increased by the value returned by sellUnits
        revenue += product.sellUnits(amount);
        //Stock is modified
        product.increaseSoldQuantity(amount);
    }

    public void printStock(){
        for(int i = 0; i < productCount; i++){
            //Prints out all stock that is not null
            System.out.print(i + ". " + products[i]);
        }
    }

    public Product[] determineCurrentStock(){
        ArrayList<Product> currentStockAList = new ArrayList<Product>();
        for (int i = 0; i < products.length; i++){
            //For loop runs through store stock and adds it to currentStockAList if at least 1 of that product exists
            if (products[i] == null) break;
            if (products[i].stockQuantity > 0) currentStockAList.add(products[i]);
        }

        //Product array that gets returned
        Product[] currentStock = new Product[currentStockAList.size()];
        for (int i = 0; i < currentStockAList.size(); i++){
            //Adds every item from the arraylist into the array
            currentStock[i] = currentStockAList.get(i);
        }

        //Returns array
        return currentStock; //The effective current stock list
    } //method that determines which stock can be sold

    public Product[] determinePopularProducts(){
        //creates array list of products to use for sorting
        ArrayList<Product> copyOfProducts = new ArrayList<>();
        Product[] mostPopularProducts = new Product[3];

        for (int i = 0; i < products.length; i++){
            if (products[i] == null) break;
            //Adds all products to copy list
            copyOfProducts.add(products[i]);
        }
        //Sorts arraylist using getSoldQuantity as comparator, then reverses the list (greatest to least)
        copyOfProducts.sort(Comparator.comparing(Product::getSoldQuantity).reversed());

        //Puts top 3 products into array, then returns array
        mostPopularProducts[0] = copyOfProducts.get(0);
        mostPopularProducts[1] = copyOfProducts.get(1);
        mostPopularProducts[2] = copyOfProducts.get(2);

        return mostPopularProducts;
    } //method that returns the 3 most popular products

    public Product[] transferCartToArray(){ //method that returns the current cart into an array
        Product[] currentCartArray = new Product[currentCart.size()];
        for (int i = 0; i < currentCart.size(); i++){
            currentCartArray[i] = currentCart.get(i);
        }
        //Returns every item in current cart to an array
        return currentCartArray;
    }

}
