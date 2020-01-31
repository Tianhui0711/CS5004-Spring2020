import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person1;

    @Before
    public void setUp() throws Exception {
        person1 = new Person("Tianhui", "Li");
    }

    @Test
    public void testToString() {
        assertEquals("Tianhui Li", person1.toString());
    }

    @Test
    public void getFirstName() {
        assertEquals("Tianhui", person1.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Li", person1.getLastName());
    }
}