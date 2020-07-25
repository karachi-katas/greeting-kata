import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
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
        StringBuilder normalNameBuilder = getStringBuilder(name, normalNames);
        StringBuilder shoutingNamesBuilder = getStringBuilder(name, shoutingNames);

        String greeting = "Hello, " + normalNameBuilder.toString() + ".";
        if (shoutingNames.size() > 0) {
            greeting = greeting + " AND HELLO " + shoutingNamesBuilder.toString() + "!";
        }
        return greeting;
    }

    private static StringBuilder getStringBuilder(String[] name, List<String> shoutingNames) {
        StringBuilder shoutingNamesBuilder = new StringBuilder();

        for (int i = 0; i < shoutingNames.size() - 1; i++) {
            shoutingNamesBuilder.append(name[i]).append(", ");
        }
        if (shoutingNames.size() > 1) {
            shoutingNamesBuilder.append("and ");
        }
        if (shoutingNames.size() > 0) {
            shoutingNamesBuilder.append(shoutingNames.get(shoutingNames.size() - 1));
        }
        return shoutingNamesBuilder;
    }
}
