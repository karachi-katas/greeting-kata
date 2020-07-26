public class Greeting {

    public String to(String name) {
        if (guest(name)) {
            return "Hello, my friend.";
        }
        if (name.equals(name.toUpperCase())) {
            return String.format("HELLO %s!", name);
        }
        return String.format("Hello, %s.", name);
    }

    private boolean guest(String name) {
        return name == null;
    }
}
