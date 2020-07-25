import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTest {

    @Test
    public void testGreeting() {

        String result = new Greet().greet("Bob");
        assertEquals("Hello, Bob.", result);
    }

}
