import java.util.Arrays;

public class Greeting {

    public static final String GUEST_GREETING = "Hello, my friend.";
    public static final String SHOUT_GREETING = "HELLO {name}!";
    public static final String NORMAL_GREETING = "Hello, {name}.";
    public static final String SHOUT_AND = "{firstName} AND {secondName}";
    public static final String NORMAL_AND = "{firstName} and {secondName}";

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

        if (Arrays.stream(names).anyMatch(name -> name.contains(","))) {
            String[] splitNames = Arrays.stream(names).flatMap(name -> Arrays
                    .stream(name.split(","))).map(String::trim).toArray(String[]::new);
            return to(splitNames);
        }

        return greetMany(names);
    }

    private String greetMany(String... names) {
        if (names.length == 1) {
            return greetOne(names[0]);
        }

        if (mixOfUpperAndLowerCase(names)) {
            String[] upperCaseNames = filterUpperCase(names);
            String[] lowerCaseNames = filterLowerCase(names);
            return "{lowerCaseNames} AND {upperCaseNames}"
                    .replace("{lowerCaseNames}", greetMany(lowerCaseNames))
                    .replace("{upperCaseNames}", greetMany(upperCaseNames));
        }

        if (names.length >= 3) {
            String joinedNames = join(names);
            return greetMany(joinedNames, lastOf(names));
        }

        return greetTwo(names[0], names[1]);
    }

    private String[] filterLowerCase(String[] names) {
        return Arrays.stream(names).filter(name -> !name.toUpperCase().equals(name)).toArray(String[]::new);
    }

    private String[] filterUpperCase(String[] names) {
        return Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)).toArray(String[]::new);
    }

    private String lastOf(String[] names) {
        return names[names.length-1];
    }

    private String join(String[] names) {
        String commaSeparatedNames = String.join(", ",
                Arrays.copyOfRange(names, 0, names.length - 1));
        return commaSeparatedNames + ",";
    }

    private boolean mixOfUpperAndLowerCase(String[] names) {
        return Arrays.stream(names).anyMatch(name -> name.toUpperCase().equals(name)) &&
                Arrays.stream(names).filter(name -> name.toUpperCase().equals(name)).count() < names.length;
    }
}
