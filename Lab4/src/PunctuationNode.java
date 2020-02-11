import java.util.Objects;

/**
 * Create an punctuation node for the linked list
 * It represents the punctuation marks in the sentence
 */
public class PunctuationNode implements IListNode {
    public String punc;
    public IListNode next;

    /**
     * Construct a PunctuationNode when it is at the end of a Sentence
     */
    public PunctuationNode(String punc) {
        this.punc = punc;
        this.next = new EmptyNode();
    }

    /**
     * Overload the constructor
     * If the PunctuationNode is not at the end of a Sentence
     * @param punc the punctuation mark
     * @param next the next IListNode
     */
    public PunctuationNode(String punc, IListNode next) {
        this.punc = punc;
        this.next = next;
    }

    /**
     * Count the number of punctuation mark
     * @return the number of punctuation mark
     */
    public int countLetters() {
        return punc.length();
    }

    /**
     * Get the string of the punctuation mark
     * @return the string of the punctuation mark
     */
    public String getString() {
        return punc;
    }

    /**
     * Get the next node of this PunctuationNode
     * @return the next node
     */
    public IListNode getNext() {
        return next;
    }

    /**
     * Check the PunctuationNode is not a WordNode
     * @return false
     */
    public boolean isWord() {
        return false;
    }

    /**
     * Add a node next to the PunctuationNode
     * @param node this node
     */
    public void addBack(IListNode node) {
        this.next = node;
    }

    /**
     * Only copy the string of the node
     * The next node is set to null, which makes it easy to add the next node
     * @return a new PunctuationNode which copies the punctuation mark of the original PunctuationNode
     */
    public IListNode cloneNode() {
        return new PunctuationNode(this.punc);
    }
}
