import java.util.Arrays;
import java.util.stream.Stream;

public class Greeting {

    public String to(String... names) {
        if (guest(names)) {
            return "Hello, my friend.";
        }
        if (names.length == 1) {
            return to(names[0]);
        }
        if (names.length == 2 && allShout(names)) {
            return to(String.format("%s AND %s", names[0], names[1]));
        }
        if (names.length == 2) {
            return to(String.format("%s and %s", names[0], names[1]));
        }
        if (names.length > 2 && mixOfNormalAndShout(names)) {
            String[] lowerCaseNames = Stream.of(names).filter(this::dontShout).toArray(String[]::new);
            String[] upperCaseNames = Stream.of(names).filter(this::shout).toArray(String[]::new);

            return String.format("%s AND %s", to(lowerCaseNames), to(upperCaseNames));
        }
        String joined = commaSeparate(names);
        return to(joined + ",", last(names));
    }

    private boolean allShout(String[] names) {
        return Stream.of(names).allMatch(this::shout);
    }

    private boolean mixOfNormalAndShout(String[] names) {
        return Stream.of(names).anyMatch(this::shout) &&
                Stream.of(names).anyMatch(this::dontShout);
    }

    private String last(String[] names) {
        return names[names.length - 1];
    }

    private String commaSeparate(String[] names) {
        return String.join(", ", Arrays.asList(names).subList(0, names.length - 1));
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

    private boolean dontShout(String name) {
        return !shout(name);
    }
}
