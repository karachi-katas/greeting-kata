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
}
