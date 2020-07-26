import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greeting {

    public String to(String... names) {
        if (guest(names)) {
            return "Hello, my friend.";
        }
        if (names.length == 1) {
            return to(names[0]);
        }
        if (names.length == 2) {
            return to(String.format("%s and %s", names[0], names[1]));
        }
        String joined = String.join(", ", Arrays.asList(names).subList(0, names.length - 1));
        return to(joined + ",", names[names.length - 1]);
    }

    private boolean guest(String[] names) {
        return names == null;
    }

    private String to(String name) {
        if (shout(name)) {
            return String.format("HELLO %s!", name);
        }
        return String.format("Hello, %s.", name);
    }

    private boolean shout(String name) {
        return name.equals(name.toUpperCase());
    }
}
