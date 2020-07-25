public class Greeting {

    private String to(String name) {
        name = name == null ? "my friend" : name;

        String prefix = "Hello, ";
        String postfix = ".";

        if (name.equals(name.toUpperCase())) {
            prefix = "HELLO ";
            postfix = "!";
        }

        return prefix +  name + postfix;
    }

    public String to(String... names) {
        if (names == null) {
            return to((String) null);
        }
        if (names.length == 1) {
            return to(names[0]);
        }
        if (names.length > 2) {
            return to(names[0] + ", " + names[1] + ",", names[2]);
        }
        return "Hello, " + names[0] + " and " + names[1] + ".";
    }
}
