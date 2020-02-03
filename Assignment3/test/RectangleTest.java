import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private Rectangle rect4;

    @Before
    public void setUp() throws IllegalArgumentException {
        // construct four rectangles
        rect1 = new Rectangle(0,0,4,4);
        rect2 = new Rectangle(1,1,2,2);

        rect3 = new Rectangle(-2,2,4,4);
        rect4 = new Rectangle(2,2,4,4);

        // construct a rectangle whose width is non-positive
        try {
            Rectangle rect = new Rectangle(0,0,-1,1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void overlap() {
        // check if the two rectangles overlap with each other
        // change the position of two rectangles to test several kinds of overlap
        assertTrue(rect1.overlap(rect2));
        assertTrue(rect2.overlap(rect1));

        assertTrue(rect1.overlap(rect3));
        assertTrue(rect3.overlap(rect1));

        assertTrue(rect1.overlap(rect4));
        assertTrue(rect4.overlap(rect1));

        // check if the two rectangles do not overlap with each other
        assertFalse(rect3.overlap(rect4));
    }

    @Test
    public void intersect() {
        // check the intersection of rect1 and rect2 (rect2 is inside rect1)
        Rectangle intersect1 = new Rectangle(1,1,2,2);
        assertEquals(intersect1, rect1.intersect(rect2));

        // check the intersection of rect1 and rect4 (general overlap)
        Rectangle intersect2 = new Rectangle(2,2,2,2);
        assertEquals(intersect2, rect1.intersect(rect4));

        // check if there if no intersection of two rectangles (no overlap)
        try {
            rect3.intersect(rect4);
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void union() {
        // check the union of rect1 and rect2 (rect2 is inside rect1)
        Rectangle union1 = new Rectangle(0,0,4,4);
        assertEquals(union1, rect1.union(rect2));

        // check the union of rect1 and rect3 (general overlap)
        Rectangle union2 = new Rectangle(-2,0,6,6);
        assertEquals(union2, rect1.union(rect3));

        // check the union of rect3 and rect4 (no overlap)
        Rectangle union3 = new Rectangle(-2,2,8,4);
        assertEquals(union3, rect3.union(rect4));
    }

    @Test
    public void testToString() {
        // check the description string of the rectangle
        String str = "x:0, y:0, w:4, h:4";
        assertEquals(str, rect1.toString());
    }
}