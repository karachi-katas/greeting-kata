import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

        if (isUpperCaseExist(names))
        {
            return greetForUpperCase(names);
        }

        names = splitNameIfContainingCommas(names);

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

    private String[] splitNameIfContainingCommas(String[] names) {
        List<String> namesList = new ArrayList<String>();
        for (String name : names) {
            namesList.addAll(Arrays.asList(name.replaceAll(" ","")
                .split(",")));
        }
        return namesList.toArray(new String[0]);
    }

    private String greetForUpperCase(String[] names) {
        List<String> lowerCaseNames = new LinkedList <String> ();
        List <String> upperCaseNames = new LinkedList<String>();
        for (String name: names)
        {
            if (isUpperCase(name)) {
                upperCaseNames.add(name);
            }
            else {
                lowerCaseNames.add(name);
            }
        }
        StringBuilder greet = new StringBuilder("Hello, ");
        for (int itr=0; itr< lowerCaseNames.size() - 1; itr++) {
            greet.append(lowerCaseNames.get(itr)).append(" ");
        }

        greet.append("and ").append(lowerCaseNames.get(lowerCaseNames.size() - 1)).append(". ");
        greet.append("AND HELLO ").append(upperCaseNames.get(0)).append("!");

        return greet.toString();
    }

    private boolean isUpperCaseExist(String[] names) {
        for (String name: names)
        {
            if (isUpperCase(name)) {
                return true;
            }
        }
        return false;
    }
}
