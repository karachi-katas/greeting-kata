import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingShould {

    @Test
    public void sayHelloToAnIndividual() {
        String actual = new Greeting().to("Bob");
        assertEquals("Hello, Bob.", actual);
    }

}
