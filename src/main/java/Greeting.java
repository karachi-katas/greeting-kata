import java.util.Arrays;

public class Greeting {

    public static final String GUEST_GREETING = "Hello, my friend.";
    public static final String SHOUT_GREETING = "HELLO {name}!";
    public static final String NORMAL_GREETING = "Hello, {name}.";
    public static final String SHOUT_AND = "{firstName} AND {secondName}";
    public static final String NORMAL_AND = "{firstName} and {secondName}";
    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final String QUOTE = "\"";
    public static final String SPACE = " ";

    private String greetOne(String name) {
        if (shoutAt(name)) {
            return SHOUT_GREETING.replace("{name}", name);
        }
        return NORMAL_GREETING.replace("{name}", name);
    }

    private String greetTwo(String firstName, String secondName) {
        if (shoutAt(firstName)) {
            return greetOne(SHOUT_AND
                    .replace("{firstName}", firstName)
                    .replace("{secondName}", secondName));
        }
        return greetOne(NORMAL_AND
                .replace("{firstName}", firstName)
                .replace("{secondName}", secondName));
    }

    private boolean shoutAt(String name) {
        return name.toUpperCase().equals(name);
    }

    private boolean guest(String[] names) {
        return names == null;
    }

    public String to(String... names) {
        if (guest(names)) {
            return GUEST_GREETING;
        }

        return greetMany(split(names));
    }

    private String[] split(String[] names) {
        return Arrays.stream(names).flatMap(name -> Arrays
                .stream(split(name))).map(String::trim).toArray(String[]::new);
    }

    private String[] split(String name) {
        if (escaped(name)) {
            return new String[]{unescape(name)};
        }
        return name.split(COMMA);
    }

    private String unescape(String name) {
        return name.replace(QUOTE, EMPTY);
    }

    private boolean escaped(String name) {
        return name.startsWith(QUOTE) && name.endsWith(QUOTE);
    }

    private String greetMany(String... names) {
        if (names.length == 1) {
            return greetOne(names[0]);
        }

        if (mixOfUpperAndLowerCase(names)) {
            return "{lowerCaseNames} AND {upperCaseNames}"
                    .replace("{lowerCaseNames}", greetMany(lowerCase(names)))
                    .replace("{upperCaseNames}", greetMany(upperCase(names)));
        }

        if (names.length >= 3) {
            return greetMany(join(names), lastOf(names));
        }

        return greetTwo(names[0], names[1]);
    }

    private String[] lowerCase(String[] names) {
        return Arrays.stream(names).filter(name -> !name.toUpperCase().equals(name))
                .toArray(String[]::new);
    }

    private String[] upperCase(String[] names) {
        return Arrays.stream(names).filter(name -> name.toUpperCase().equals(name))
                .toArray(String[]::new);
    }

    private String lastOf(String[] names) {
        return names[names.length - 1];
    }

    private String join(String[] names) {
        String commaSeparatedNames = String.join(COMMA + SPACE,
                Arrays.copyOfRange(names, 0, names.length - 1));
        return commaSeparatedNames + COMMA;
    }

    private boolean mixOfUpperAndLowerCase(String[] names) {
        return atLeastOneUpperCase(names) &&
                notAllUpperCase(names);
    }

    private boolean notAllUpperCase(String[] names) {
        return Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)).count()
                < names.length;
    }

    private boolean atLeastOneUpperCase(String[] names) {
        return Arrays.stream(names).anyMatch(name -> name.toUpperCase().equals(name));
    }
}
