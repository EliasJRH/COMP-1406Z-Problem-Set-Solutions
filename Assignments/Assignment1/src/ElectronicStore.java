public class ElectronicStore {

    String name;
    Desktop[] desktops = new Desktop[3];
    Laptop[] laptops = new Laptop[3];
    Fridge[] fridges = new Fridge[3];

    public ElectronicStore(String initName){
        name = initName;

        desktops[0] = new Desktop(3.5, 8, 500, false);
        desktops[1] = new Desktop(3.0, 16, 250, true);
        desktops[2] = new Desktop(4.3, 32, 500, true);

        laptops[0] = new Laptop(3.1, 32, 500, true, 15);
        laptops[1] = new Laptop(2.5, 8, 250, false, 13);
        laptops[2] = new Laptop(3.0, 16, 250, true, 15);

        fridges[0] = new Fridge(16.5, true, "Black");
        fridges[1] = new Fridge(12.0, false, "White");
        fridges[2] = new Fridge(23.0, true, "Red");
    }

    public void printStock(){
        System.out.println("The store stock includes: ");
        for (Desktop d: desktops){
            System.out.println(d);
        }
        for (Laptop l: laptops){
            System.out.println(l);
        }
        for (Fridge f: fridges){
            System.out.println(f);
        }
    }

    public boolean searchStock(String stringToSearch){
        boolean itemFound;
        for (Desktop d : desktops){
            for (int startingIndex = 0; startingIndex < d.toString().length(); startingIndex++){
                if (Character.toLowerCase(d.toString().charAt(startingIndex)) == Character.toLowerCase(stringToSearch.charAt(0))){
                    itemFound = true;
                    for (int searchingIndex = 1; searchingIndex < stringToSearch.length(); searchingIndex++){
                        if (Character.toLowerCase(stringToSearch.charAt(searchingIndex)) != Character.toLowerCase(d.toString().charAt(startingIndex + searchingIndex))){
                            itemFound = false;
                            break;
                        }
                    }
                    if (itemFound){
                        return true;
                    }
                }
            }
        }
        for (Laptop l : laptops){
            for (int startingIndex = 0; startingIndex < l.toString().length(); startingIndex++){
                if (Character.toLowerCase(l.toString().charAt(startingIndex)) == Character.toLowerCase(stringToSearch.charAt(0))){
                    itemFound = true;
                    for (int searchingIndex = 1; searchingIndex < stringToSearch.length(); searchingIndex++){
                        if (Character.toLowerCase(stringToSearch.charAt(searchingIndex)) != Character.toLowerCase(l.toString().charAt(startingIndex + searchingIndex))){
                            itemFound = false;
                            break;
                        }
                    }
                    if (itemFound){
                        return true;
                    }
                }
            }
        }
        for (Fridge f: fridges){
            for (int startingIndex = 0; startingIndex < f.toString().length(); startingIndex++){
                if (Character.toLowerCase(f.toString().charAt(startingIndex)) == Character.toLowerCase(stringToSearch.charAt(0))){
                    itemFound = true;
                    for (int searchingIndex = 1; searchingIndex < stringToSearch.length(); searchingIndex++){
                        if (Character.toLowerCase(stringToSearch.charAt(searchingIndex)) != Character.toLowerCase(f.toString().charAt(startingIndex + searchingIndex))){
                            itemFound = false;
                            break;
                        }
                    }
                    if (itemFound){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
