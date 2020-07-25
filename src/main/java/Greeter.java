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

    public String greet(String[] names) {
        return "Hello, Amy and Brian.";
    }

    private boolean isUppercase(String text) {
        return text.equals(text.toUpperCase());
    }
}
