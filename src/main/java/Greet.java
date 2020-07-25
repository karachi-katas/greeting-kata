public class Greet {

    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (name.equals(name.toUpperCase())){
            return "HELLO " + name + "!";
        }
        return "Hello, " + name + ".";
    }
}
