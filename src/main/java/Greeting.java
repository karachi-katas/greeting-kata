public class Greeting {

    public static String greet() {
        return null;

    }

    public static String greet(String name) {
        if (name==null){
            return "Hello, my friend.";
        }
        return "Hello, " + name + ".";

    }
}
