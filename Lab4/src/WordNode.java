import java.util.Objects;

/**
 * Create an word node for the linked list
 * It represents the words in the sentence
 */
public class WordNode implements IListNode {
    public String word;
    public IListNode next;

    /**
     * Construct a WordNode when it is at the end of a Sentence
     * @param word the string of the word
     */
    public WordNode(String word) {
        this.word = word;
        this.next = new EmptyNode();
    }

    /**
     * Overload the constructor
     * when the WordNode is not at the end of a Sentence
     * @param word the string of the word
     * @param next the next node
     */
    public WordNode(String word, IListNode next) {
        this.word = word;
        this.next = next;
    }

    /**
     * Count the letters in the word
     * @return the number of letters in the word
     */
    public int countLetters() {
        return word.length();
    }

    /**
     * Get the string of the word
     * @return the string of the word
     */
    public String getString() {
        return word;
    }

    /**
     * Get the next node
     * @return the next IListNode
     */
    public IListNode getNext() {
        return next;
    }

    /**
     * Check the node is a WordNode
     * @return true
     */
    public boolean isWord() {
        return true;
    }

    /**
     * Add a new node to this node
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
        return new WordNode(this.word);
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
        WordNode other = (WordNode) o;
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
