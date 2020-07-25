import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTest {

    @Test
    public void testLowerCaseGreeting() {

        String result = new Greet().greet("Bob");
        assertEquals("Hello, Bob.", result);
    }

    @Test
    public void testNullGreeting() {

        String result = new Greet().greet(null);
        assertEquals("Hello, my friend.", result);
    }

    @Test
    public void testUpperCaseGreeting() {

        String result = new Greet().greet("BOB");
        assertEquals("HELLO BOB!", result);
    }

    @Test
    public void testLowerCaseMultipleGreetings() {

        String result = new Greet().greet("Mehdi", "Wadeed", "Rafay");
        assertEquals("Hello, Mehdi, Wadeed and Rafay.", result);
    }

    @Test
    public void testMixCasesMultipleGreetings() {

        String result = new Greet().greet("Mehdi", "Wadeed", "RAFAY");
        assertEquals("Hello, Mehdi and Wadeed. AND HELLO RAFAY!", result);
    }

    @Test
    public void testCommaValuesGreetings() {

        String result = new Greet().greet("Mehdi, Wadeed", "Rafay");
        assertEquals("Hello, Mehdi, Wadeed and Rafay.", result);
    }
}
