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
     * Return the same new EmptyNode
     * @return a new EmptyNode
     */
    public IListNode cloneNode() {
        return new EmptyNode();
    }
}
