public class Greeting {

    public String to(String name) {
        name = name == null ? "my friend" : name;

        String prefix = "Hello, ";
        String postfix = ".";

        if (name.equals(name.toUpperCase())) {
            prefix = "HELLO ";
            postfix = "!";
        }

        return prefix +  name + postfix;
    }
}
