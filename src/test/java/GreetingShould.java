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

    @Test
    public void shoutAtName() {
        String actual = new Greeting().to("JERRY");
        assertEquals("HELLO JERRY!", actual);
    }

    @Test
    public void greetTwoNames() {
        String actual = new Greeting().to("Jill", "Jane");
        assertEquals("Hello, Jill and Jane.", actual);
    }

    @Test
    public void greetArbitraryNumberOfNames() {
        String actual = new Greeting().to("Amy", "Brian", "Charlotte");
        assertEquals("Hello, Amy, Brian, and Charlotte.", actual);
    }

    @Test
    public void greetMoreArbitraryNumberOfNames() {
        String actual = new Greeting().to("Amy", "Brian", "Jan", "Charlotte");
        assertEquals("Hello, Amy, Brian, Jan, and Charlotte.", actual);
    }

    @Test
    public void greetMixOfNormalAndShout() {
        String actual = new Greeting().to("Amy", "BRIAN", "Charlotte");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", actual);
    }

    @Test
    public void greetMixOfNormalAndMultipleShout() {
        String actual = new Greeting().to("Amy", "BRIAN", "Charlotte", "SIA");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN AND SIA!", actual);
    }

    @Test
    public void splitNamesIfThereIsAComma() {
        String actual = new Greeting().to("Bob", "Charlie, Dianne");
        assertEquals("Hello, Bob, Charlie, and Dianne.", actual);
    }

}
