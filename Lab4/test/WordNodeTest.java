import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordNodeTest {
    WordNode word1;
    WordNode word2;

    @Before
    public void setUp() throws Exception {
        word1 = new WordNode("evening");
        word2 = new WordNode("good", word1);
    }

    @Test
    public void countLetters() {
        // check the letters in word1 is 7
        assertEquals(7, word1.countLetters());
    }

    @Test
    public void getString() {
        // check the string of word1 is "evening"
        assertEquals("evening", word1.getString());
    }

    @Test
    public void getNext() {
        // check the next node of word1 is word2
        assertTrue(word1.equals(word2.getNext()));
    }

    @Test
    public void isWord() {
        // check word1 is a WordNode
        assertTrue(word1.isWord());
    }

    @Test
    public void addBack() {
        IListNode word3 = new WordNode("everyone");
        word1.addBack(word3);
        // check word3 is been add to word1 successfully
        assertTrue(word3.equals(word1.getNext()));
    }

    @Test
    public void cloneNode() {
        IListNode word3 = word1.cloneNode();
        // check the cloned word3 is the same as word1
        assertEquals(word3.getString(), word1.getString());
    }
}