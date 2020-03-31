/**
 * OOD bonus: Extract the common field of different types of nodes
 * @param <T> the node type for the left and right node
 */

public class Node<T> {
    protected T left;   // the left node
    protected T right;  // the right node

    public Node() {
        this.left = null;
        this.right = null;
    }
}
