public class Greeting {

    public String to(String name) {
        if (guest(name)) {
            return "Hello, my friend.";
        }
        if (shout(name)) {
            return String.format("HELLO %s!", name);
        }
        return String.format("Hello, %s.", name);
    }

    public String to(String... names) {
        if (names.length == 0) {
            return to((String) null);
        }
        if (names.length == 1) {
            return to(names[0]);
        }
        return to(String.format("%s and %s", names[0], names[1]));
    }

    private boolean shout(String name) {
        return name.equals(name.toUpperCase());
    }

    private boolean guest(String name) {
        return name == null;
    }
}
