import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PunctuationNodeTest {
    PunctuationNode node1;
    PunctuationNode node2;

    @Before
    public void setUp() throws Exception {
        node1 = new PunctuationNode("!");
        node2 = new PunctuationNode("?",node1);
    }

    @Test
    public void countLetters() {
        assertEquals(1, node1.countLetters());
    }

    @Test
    public void getString() {
        assertEquals("!", node1.getString());
    }

    @Test
    public void getNext() {
        assertEquals(node1, node2.getNext());
    }

    @Test
    public void isWord() {
        assertFalse(node1.isWord());
    }

    @Test
    public void addBack() {
        IListNode node3 = new PunctuationNode(".");
        node1.addBack(node3);
        assertTrue(node3.equals(node1.getNext()));
    }

    @Test
    public void cloneNode() {
        IListNode node3 = node1.cloneNode();
        node1.equals(node3);
    }
}