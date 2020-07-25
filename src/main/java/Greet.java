import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Greet {

    public String greet (String... names){

        if (names == null) {
            return "Hello, my friend.";
        }

        names = preProcess(names);

        if (names.length == 1 && isUpperCase(names[0])){
            return "HELLO " + names[0] + "!";
        }

        if (names.length == 1){
            return "Hello, " + names[0] + ".";
        }

        return greetMultipleMixCasesNames(names);
    }

    private String greetMultipleNamesDefaultCase(String[] names) {
        StringBuilder greeting = new StringBuilder("Hello");

        for (int i = 0; i < names.length - 1; i++){
            greeting.append(", " +names[i]);
        }

        greeting.append(" and " + names[names.length-1] + '.');

        return greeting.toString();
    }

    private String greetMultipleNamesUpperCase(String[] names) {

        if (names.length == 1 && isUpperCase(names[0])){
            return "HELLO " + names[0] + "!";
        }

        throw new UnsupportedOperationException();
    }

    private String greetMultipleMixCasesNames(String[] names) {
        List<String> upperCaseNames = new ArrayList<String>();
        List<String> defaultCaseNames = new ArrayList<String>();
        StringBuilder greeting = new StringBuilder();
        for (int i = 0; i < names.length; i++){
            if(isUpperCase(names[i])) {
                upperCaseNames.add(names[i]);
            } else {
                defaultCaseNames.add(names[i]);
            }
        }

        if(defaultCaseNames.size() > 0) {
            greeting.append(greetMultipleNamesDefaultCase(defaultCaseNames.toArray(new String[0])));
        }
        if(upperCaseNames.size() > 0) {
            greeting.append(" AND " + greetMultipleNamesUpperCase(upperCaseNames.toArray(new String[0])));
        }
        return greeting.toString();
    }

    private boolean isUpperCase(String text) {
        return text.equals(text.toUpperCase());
    }

    private String[] preProcess(String... names){
        List<String> processedNames = new ArrayList<String>();

        for (String name : names){
            if (name.contains(",")){
                processedNames.addAll(Arrays.asList(name.split(",\\s*")));
            }
            else {
                processedNames.add(name.trim());
            }
        }

        return processedNames.toArray(new String[0]);
    }


}
