/**
 * Implement a sorting program using binary tree
 */

import java.util.Arrays;

class BTSort // starter code
{
    // Construct a node
    class Node
    {
        int val;
        Node left, right;

        public Node(int item)
        {
	    // what here?
            this.val = item;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // Constructor
    BTSort()
    {
        root = null;
    }

    /**
     * Insert a new value to the sorting tree
     * @param val the inserted value
     */
    void insert(int val)
    {
        root = insertRec(root, val);
    }

    /**
     * A helper function to help insert val recursively
     * @param root the node which should be inserted to
     * @param val the value
     * @return the node
     */
    Node insertRec(Node root, int val)
    {
        if (root == null)
        {
            root = new Node(val);
            return root;
        }

        if (val < root.val) {
	    // what here?
            root.left = insertRec(root.left, val);
	    // what other cases?
	    } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    /**
     * Print the ordered array
     * @param root the root node
     */
    void printInOrderRec(Node root)
    {
        if (root != null)
        {
            // what here?
            printInOrderRec(root.left);
            System.out.print(root.val + " ");
            // what here?
            printInOrderRec(root.right);
        }
    }

    /**
     * Create an iterator to insert every value in the array
     * @param arr the original array
     */
    void bTreeIns(int[] arr)
    {
        for (int value : arr) {
            insert(value);
        }
    }

    // main method to test on 1-2 examples
    public static void main(String[] args)
    {
        BTSort tree = new BTSort();
	    // what here?
        // test 1
        int[] arr1 = new int[]{3,2,1,4,7,6};
        tree.bTreeIns(arr1);
        System.out.print("The inserted array is: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("The array printed in order: ");
        tree.printInOrderRec(tree.root);

        System.out.println();
        System.out.println();

        // test 2: keep insert new values to the tree
        int[] arr2 = new int[]{0,10,24,30,5};
        tree.bTreeIns(arr2);
        System.out.print("The inserted array is: ");
        System.out.println(Arrays.toString(arr2));
        System.out.print("The array printed in order: ");
        tree.printInOrderRec(tree.root);
    }
}
