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
     * If the WordNode is not at the end of a Sentence
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
     * Only copy the string of the node
     * The next node is set to null, which makes it easy to add the next node
     * @return a new WordNode which copies the string of the original WordNode
     */
    public IListNode cloneNode() {
        return new WordNode(this.word);
    }
}
