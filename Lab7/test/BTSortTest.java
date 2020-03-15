/**
 * JUnit test for the BTSort_starter
 */

// I also complete the main() method, but I think it is easier to implement than JUnit test for this project
// Because the void printInOrderRec() method makes it hard to assert the expected value of each unit
// And since some of the methods are implemented and combined in a recursive way,
// it is kind of weired to test them separately

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BTSortTest {
    BTSort tree;

    @Before
    public void setUp() throws Exception {
        // construct a new binary tree
        tree = new BTSort();
    }

    @Test
    public void insert() {
        tree.insert(1);
        // the insert() method is void, cannot use assert() method to test directly
        // check 1 has been inserted to the root
        assertEquals(1, tree.root.val);
    }

    @Test
    public void insertRec() {
        tree.root = tree.insertRec(tree.root, 2);
        tree.insertRec(tree.root, 1);
        tree.insertRec(tree.root, 3);
        // check each value has been inserted properly
        // should print: 1 2 3
        tree.printInOrderRec(tree.root);
    }

    @Test
    public void printInOrderRec() {
        // void method cannot use assertEqual() to test
        int[] arr1 = new int[]{3,2,1,4,7,6};
        tree.bTreeIns(arr1);
        // check the array is printed in order
        // should print: 1 2 3 4 6 7
        tree.printInOrderRec(tree.root);
    }

    @Test
    public void bTreeIns() {
        int[] arr1 = new int[]{3,2,1,4,7,6};
        tree.bTreeIns(arr1);
        // check all the elements in the array have been inserted
        // should print: 1 2 3 4 6 7
        tree.printInOrderRec(tree.root);
    }
}