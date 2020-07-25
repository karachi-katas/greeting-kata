import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooTest {

    @Test
    public void greetBob() {
        String greeting = new Greeting().to("Bob");
        assertEquals("Hello, Bob.", greeting);
    }
    @Test
    public void greetAhil() {
        String greeting = new Greeting().to("Ahil");
        assertEquals("Hello, Ahil.", greeting);
    }
    @Test
    public void greetNull() {
        String greeting = new Greeting().to(null);
        assertEquals("Hello, my friend.", greeting);
    }
}
