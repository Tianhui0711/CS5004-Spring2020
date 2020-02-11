import java.util.Objects;

/**
 * Build a class Sentence describe the linked list of nodes
 */
public class Sentence {
    private IListNode head;

    /**
     * Construct a empty Sentence
     */
    public Sentence() {
        this.head = new EmptyNode();
    }

    /**
     * Overload the constructor when the head is provided
     * @param head the head of the Sentence
     */
    public Sentence(IListNode head) {
        this.head = head;
    }

    /**
     * Computes and returns the number of words in a sentence
     * The punctuation does not count as a word
     * @return the number of words in a sentence
     */
    public int getNumberOfWords() {
        int sum = 0;
        IListNode p = head;
        while (p.getNext() != null) {
            // if the node is a WordNode, it will be counted.
            if (p.isWord()) {
                sum ++;
            }
            p = p.getNext();
        }
        return sum;
    }

    /**
     * Determines and returns the longest word in a sentence
     * @return the string of the longest word in a sentence
     *          if the sentence contains no words
     *          it will return an empty string.
     */
    public String longestWord() {
        int longest = 0;
        String word = "";
        IListNode p = head;
        while (p.getNext() != null) {
            // if the node is a WordNode, its length will be compared
            if (p.isWord()) {
                if (p.countLetters() > longest) {
                    longest = p.countLetters();
                    word = p.getString();
                }
            }
            p = p.getNext();
        }
        return word;
    }

    /**
     * Convert the sentence into one string
     * If there is no punctuation mark at the end of the sentence,
     * this string should end with a period
     * @return the string describing the sentence
     */
    public String toString() {
        IListNode p = head;
        String result = p.getString();
        // this loop counties until the node is an EmptyNode
        // add all words and punctuation marks to the string of sentence
        while (p.getNext() != null) {
            p = p.getNext();
            if (p.isWord()) {
                result += " " + p.getString();
            } else {
                result += p.getString();
            }
        }
        // find the last character of the string which just got
        char last = result.charAt(result.length()-1);
        // if the last character is a letter, add a period to the string of sentence
        if (Character.isLetter(last)) {
            result += ".";
        }
        return result;
    }

    /**
     * Returns a duplicate of a given sentence, independent of the original list
     * @return a duplicate of a given sentence
     */
    public Sentence clone() {
        IListNode p1 = this.head;
        // create a new Sentence
        Sentence cloneS = new Sentence(p1.cloneNode());
        IListNode p2 = cloneS.head;
        while (p1.getNext() != null) {
            p1 = p1.getNext();
            // clone nodes from the original sentence
            // keep adding cloned nodes to the new Sentence
            p2.addBack(p1.cloneNode());
            p2 = p2.getNext();
        }
        return cloneS;
    }

    /**
     * Merge two sentences into a single sentence
     * the original lists will be unchanged
     * @param other the other sentence need to be merged
     * @return the merged new sentence
     */
    public Sentence merge(Sentence other) {
        // create a new Sentence
        Sentence mergeS = this.clone();
        Sentence mergeS2 = other.clone();
        // if this Sentence is empty, then the merged sentence is the other Sentence
        if (mergeS.head.getString() == "") {
            return mergeS2;
        }
        IListNode p = mergeS.head;
        // Move the node to second last node(the node before the last EmptyNode)
        while (p.getNext().getString() != "") {
            p = p.getNext();
        }
        // link the second last node to the head of the other Sentence
        p.addBack(mergeS2.head);
        return mergeS;
    }
}
