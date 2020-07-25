public class Greeting {

    public boolean isUpperCase (String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }

    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }

        if (isUpperCase(name)) {
            return "HELLO " + name +"!";
        }
        return "Hello, " + name + ".";
    }
}
