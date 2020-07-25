import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void greetBob() {
        String name = "Bob";

        String greeting = new Greeting().greet(name);

        assertEquals("Hello, Bob.", greeting);
    }

}
