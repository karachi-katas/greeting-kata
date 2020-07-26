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

}
