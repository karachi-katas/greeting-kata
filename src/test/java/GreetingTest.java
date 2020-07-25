import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingTest {

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
        String greetings =Greeting.greet((String) null);
        assertEquals("Hello, my friend.",greetings);
    }

    @Test
    public void greetingWhenShouting(){
        String greetings =Greeting.greet("JERRY");
        assertEquals("HELLO JERRY!",greetings);
    }

    @Test
    public void greetingWhenTwoNames(){
        String[] name = {"Jill","Jane"};
        String greetings = Greeting.greet(name);
        assertEquals("Hello, Jill and Jane.", greetings);
    }

    @Test
    public void greetingWhenManyNames(){
        String[] name = {"Jill","Jane","Brian"};
        String greetings = Greeting.greet(name);
        assertEquals("Hello, Jill, Jane, and Brian.", greetings);
    }


}
