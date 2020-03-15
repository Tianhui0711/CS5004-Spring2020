/**
 * Optional part:
 * 1. Use Generics to implement BTSort
 * 2. Add a new method which returns a sorted copy of the array
 */

import java.util.ArrayList;

public class BTSort_Generics<T extends Comparable> {
    private class Node<T extends Comparable>
    {
        T val;
        Node left, right;

        public Node(T item)
        {
            this.val = item;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * Constructor
     */
    public BTSort_Generics() {
        root = null;
    }

    /**
     * Insert a new value to the sorting tree
     * @param val the inserted value
     */
    public void insert(T val) {
        root = insertRec(root, val);
    }

    /**
     * A helper function to help insert val in order
     * @param root the node which should be inserted
     * @param val the value
     * @return the node
     */
    public Node insertRec(Node root, T val) {
        if (root == null)
        {
            root = new Node<T>(val);
            return root;
        }

        // use compareTo() method to compare generics
        if (val.compareTo(root.val) < 0) {
            root.left = insertRec(root.left, val);
        } else if (val.compareTo(root.val) > 0) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    /**
     * Print the ordered array
     * @param root the root node
     */
    public void printInOrderRec(Node root) {
        if (root != null)
        {
            printInOrderRec(root.left);
            System.out.print(root.val.toString() + " ");
            printInOrderRec(root.right);
        }
    }

    /**
     * Return a sorted array
     * @return the sorted array
     */
    public ArrayList sortedArray() {
        ArrayList sortedArray = new ArrayList<>();
        arrayHelper(root, sortedArray);
        return sortedArray;
    }

    /**
     * A helper method to help add new Object to the ArrayList
     * @param root the root node
     * @param array the new array
     * @return the sorted array
     */
    private ArrayList arrayHelper(Node root, ArrayList array) {
        if (root != null) {
            arrayHelper(root.left, array);
            array.add(root.val);
            arrayHelper(root.right, array);
        }
        return array;
    }

    /**
     * Create an iterator to insert every value in the array
     * @param arr the original array
     */
    public void bTreeIns(T[] arr)
    {
        for (T value : arr) {
            insert(value);
        }
    }

    // main method to test on 1-2 examples
    // only test the new method which returns a new sorted array
    public static void main(String[] args)
    {
        //test 1: Use Array of Integer
        BTSort_Generics tree = new BTSort_Generics();
        Integer[] arr1 = new Integer[]{3,2,1,4,7,6};
        tree.bTreeIns(arr1);
        ArrayList sortedArray = tree.sortedArray();

        System.out.print("The sorted array is: ");
        System.out.println(sortedArray.toString());

        System.out.println();

        //test 2: Use Array of String
        BTSort_Generics tree2 = new BTSort_Generics();
        String[] arr2 = new String[]{"cat", "apple", "bed", "orange"};
        tree2.bTreeIns(arr2);

        // Strings are in lexicographical order
        sortedArray = tree2.sortedArray();
        System.out.print("The sorted array is: ");
        System.out.println(sortedArray.toString());
    }
}
