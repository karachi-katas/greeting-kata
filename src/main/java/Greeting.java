public class Greeting {

    public String to(String name) {
        name = name == null ? "my friend" : name;

        if (name.equals(name.toUpperCase())) {
            return "HELLO " + name + "!";
        }

        return "Hello, " +  name + ".";
    }
}
