public class Greeting {

    public String to(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        return String.format("Hello, %s.", name);
    }
}
