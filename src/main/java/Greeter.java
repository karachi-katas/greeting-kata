import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Greeter {
    public String greet(String name) {
        if (name == null) {
            return "Hello, my friend.";
        }
        if (this.isUppercase(name)) {
            return "HELLO, " + name + "!";
        }
        return "Hello, " + name + ".";
    }

    public String greet(List<String> names)
    {
        String notUpperCaseString = getNotUpperCaseNamesGreeting(names);
        String upperCaseString = getUpperCaseNamesGreeting(names);

        return getMergedUpperAndNotUpperCaseGreeting(notUpperCaseString, upperCaseString);
    }

    private String getMergedUpperAndNotUpperCaseGreeting(String notUpperCaseString, String upperCaseString) {
        if (!upperCaseString.isEmpty() && !notUpperCaseString.isEmpty())
        {
            return notUpperCaseString + " AND " + upperCaseString;
        }
        else
        {
            return notUpperCaseString + upperCaseString;
        }
    }

    private String getUpperCaseNamesGreeting(List<String> names) {
        List<String> upperCaseNames = names.stream().filter(this::isUppercase).collect(Collectors.toList());
        String upperCaseString = "";
        if (upperCaseNames.size() != 0) {
            upperCaseString = getShoutedNames(upperCaseNames);
        }
        return upperCaseString;
    }

    private String getNotUpperCaseNamesGreeting(List<String> names) {
        List<String> notUpperCaseNames = names.stream().filter(not(this::isUppercase)).collect(Collectors.toList());
        String notUpperCaseString = "";
        if (notUpperCaseNames.size() != 0) {
            notUpperCaseString = getGreetedNames(notUpperCaseNames);
        }
        return notUpperCaseString;
    }

    public String getShoutedNames(List<String> names)
    {
        if (names.size() == 1)
            return "HELLO " + names.get(0) + "!";
        else if (names.size() == 2)
            return "HELLO, " + names.get(0) + " and " + names.get(1) + "!";
        else
        {
            return "HELLO, " + getJoinedNames(names) + "!";
        }
    }

    public String getGreetedNames(List<String> names)
    {
        if (names.size() == 1)
            return "Hello " + names.get(0) + ".";
        else if (names.size() == 2)
            return "Hello, " + names.get(0) + " and " + names.get(1) + ".";
        else
        {
            return "Hello, " + getJoinedNames(names) + ".";
        }
    }

    public static <T> Predicate<T> not(Predicate<T> t) {
        return t.negate();
    }


    private String getJoinedNames(List<String> names) {
        int size = names.size();
        String lastName = names.get(size - 1);
        if (size == 1)
            return lastName;
        List<String> lastRemovedNames = names.subList(0, size - 1);
        return String.format("%s, and %s", String.join(", ", lastRemovedNames), lastName);
    }


    private boolean isUppercase(String text) {
        return text.equals(text.toUpperCase());
    }
}
