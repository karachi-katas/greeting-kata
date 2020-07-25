import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooTest {

    @Test
    public void bar() {
        assertEquals(1, 1);
    }

    @Test
    public void CreateSingleGreeting(){
        String greetings = Greeting.greet();
    }

    @Test
    public void SingleGreeting() {
        String greetings = Greeting.greet("Bob");
        assertEquals("Hello, Bob.", greetings);
    }
    @Test
    public void greetingNull(){
        String greetings =Greeting.greet(null);
        assertEquals("Hello, my friend.",greetings);
    }

    @Test
    public void greetingWhenShouting(){
        String greetings =Greeting.greet("JERRY");
        assertEquals("HELLO JERRY!",greetings);
    }
}
