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

    @Test
    public void greetFriendWhenNull() {
        String name = null;
        String greeting = new Greeter().greet(name);
        assertEquals("Hello, my friend.", greeting);
    }

    @Test
    public void greetWhenUpper() {
        String greeting = new Greeter().greet("JERRY");
        assertEquals("HELLO, JERRY!", greeting);
    }

    @Test
    public void greenWhenMultipleNamesAmyAndBrian() {
        String greeting = new Greeter().greet(new String[]{"Amy", "Brian"});
        assertEquals("Hello, Amy and Brian.", greeting);
    }

    @Test
    public void greenWhenMultipleNamesBobAndCharlie() {
        String greeting = new Greeter().greet(new String[]{"Bob", "Charlie"});
        assertEquals("Hello, Bob and Charlie.", greeting);
    }

}
