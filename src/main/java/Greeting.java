public class Greeting {

    public String to(String name) {
        name = name == null ? "my friend" : name;
        return "Hello, " +  name + ".";
    }
}
