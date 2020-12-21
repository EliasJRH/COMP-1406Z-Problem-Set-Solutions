//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface

import java.util.ArrayList;

public class TrieMap implements TrieMapInterface {
    TrieMapNode root;

    public TrieMap() {
        root = new TrieMapNode();
    }

    //Indirectly recursive method to meet definition of interface
    public void put(String key, String value) {
        put(root, key, value);
    }

    //Recursive method
    //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
    public void put(TrieMapNode current, String curKey, String value) {
        TrieMapNode nextNode = null;
        if (!current.getChildren().containsKey(curKey.charAt(0))) {
            nextNode = new TrieMapNode();
            current.getChildren().put(curKey.charAt(0), nextNode);
        }else{
            nextNode = current.getChildren().get(curKey.charAt(0));
        }
        curKey = curKey.substring(1);
        if (curKey.length() == 0){
            nextNode.setValue(value);
            return;
        }else{
            put(nextNode, curKey, value);
        }
    }

    //Indirectly recursive method to meet definition of interface
    public String get(String key) {
        return get(root, key);
    }

    //Recursive method
    //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
    public String get(TrieMapNode current, String curKey) {
        if (curKey.length() == 0) return current.getValue();
        if (current.getChildren().containsKey(curKey.charAt(0))) return get(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
        return "";
    }

    //Indirectly recursive method to meet definition of interface
    public boolean containsKey(String key) {
        return containsKey(root, key);
    }

    //Recursive method
    //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
    public boolean containsKey(TrieMapNode current, String curKey) {
        if (curKey.length() == 0) return true;
        if (current.getChildren().containsKey(curKey.charAt(0))) return containsKey(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
        return false;
    }

    //Indirectly recursive method to meet definition of interface
    public ArrayList<String> getKeysForPrefix(String prefix) {
        TrieMapNode startingNode = findNode(root, prefix);
        if (startingNode == null) return new ArrayList<String>();
        return getSubtreeKeys(startingNode);
    }

    //Recursive helper function to find node that matches a prefix
    //Note: only a suggestion, you may solve the problem is any recursive manner
    public TrieMapNode findNode(TrieMapNode current, String curKey) {
        if (curKey.length() == 0) return current;
        if (current.getChildren().containsKey(curKey.charAt(0))) return findNode(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
        return null;
    }

    //Recursive helper function to get all keys in a node's subtree
    //Note: only a suggestion, you may solve the problem is any recursive manner
    public ArrayList<String> getSubtreeKeys(TrieMapNode current) {
        ArrayList<String> listToReturn = new ArrayList<>();
        if (current.getValue() != null) listToReturn.add(current.getValue());
        for (char c: current.getChildren().keySet()){
            listToReturn.addAll(getSubtreeKeys(current.getChildren().get(c)));
        }
        return listToReturn;
    }

    //Indirectly recursive method to meet definition of interface
    public void print() {
        print(root);
    }

    //Recursive method to print values in tree
    public void print(TrieMapNode current) {
        if (current.getValue() != null) System.out.println(current.getValue());
        for (char c: current.getChildren().keySet()){
            print(current.getChildren().get(c));
        }
    }

    public static void main(String[] args) {
        TrieMap testing = new TrieMap();
        testing.put("APPLE", "APPLE");
        testing.print();
        System.out.println(testing.containsKey("APPLE"));
        System.out.println(testing.get("APPLE"));
        System.out.println(testing.getKeysForPrefix("AP"));
    }
}