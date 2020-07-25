public class Greeting {

    public boolean isUpperCase (String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }

    public String greet(String[] name) {
        if (name.length == 2) {
            return "Hello, " + name[0] + " and " + name[1] + ".";
        }

        if (name.length == 0) {
            return "Hello, my friend.";
        }

        if (isUpperCase(name[0])) {
            return "HELLO " + name[0] +"!";
        }
        return "Hello, " + name[0] + ".";
    }
}
