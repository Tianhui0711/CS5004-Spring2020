import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyNodeTest {
    EmptyNode node;

    @Before
    public void setUp() throws Exception {
        node = new EmptyNode();
    }

    @Test
    public void countLetters() {
        assertEquals(0, node.countLetters());
    }

    @Test
    public void getString() {
        assertEquals("", node.getString());
    }

    @Test
    public void getNext() {
        assertEquals(null,node.getNext());
    }

    @Test
    public void isWord() {
        assertFalse(node.isWord());
    }

    @Test
    public void addBack() {
        WordNode node1 = new WordNode("Hello");
        try {
            node.addBack(node1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void cloneNode() {
        IListNode node1 = node.cloneNode();
        assertTrue(node.equals(node1));
    }
}