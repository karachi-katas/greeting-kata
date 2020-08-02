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

    private String greetTwo(String firstName, String secondName) {
        if (shoutAt(firstName)) {
            return greetOne("{name1} AND {name2}"
                    .replace("{name1}", firstName)
                    .replace("{name2}", secondName));
        }
        return greetOne("{name1} and {name2}"
                .replace("{name1}", firstName)
                .replace("{name2}", secondName));
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

        if (Arrays.stream(names).anyMatch(name -> name.toUpperCase().equals(name)) &&
                Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)).count() < names.length) {
            String[] upperCaseNames = Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)).toArray(String[]::new);
            String[] lowerCaseNames = Arrays.stream(names).filter(name -> !name.toUpperCase().equals(name)).toArray(String[]::new);
            return "{lowerCase} AND {upperCase}"
                    .replace("{lowerCase}", to(lowerCaseNames))
                    .replace("{upperCase}", to(upperCaseNames));
        }

        if (names.length >= 3) {
            String commaSeparatedNames = String.join(", ", Arrays.copyOfRange(names, 0, names.length - 1));
            return to(commaSeparatedNames + ",", names[names.length-1]);
        }

        return greetTwo(names[0], names[1]);
    }
}
