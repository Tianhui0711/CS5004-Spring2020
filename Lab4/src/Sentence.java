import java.util.Objects;

/**
 * Build a class Sentence describe the linked list of nodes
 */
public class Sentence {
    private IListNode head;

    /**
     * Construct a Sentence
     * The head of the Sentence is defaulted as null
     */
    private Sentence() {
        this.head = null;
    }

    /**
     * Overload the constructor
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
     */
    public String longestWord() {
        int longest = 0;
        String word = "";
        IListNode p = head;
        while (p.getNext() != null) {
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
        while (p.getNext() != null) {
            p = p.getNext();
            if (p.isWord()) {
                result += " " + p.getString();
            } else {
                result += p.getString();
            }
        }
        char last = result.charAt(result.length()-1);
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
        Sentence cloneS = new Sentence(p1.cloneNode());
        IListNode p2 = cloneS.head;
        while (p1.getNext() != null) {
            p1 = p1.getNext();
            p2.addBack(p1.cloneNode());
            p2 = p2.getNext();
        }
        return cloneS;
    }

    /**
     * Merge two sentences into a single sentence
     * the original lists will not be unchanged
     * @param other the other sentence need to be merged
     * @return the merged new sentence
     */
    public Sentence merge(Sentence other) {
        Sentence mergeS = new Sentence(head);
        Sentence mergeS2 = new Sentence(other.head);
        IListNode p = mergeS.head;
        IListNode p2 = mergeS2.head;
        while (p.getNext().getString() != "") {
            p = p.getNext();
        }
        p.addBack(p2);
        return mergeS;
    }

    /**
     * Compare two sentence, check if they are the same
     * @param o the other sentence
     * @return true if they are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence other = (Sentence) o;
        IListNode p1 = this.head;
        IListNode p2 = other.head;
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
