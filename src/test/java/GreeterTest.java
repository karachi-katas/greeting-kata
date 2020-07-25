import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterTest {

    @Test
    public void greetShaheer() {
        String greeting = new Greeter().greet("Shaheer");
        assertEquals("Hello, Shaheer.", greeting);
    }

    @Test
    public void greetAmar() {
        String greeting = new Greeter().greet("Amar");
        assertEquals("Hello, Amar.", greeting);
    }



}
