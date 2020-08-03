import java.util.Arrays;
import java.util.stream.Stream;

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

    public String to(String... names) {
        if (guest(names)) {
            return GUEST_GREETING;
        }

        return greetMany(split(names));
    }

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

    private String greetMany(String... names) {
        if (names.length == 1) {
            return greetOne(firstOf(names));
        }

        if (mixOfUpperAndLowerCase(names)) {
            return "{lowerCaseNames} AND {upperCaseNames}"
                    .replace("{lowerCaseNames}", greetMany(lowerCase(names)))
                    .replace("{upperCaseNames}", greetMany(upperCase(names)));
        }

        if (names.length >= 3) {
            return greetMany(join(exceptLastOf(names)), lastOf(names));
        }

        return greetTwo(firstOf(names), lastOf(names));
    }

    private boolean shoutAt(String name) {
        return name.toUpperCase().equals(name);
    }

    private boolean guest(String[] names) {
        return names == null;
    }

    private String[] split(String[] names) {
        return arrayOf(Arrays.stream(names).flatMap(name -> Arrays
                .stream(split(name))).map(String::trim));
    }

    private String[] arrayOf(Stream<String> stream) {
        return stream.toArray(String[]::new);
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

    private String[] lowerCase(String[] names) {
        return arrayOf(Arrays.stream(names).filter(name -> !name.toUpperCase().equals(name)));
    }

    private String[] upperCase(String[] names) {
        return arrayOf(Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)));
    }

    private String lastOf(String[] names) {
        return names[names.length - 1];
    }
    private String firstOf(String[] names) {
        return names[0];
    }

    private String join(String[] names) {
        String commaSeparatedNames = String.join(COMMA + SPACE, names);
        return commaSeparatedNames + COMMA;
    }

    private String[] exceptLastOf(String[] names) {
        return Arrays.copyOfRange(names, 0, names.length - 1);
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
