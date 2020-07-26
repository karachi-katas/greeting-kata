import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void sayHelloToAnIndividual() {
        String actual = new Greeting().to("Bob");
        assertEquals("Hello, Bob.", actual);
    }

    @Test
    public void sayHelloToAnotherIndividual() {
        String actual = new Greeting().to("Amir");
        assertEquals("Hello, Amir.", actual);
    }

    @Test
    public void sayHelloToAGuest() {
        String actual = new Greeting().to((String)null);
        assertEquals("Hello, my friend.", actual);
    }

    @Test
    public void shoutAtAnAllCapsName() {
        String actual = new Greeting().to("JERRY");
        assertEquals("HELLO JERRY!", actual);
    }

    @Test
    public void sayHelloToTwoNames() {
        String actual = new Greeting().to("Jill", "Jane");
        assertEquals("Hello, Jill and Jane.", actual);
    }

}
