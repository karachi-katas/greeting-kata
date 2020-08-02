import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooTest {

    @Test
    public void bar() {
        String actual = new Greeting().to("Bob");
        assertEquals("Hello, Bob.", actual);
    }

}
