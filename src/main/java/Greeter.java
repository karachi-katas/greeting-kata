public class Greeter {
    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (this.isUppercase(name)) {
            return "HELLO, " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    private boolean isUppercase(String text) {
        return text.equals(text.toUpperCase());
    }
}
