import java.util.Arrays;

public class Greeter {
    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (this.isUppercase(name)) {
            return "HELLO, " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    public String greet(String[] names)
    {
        if (names.length == 2)
        {
            return "Hello, " + names[0] + " and " + names[1] + ".";
        }

        String lastName = names[names.length - 1];
        String[] lastRemovedNames = Arrays.copyOf(names, names.length - 1);
        return String.format("Hello, %s, and %s.", String.join(", ", lastRemovedNames), lastName);

    }


    private boolean isUppercase(String text) {
        return text.equals(text.toUpperCase());
    }
}
