public class Greetings {

    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (isUpperCase(name)) {
            return "HELLO " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    private boolean isUpperCase(String name) {
        return name.toUpperCase().equals(name);
    }

    public String greet(String[] names) {

        if (names.length == 2) {
            return String.format("Hello, %s and %s.", names[0], names[1]);
        }

        StringBuilder greet = new StringBuilder("Hello, ");
        for (int itr=0; itr< names.length-1; itr++) {
            greet.append(names[itr]).append(", ");
        }

        greet.append("and ").append(names[names.length - 1]).append(".");
        return greet.toString();

    }
}
