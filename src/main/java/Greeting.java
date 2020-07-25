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

    private static boolean isUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }

    public static String greet(String[] name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        List<String> normalNames=Arrays.stream(name).filter(item->!isUpperCase(item)).collect(Collectors.toList());
        List<String> shoutingNames=Arrays.stream(name).filter(item->isUpperCase(item)).collect(Collectors.toList());
        StringBuilder normalNameBuilder = getNamesToGreetBuilder(name, normalNames, );
        StringBuilder shoutingNamesBuilder = getNamesToGreetBuilder(name, shoutingNames, );

        String greeting = "Hello, " + normalNameBuilder.toString() + ".";
        if (shoutingNames.size() > 0) {
            greeting = greeting + " AND HELLO " + shoutingNamesBuilder.toString() + "!";
        }
        return greeting;
    }

    private static String getNamesToGreetBuilKder(String[] name, List<String> namesToGreet, boolean isShouting) {

        StringBuilder namesToGreetBuilder = new StringBuilder();

        for (int i = 0; i < namesToGreet.size() - 1; i++) {
            namesToGreetBuilder.append(name[i]).append(", ");
        }
        if (namesToGreet.size() > 1) {
            namesToGreetBuilder.append("and ");
        }
        if (namesToGreet.size() > 0) {
            namesToGreetBuilder.append(namesToGreet.get(namesToGreet.size() - 1));
        }
        if(isShouting)
             return "HELLO " + namesToGreet.toString() + "!";
        else
            return "Hello, " + namesToGreet.toString() + ".";


    }
}
