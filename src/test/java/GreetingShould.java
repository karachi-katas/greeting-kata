import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void greetBob() {
        String [] names = {"Bob"};
        String name = "Bob";

        String greeting = new Greeting().greet(names);

        assertEquals("Hello, Bob.", greeting);
    }

    @Test
    public void greetAmir() {
        String [] names = {"Amir"};
        String greeting = new Greeting().greet(names);

        assertEquals("Hello, Amir.", greeting);
    }

    @Test
    public void greetJazib() {
        String [] names = {"Jazib"};
        String greeting = new Greeting().greet(names);

        assertEquals("Hello, Jazib.", greeting);
    }

    @Test
    public void greetGuest() {
        String [] names = {};

        String greeting = new Greeting().greet(names);

        assertEquals("Hello, my friend.", greeting);
    }

    @Test
    public void greetUpperCase() {
        String [] names = {"ROHAAN"};

        String greeting = new Greeting().greet(names);

        assertEquals("HELLO ROHAAN!", greeting);
    }

    @Test
    public void greetTwoPeople() {
        String [] names = {"Rohaan", "Naveed"};
        String greeting = new Greeting().greet(names);

        assertEquals("Hello, Rohaan and Naveed.", greeting);
    }




}
