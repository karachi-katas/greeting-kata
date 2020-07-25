import org.junit.Test;

import java.util.Arrays;

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
    public void greetWhenTwoNamesAmyAndBrian() {
        String greeting = new Greeter().greet(Arrays.asList("Amy", "Brian"));
        assertEquals("Hello, Amy and Brian.", greeting);
    }

    @Test
    public void greetWhenTwoNamesBobAndCharlie() {
        String greeting = new Greeter().greet(Arrays.asList("Bob", "Charlie"));
        assertEquals("Hello, Bob and Charlie.", greeting);
    }

    @Test
    public void greetWhenMulitpleNames()
    {
        String greeting = new Greeter().greet(Arrays.asList("Amy", "Brian", "Charlotte"));
        assertEquals("Hello, Amy, Brian, and Charlotte.", greeting);
    }

    @Test
    public void abc()
    {
        String greeting = new Greeter().greet(Arrays.asList("Amy", "BRIAN", "Charlotte"));
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", greeting);
    }
}
