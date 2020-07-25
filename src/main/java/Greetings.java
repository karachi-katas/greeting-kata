public class Greetings {

    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (isUpperCase(name)) {
            return "HELLO " + name + "!";
        }
        return "Hello, " + name +".";
    }

    private boolean isUpperCase(String name) {
        return name.toUpperCase().equals(name);
    }

    public String greet(String[] names) {
        return String.format("Hello, %s and %s.", names[0], names[1]);
    }
}
