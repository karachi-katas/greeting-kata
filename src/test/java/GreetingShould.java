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
        String actual = new Greeting().to(null);
        assertEquals("Hello, my friend.", actual);
    }

    @Test
    public void shoutAtAnAllCapsName() {
        String actual = new Greeting().to("JERRY");
        assertEquals("HELLO JERRY!", actual);
    }

    @Test
    public void shoutAtTwoAllCapsName() {
        String actual = new Greeting().to("TOM", "JERRY");
        assertEquals("HELLO TOM AND JERRY!", actual);
    }

    @Test
    public void shoutAtThreeAllCapsName() {
        String actual = new Greeting().to("TOM", "JERRY", "SPIKE");
        assertEquals("HELLO TOM, JERRY, AND SPIKE!", actual);
    }

    @Test
    public void shoutAtArbitraryAllCapsNames() {
        String actual = new Greeting().to("TOM", "JERRY", "NIBBLES", "SPIKE");
        assertEquals("HELLO TOM, JERRY, NIBBLES, AND SPIKE!", actual);
    }

    @Test
    public void sayHelloToTwoNames() {
        String actual = new Greeting().to("Jill", "Jane");
        assertEquals("Hello, Jill and Jane.", actual);
    }

    @Test
    public void sayHelloToThreeNames() {
        String actual = new Greeting().to("Amy", "Brian", "Charlotte");
        assertEquals("Hello, Amy, Brian, and Charlotte." , actual);
    }

    @Test
    public void sayHelloToArbitraryNumberOfNames() {
        String actual = new Greeting().to("Amy", "Brian", "Bob", "Charlotte");
        assertEquals("Hello, Amy, Brian, Bob, and Charlotte." , actual);
    }

    @Test
    public void mixNormalAndShout() {
        String actual = new Greeting().to("Amy", "BRIAN", "Charlotte");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!" , actual);
    }

    @Test
    public void mixNormalAndMultipleShout() {
        String actual = new Greeting().to("Amy", "BRIAN", "Charlotte", "TOM");
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN AND TOM!" , actual);
    }

    @Test
    public void mixSingleNormalAndMultipleShout() {
        String actual = new Greeting().to("BRIAN", "Charlotte", "TOM");
        assertEquals("Hello, Charlotte. AND HELLO BRIAN AND TOM!" , actual);
    }

    @Test
    public void mixArbitraryNormalAndArbitraryShout() {
        String actual = new Greeting().to("Amy", "Tim", "BRIAN", "Charlotte", "BOB", "TOM");
        assertEquals("Hello, Amy, Tim, and Charlotte. AND HELLO BRIAN, BOB, AND TOM!" , actual);
    }
}
