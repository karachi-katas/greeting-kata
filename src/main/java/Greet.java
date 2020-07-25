public class Greet {

    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (isUpperCase(name)){
            return "HELLO " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    private boolean isUpperCase(String text) {
        return text.equals(text.toUpperCase());
    }
}
