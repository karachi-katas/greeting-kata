import java.util.*;

public class Greet {

    enum CASE {
        UPPER, DEFAULT;
    }

    class Strategy {
        String greet,
                separator,
                lastSeparator,
                delimiter;

        public Strategy(String greet, String separator, String lastSeparator, String delimiter) {
            this.greet = greet;
            this.separator = separator;
            this.lastSeparator = lastSeparator;
            this.delimiter = delimiter;
        }
    }

    private static final Map<CASE, Strategy> strategies = new HashMap<>();
    private final String NULL_CASE = "Hello, my friend.";
    private final String CASE_SEPARATOR = " AND ";


    Greet() {
        strategies.put(CASE.UPPER, new Strategy("HELLO", "", "AND", "!"));
        strategies.put(CASE.DEFAULT, new Strategy("Hello", ",", "and", "."));
    }

    public String greet(String... names) {

        if (names == null) {
            return NULL_CASE;
        }

        names = preProcess(names);

        return greetNames(names);
    }

    private String greetSingleName(String name) {
        Strategy strategy = getStrategy(name);
        return strategy.greet + strategy.separator + " " + name + strategy.delimiter;
    }

    private String greetMultipleNames(String[] names) {

        if (names.length == 1) {
            return greetSingleName(names[0]);
        }

        Strategy strategy = getStrategy(names[0]);

        StringBuilder greeting = new StringBuilder(strategy.greet);


        for (int i = 0; i < names.length - 1; i++) {
            greeting.append(strategy.separator + " " + names[i]);
        }

        greeting.append(" " + strategy.lastSeparator + " " + names[names.length - 1] + strategy.delimiter);

        return greeting.toString();
    }

    private String greetNames(String[] names) {
        List<String> upperCaseNames = getUpperCaseNames(names);
        List<String> defaultCaseNames = getDefaultCaseNames(names);
        StringBuilder greeting = new StringBuilder();

        if (isExists(defaultCaseNames)) {
            greeting.append(greetMultipleNames(defaultCaseNames.toArray(new String[0])));
        }
        if (isExists(defaultCaseNames) && isExists(upperCaseNames)) {
            greeting.append(CASE_SEPARATOR);
        }
        if (isExists(upperCaseNames)) {
            greeting.append(greetMultipleNames(upperCaseNames.toArray(new String[0])));
        }
        return greeting.toString();
    }

    private boolean isUpperCase(String text) {
        return text.equals(text.toUpperCase());
    }

    private String[] preProcess(String... names) {
        List<String> processedNames = new ArrayList<>();

        for (String name : names) {
            if (name.contains(",")) {
                processedNames.addAll(Arrays.asList(name.split(",\\s*")));
            } else {
                processedNames.add(name.trim());
            }
        }

        return processedNames.toArray(new String[0]);
    }

    private Strategy getStrategy(String text) {
        if (isUpperCase(text))
            return strategies.get(CASE.UPPER);
        return strategies.get(CASE.DEFAULT);
    }

    private List<String> getUpperCaseNames(String... names) {
        List<String> upperCaseNames = new ArrayList<>();
        for (String name : names) {
            if (isUpperCase(name)) {
                upperCaseNames.add(name);
            }
        }
        return upperCaseNames;
    }

    private List<String> getDefaultCaseNames(String... names) {
        List<String> defaultCaseNames = new ArrayList<>();
        for (String name : names) {
            if (!isUpperCase(name)) {
                defaultCaseNames.add(name);
            }
        }
        return defaultCaseNames;
    }

    private boolean isExists(List<String> array) {
        return array.size() > 0;
    }

}
