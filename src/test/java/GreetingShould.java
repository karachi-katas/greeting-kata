import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void greetBob() {
        String name = "Bob";

        String greeting = new Greeting().greet(name);

        assertEquals("Hello, Bob.", greeting);
    }

    @Test
    public void greetAmir() {
        String greeting = new Greeting().greet("Amir");

        assertEquals("Hello, Amir.", greeting);
    }

    @Test
    public void greetJazib() {
        String greeting = new Greeting().greet("Jazib");

        assertEquals("Hello, Jazib.", greeting);
    }

    @Test
    public void greetGuest() {
        String greeting = new Greeting().greet(null);

        assertEquals("Hello, my friend.", greeting);
    }

}
