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

        if (upperCaseNames.size() == 1) {
            return "HELLO " + upperCaseNames.get(0) + "!";
        }

        String upperCaseString = "";
        if (upperCaseNames.size() != 0) {
            upperCaseString = String.format("HELLO, %s!", getJoinedNames(upperCaseNames));
        }
        return upperCaseString;
    }

    private String getNotUpperCaseNamesGreeting(List<String> names) {
        List<String> notUpperCaseNames = names.stream().filter(not(this::isUppercase)).collect(Collectors.toList());

        if (notUpperCaseNames.size() == 1) {
            return "Hello " + notUpperCaseNames.get(0) + ".";
        }

        String notUpperCaseString = "";
        if (notUpperCaseNames.size() != 0) {
            notUpperCaseString = String.format("Hello, %s.", getJoinedNames(notUpperCaseNames));
        }
        return notUpperCaseString;
    }

    public String getJoinedNames(List<String> names)
    {
        if (names.size() == 2)
            return names.get(0) + " and " + names.get(1);
        else
        {
            return getJoinedNamesForMoreThanTwo(names);
        }
    }

    public static <T> Predicate<T> not(Predicate<T> t) {
        return t.negate();
    }


    private String getJoinedNamesForMoreThanTwo(List<String> names) {
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
