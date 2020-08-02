import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void greetNormalName() {
        String actual = new Greeting().to("Bob");
        assertEquals("Hello, Bob.", actual);
    }

    @Test
    public void greetAnotherNormalName() {
        String actual = new Greeting().to("Alice");
        assertEquals("Hello, Alice.", actual);
    }

    @Test
    public void greetGuest() {
        String actual = new Greeting().to(null);
        assertEquals("Hello, my friend.", actual);
    }

}
