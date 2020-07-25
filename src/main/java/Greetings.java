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

        String greet = "Hello, ";
        for (int itr=0; itr< names.length-1; itr++) {
            greet = greet + names[itr]+", ";
        }

        greet = greet + "and " + names[names.length-1] +".";
        return greet;

    }
}
