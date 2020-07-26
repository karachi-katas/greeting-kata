public class Greeting {

    public String to(String... names) {
        if (guest(names)) {
            return "Hello, my friend.";
        }
        if (names.length == 1) {
            return to(names[0]);
        }
        return to(String.format("%s and %s", names[0], names[1]));
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
