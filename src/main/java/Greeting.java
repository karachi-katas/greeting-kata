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

    private boolean shout(String name) {
        return name.equals(name.toUpperCase());
    }

    private boolean guest(String name) {
        return name == null;
    }
}
