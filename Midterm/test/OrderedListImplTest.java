import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class OrderedListImplTest {
    OrderedListImpl list;
    Node node1;
    Node node2;

    @Before
    public void setUp() throws Exception {
        node1 = new Node(1);
        node1.addNext(new Node(2));
        node1.getNext().addNext(new Node(3));
        list = new OrderedListImpl(node1, 4);
    }

    @Test
    public void getMin() {
        assertEquals(1, list.getMin());
    }

    @Test
    public void getMax() {
        assertEquals(3, list.getMax());
    }

    @Test
    public void getMedian() {
        list.getMedian();
        assertEquals(2, list.getMedian(), 0);

        list.add(4);
        assertEquals(2.5, list.getMedian(), 0);
    }

    @Test
    public void add() {
        list.add(4);
        assertEquals("[1 2 3 4]", list.toString());

        list.add(1);
        assertEquals("[1 2 3 4]", list.toString());

        list.add(5);
        assertEquals("[2 3 4 5]", list.toString());

        list.add(5);
        assertEquals("[3 4 5 5]", list.toString());
    }

    @Test
    public void merge() {
        node2 = new Node(4);
        node2.addNext(new Node(5));
        node2.getNext().addNext(new Node(6));
        OrderedListImpl list2 = new OrderedListImpl(node2, 4);
        list2.merge(list);
        assertEquals("[1 2 3 4 5 6 ??]", list2.merge(list).toString());
    }

    @Test
    public void remove() {
        list.remove(3);
        assertEquals("[1 2 ??]", list.toString());
    }

    @Test
    public void removeAll() {
        list.removeAll(2);
        assertEquals("[1 ???]", list.toString());

        list.removeAll(1);
        assertEquals("[????]", list.toString());
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
        assertTrue(new OrderedListImpl(null, 0).isEmpty());
    }

    @Test
    public void size() {
        assertEquals(3, list.size());
    }

    @Test
    public void testToString() {
        assertEquals("[1 2 3 ?]", list.toString());
        list.removeAll(1);
        assertEquals("[????]", list.toString());
    }

    @Test
    public void testEquals() {
        node2 = new Node(1);
        node2.addNext(new Node(2));
        node2.getNext().addNext(new Node(3));
        OrderedListImpl list2 = new OrderedListImpl(node2, 4);
        assertEquals(list, list2);
    }
}