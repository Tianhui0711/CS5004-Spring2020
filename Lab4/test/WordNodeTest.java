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
        assertEquals(7, word1.countLetters());
    }

    @Test
    public void getString() {
        assertEquals("evening", word1.getString());
    }

    @Test
    public void getNext() {
        assertTrue(word1.equals(word2.getNext()));
    }

    @Test
    public void isWord() {
        assertTrue(word1.isWord());
    }

    @Test
    public void addBack() {
        IListNode word3 = new WordNode("everyone");
        word1.addBack(word3);
        assertTrue(word3.equals(word1.getNext()));
    }

    @Test
    public void cloneNode() {
        IListNode word3 = word1.cloneNode();
        assertTrue(word3.equals(word1));
    }
}