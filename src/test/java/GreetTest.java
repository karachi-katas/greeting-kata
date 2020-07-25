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

}
