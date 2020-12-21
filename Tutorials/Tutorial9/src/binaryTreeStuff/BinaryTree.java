package binaryTreeStuff;

import java.util.ArrayList;

public class BinaryTree {
    private String data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    // A constructor that makes a Sentinel node
    public BinaryTree() {
        data = null;
        leftChild = null;
        rightChild = null;
    }

    // This constructor now uses sentinels for terminators instead of null
    public BinaryTree(String d) {
        data = d;
        leftChild = new BinaryTree();
        rightChild = new BinaryTree();
    }

    // This constructor is unchanged
    public BinaryTree(String d, BinaryTree left, BinaryTree right) {
        data = d;
        leftChild = left;
        rightChild = right;
    }

    // Get methods
    public String getData() {
        return data;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    // Set methods
    public void setData(String d) {
        data = d;
    }

    public void setLeftChild(BinaryTree left) {
        leftChild = left;
    }

    public void setRightChild(BinaryTree right) {
        rightChild = right;
    }

    // Return a list of all data within the leaves of the tree
    public ArrayList<String> leafData() {
        ArrayList<String> result = new ArrayList<String>();

        if (data != null) {
            if ((leftChild.data == null) && (rightChild.data == null))
                result.add(data);
            result.addAll(leftChild.leafData());
            result.addAll(rightChild.leafData());
        }
        return result;
    }

    // Determines the height of the tree, which is the number of branches
    // in the path from the root to the deepest leaf.
    public int height() {
        // Check if this is a sentinel node
        if (data == null)
            return 0;

        return 1 + Math.max(leftChild.height(),
                rightChild.height());
    }

    public boolean isTheSameAs(BinaryTree t) {
        return isTheSameAs(this, t);
    }

    public boolean isTheSameAs(BinaryTree c1, BinaryTree c2){
        if (c1.data == null && c2.data == null) return true;
        if (c1.data == null || c2.data == null) return false;
        if (c1.data != c2.data) return false;
        return isTheSameAs(c1.leftChild, c2.leftChild) && isTheSameAs(c1.rightChild, c2.rightChild);
    }

    public boolean contains(String d) {
        return contains(d, this);
    }

    public boolean contains(String d, BinaryTree child){
        if (child.data == null) return false;
        if (child.data.equals(d)) return true;
        return contains(d, child.leftChild) || contains(d, child.rightChild);
    }
}
