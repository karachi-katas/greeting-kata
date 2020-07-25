import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Greeting {

    public static String greet() {
        return null;

    }

    public static String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (isUpperCase(name)) {
            return "HELLO " + name + "!";
        }
        return "Hello, " + name + ".";
    }


    public static String greet(String[] name) {
        if (name == null) {
            return "Hello, my friend.";
        }

        List<String> normalNames = Arrays.stream(name).filter(item->!isUpperCase(item)).collect(Collectors.toList());
        List<String> shoutingNames = Arrays.stream(name).filter(Greeting::isUpperCase).collect(Collectors.toList());

        String normalNameToGreet = getNamesToGreet(normalNames) ;
        String shoutingNamesToGreet = getNamesToGreet(shoutingNames );

        String greeting = "Hello, " + normalNameToGreet + ".";
        if(shoutingNamesToGreet.length() > 0){
            greeting = greeting + " AND HELLO " + shoutingNamesToGreet + "!";
        }
        return greeting;
    }

    private static String getNamesToGreet(List<String> namesToGreet) {

        StringBuilder namesToGreetBuilder = new StringBuilder();

        for (int i = 0; i < namesToGreet.size() - 1; i++) {
            namesToGreetBuilder.append(namesToGreet.get(i)).append(", ");
        }
        if (namesToGreet.size() > 1) {
            namesToGreetBuilder.append("and ");
        }
        if (namesToGreet.size() > 0) {
            namesToGreetBuilder.append(namesToGreet.get(namesToGreet.size() - 1));
        }
        return namesToGreetBuilder.toString();

    }

    private static boolean isUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }
}
