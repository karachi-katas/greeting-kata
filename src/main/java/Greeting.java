public class Greeting {

    public String to(String name) {
        if (name == null) return "Hello, my friend.";
        if (name.toUpperCase().equals(name)) return "HELLO {name}!".replace("{name}", name);
        return "Hello, {name}.".replace("{name}", name);
    }
}
