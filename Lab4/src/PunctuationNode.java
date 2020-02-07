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
     * when the PunctuationNode is not at the end of a Sentence
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
     * Only clone the string of the node, the next node is set to null
     * @return the copy of this node
     */
    public IListNode cloneNode() {
        return new PunctuationNode(this.punc);
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
        PunctuationNode other = (PunctuationNode) o;
        IListNode p1 = this;
        IListNode p2 = other;
        while (p1.getNext() != null) {
            if (p1.getString() != p2.getString()) {
                return false;
            }
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return true;
    }
}
