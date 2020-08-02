public class Greeting {

    public String to(String name) {
        if (name == null) return "Hello, my friend.";
        return "Hello, {name}.".replace("{name}", name);
    }
}
