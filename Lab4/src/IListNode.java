/**
 * Interface describing the internal nodes of a {@link Sentence}
 */
public interface IListNode {

    /**
     * Find and return the number of letters in this node.
     * @return the number of letters as described above
     */
    int countLetters();

    /**
     * Stringify this node.
     * @return the string form of the node
     */
    String getString();

    /**
     * Get the next node;
     * @return the next node;
     */
    IListNode getNext();

    /**
     * Check if the node is a WordNode
     * @return true if the node is a WordNode, false otherwise
     */
    boolean isWord();

    /**
     * Add a new node to this node
     * @param node this node
     */
    void addBack(IListNode node);

    /**
     * Only clone the string of the node, the next node is set to null
     * @return the copy of this node
     */
    IListNode cloneNode();

    /**
     * Check if the two node are the same;
     * @param o the other node
     * @return true if they are the same, false other wise
     */
    boolean equals(Object o);
}
