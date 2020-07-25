public class Greeting {

    public String to(String name) {
        name = name != null ? name: "my friend";
        return "Hello, " +  name + ".";
    }
}
