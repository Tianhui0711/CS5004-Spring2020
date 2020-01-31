import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Person person;
    private Book book;
    private Book book2;

    @Before
    public void setUp() throws Exception {
        // Prints "Hello, World" to the terminal window.
        //System.out.println("Hello, World");
        person = new Person("Tianhui", "Li");
        book = new Book("A book", person, 5.20);
        book2 = new Book("Second book", person, 10);

        // terrible discount
        try {
            double newPrice2 = book2.salePrice(-15);
            System.out.println(newPrice2);
        } catch (IllegalArgumentException e) {
            // you can do something to handle the error here...
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void getAuthor() {
        Person author = new Person("Tianhui", "Li");
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void testToString() {
        String res = "Title: ";
        res = res + "A book" + "\n";
        res = res + "Author: ";
        res = res + "Tianhui Li" + "\n";
        res = res + "Price: ";
        res = res + 5.20;
        assertEquals(res, book.toString());
    }

    @Test
    public void salePrice() {
        assertEquals(4.68, book.salePrice(10),0);

        try {
            double newPrice2 = book2.salePrice(-15);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    @Test
    public void sameAuthor() {
        assertEquals(true, book.sameAuthor(book2));
    }

    @Test
    public void createSequel() {
        Book book3 = new Book("A book II", person, 10.40);
        assertEquals(book3, book.createSequel());
    }
}