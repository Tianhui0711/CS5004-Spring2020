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
        // check the letter in node1 is 1
        assertEquals(1, node1.countLetters());
    }

    @Test
    public void getString() {
        // check the string of node1 is "!"
        assertEquals("!", node1.getString());
    }

    @Test
    public void getNext() {
        // check node1 is the next node of node2
        assertEquals(node1, node2.getNext());
    }

    @Test
    public void isWord() {
        // check node1 is not a WordNode
        assertFalse(node1.isWord());
    }

    @Test
    public void addBack() {
        IListNode node3 = new PunctuationNode(".");
        node1.addBack(node3);
        // check node3 is added to node1 successfully
        assertTrue(node3.equals(node1.getNext()));
    }

    @Test
    public void cloneNode() {
        IListNode node3 = node1.cloneNode();
        // check the cloned node3 is the same as node1
        assertEquals(node3.getString(), node1.getString());
    }
}