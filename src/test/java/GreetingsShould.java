import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingsShould {

    @Test
    public void bar() {
        assertEquals(1, 1);
    }

    @Test
    public void greetBob(){
        String name = "Bob";
        String greetingsMessage = new Greetings().greet(name);
        assertEquals("Hello, Bob.", greetingsMessage);
    }

    @Test
    public void greetForFriend() {
        String name = null;
        String greetingsMessage = new Greetings().greet(name);
        assertEquals("Hello, my friend.", greetingsMessage);
    }
}
