import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyNodeTest {
    EmptyNode node;

    @Before
    public void setUp() throws Exception {
        // create a new EmptyNode
        node = new EmptyNode();
    }

    @Test
    public void countLetters() {
        // check the letter in an EmptyNode is 0
        assertEquals(0, node.countLetters());
    }

    @Test
    public void getString() {
        // check the string of an EmptyNode is ""
        assertEquals("", node.getString());
    }

    @Test
    public void getNext() {
        // check the next node of an EmptyNode is null
        assertEquals(null, node.getNext());
    }

    @Test
    // check an EmptyNode is not a WordNode
    public void isWord() {
        assertFalse(node.isWord());
    }

    @Test
    public void addBack() throws IllegalArgumentException{
        // check no node can be add after an EmptyNode
        WordNode node1 = new WordNode("Hello");
        try {
            node.addBack(node1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void cloneNode() {
        // check the cloned node is an EmptyNode
        IListNode node1 = node.cloneNode();
        assertEquals(node1.getString(), node.getString());
    }
}