public class Greeting {

    public boolean isUpperCase (String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }

    public String greet(String[] names) {
        if (names.length > 2) {
            String result = "Hello, ";
            for (int i = 0; i < names.length - 1; i++) {
                result += names[i] + ", ";
            }
            result += "and " + names[names.length-1] + ".";
            return result;
        }

        if (names.length == 2) {
            return "Hello, " + names[0] + " and " + names[1] + ".";
        }
        if (names.length == 0) {
            return "Hello, my friend.";
        }
        if (isUpperCase(names[0])) {
            return "HELLO " + names[0] +"!";
        }
        return "Hello, " + names[0] + ".";
    }
}
