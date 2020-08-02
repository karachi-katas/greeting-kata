import java.util.Arrays;

public class Greeting {

    private String greetOne(String name) {
        if (guest(name)) {
            return "Hello, my friend.";
        }
        if (shoutAt(name)) {
            return "HELLO {name}!".replace("{name}", name);
        }
        return "Hello, {name}.".replace("{name}", name);
    }

    private boolean shoutAt(String name) {
        return name.toUpperCase().equals(name);
    }

    private boolean guest(String name) {
        return name == null;
    }

    public String to(String... names) {
        if (names == null) {
            return "Hello, my friend.";
        }

        if (names.length == 1) {
            return greetOne(names[0]);
        }

        if (names.length >= 3) {
            String commaSeparatedNames = String.join(", ", Arrays.copyOfRange(names, 0, names.length - 1));
            return "Hello, {commaSeparatedNames}, and {lastName}."
                    .replace("{commaSeparatedNames}", commaSeparatedNames)
                    .replace("{lastName}", names[names.length-1]);
        }

        return "Hello, {name1} and {name2}."
                .replace("{name1}", names[0])
                .replace("{name2}", names[1]);
    }
}
