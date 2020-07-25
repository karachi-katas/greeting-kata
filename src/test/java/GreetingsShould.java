import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingsShould {

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

    @Test
    public void shoutUpperCase() {
        String name = "JERRY";
        String greetingsMessage = new Greetings().greet(name);
        assertEquals("HELLO JERRY!", greetingsMessage);
    }

    @Test
    public void greetTwoPeople() {
        String[] names = {"Jill", "Jane"};
        String greetingsMessage = new Greetings().greet(names);
        assertEquals("Hello, Jill and Jane.", greetingsMessage);
    }

    @Test
    public void greetMultiplePeople() {
        String[] names = {"Amy", "Brian", "Charlotte"};
        String greetingsMessage = new Greetings().greet(names);
        assertEquals("Hello, Amy, Brian, and Charlotte.", greetingsMessage);
    }

    @Test
    public void greetMultiplePeopleWithShout() {
        String[] names = {"Amy", "BRIAN", "Charlotte"};
        String greetingsMessage = new Greetings().greet(names);
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", greetingsMessage);
    }
}
