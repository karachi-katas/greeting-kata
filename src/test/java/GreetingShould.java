import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

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
        String greeting = new Greeting().to((null));
        assertEquals("Hello, my friend.", greeting);
    }

    @Test
    public void shout() {
        String greeting = new Greeting().to("JERRY");
        assertEquals("HELLO JERRY!", greeting);
    }

    @Test
    public void greetTwoNames() {
        String greeting = new Greeting().to(new String[]{"Jill", "Jane"});
        assertEquals("Hello, Jill and Jane.", greeting);
    }
}
