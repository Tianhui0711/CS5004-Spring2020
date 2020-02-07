import java.util.Objects;

/**
 * Create an empty node for the linked list
 * It represents the end of the sentence
 */
public class EmptyNode implements IListNode{
    private String word;
    private IListNode next;

    /**
     * Construct an EmptyNode
     */
    public EmptyNode() {
        this.word = "";
        this.next = null;
    }

    /**
     * Count the letters in the node
     * @return 0, there is no letter in an empty list
     */
    public int countLetters() {
        return 0;
    }

    /**
     * Get the String of an EmptyNode
     * @return "", there is no string in an EmptyNode
     */
    public String getString() {
        return "";
    }

    /**
     * Get the next node of an EmptyNode
     * @return null, an EmptyNode does not have a next node
     */
    public IListNode getNext() {
        return null;
    }

    /**
     * Check the EmptyNode is not a WordNode
     * @return false, the EmptyNode is not a WordNode
     */
    public boolean isWord() {
        return false;
    }

    /**
     * Check that no node can be added to the EmptyNode
     * @param node this node
     * @throws IllegalArgumentException
     */
    public void addBack(IListNode node) throws IllegalArgumentException{
        throw new IllegalArgumentException("This node is the EmptyNode." +
                " No node can be added after it");
    }

    /**
     * Only clone the string of the node, the next node is set to null
     * @return the copy of this node
     */
    public IListNode cloneNode() {
        return new EmptyNode();
    }

    /**
     * Check if the two node are the same;
     * @param o the other node
     * @return true if they are the same, false other wise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmptyNode other = (EmptyNode) o;
        return this.getString() == other.getString() && this.next == other.next;
    }
}
