import java.util.ArrayList;

public class Greeting {

    public boolean isUpperCase(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }

    public String greetingForNormalNames(ArrayList<String> names) {

        if (names.size() > 2) {
            String result = "Hello, ";
            for (int i = 0; i < names.size() - 1; i++) {
                result += names.get(i) + ", ";
            }
            result += "and " + names.get(names.size() - 1) + ".";
            return result;
        }
        if (names.size() == 2) {
            return "Hello, " + names.get(0) + " and " + names.get(1) + ".";
        }
        return "Hello, " + names.get(0) + ".";
    }

    public String greetingForShoutedNames(ArrayList<String> names) {
        return "HELLO " + names.get(0) + "!";
    }

    public String[] removeCommaFromNames(String [] names) {
        ArrayList<String> result = new ArrayList<String>();

        for(String name : names) {
            if (name.contains(", ")) {
                String []splitted_names = name.split(", ");
                for (String splittedName : splitted_names) {

                    result.add(splittedName);
                }
            }
            else {
                result.add(name);
            }

        }
        String []resultString = result.toArray(new String[result.size()]);
        return resultString;
    }

    public String greet(String[] names) {
        names = removeCommaFromNames(names);
        ArrayList<String> normalNames = extractNormalNames(names);
        ArrayList<String> shoutedNames = extractShoutedNames(names);

        if (normalNames.size() > 0 && shoutedNames.size() > 0) {
            String normalGreetings = greetingForNormalNames(normalNames);
            String shoutedGreetings = greetingForShoutedNames(shoutedNames);
            return normalGreetings + " AND " + shoutedGreetings;
        }

        if (normalNames.size() > 0) {
            String normalGreetings = greetingForNormalNames(normalNames);
            return normalGreetings;
        }

        if (shoutedNames.size() > 0) {
            String shoutedGreetings = greetingForShoutedNames(shoutedNames);
            return shoutedGreetings;
        }

        return "Hello, my friend.";
    }

    private ArrayList<String> extractShoutedNames(String[] names) {
        ArrayList<String> shoutedNames = new ArrayList<String>();
        for (int i = 0; i < names.length; i++) {
            if (isUpperCase(names[i])) {
                shoutedNames.add(names[i]);
            }
        }
        return shoutedNames;
    }

    private ArrayList<String> extractNormalNames(String[] names) {
        ArrayList<String> normalNames = new ArrayList<String>();
        for (int i = 0; i < names.length; i++) {
            if (!isUpperCase(names[i])) {
                normalNames.add(names[i]);
            }
        }
        return normalNames;
    }
}
