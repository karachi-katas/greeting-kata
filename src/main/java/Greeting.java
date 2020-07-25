import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Greeting {

    public static String greet() {
        return null;

    }

    public static String greet(String name) {
        if (name==null){
            return "Hello, my friend.";
        }
        if(isUpperCase(name)){
            return "HELLO "+name+"!";
        }
        return "Hello, " + name + ".";

    }

    private static boolean isUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }

    public static String greet(String[] name) {
        if (name==null){
            return "Hello, my friend.";
        }
        if(name.length == 2){
            return  "Hello, " + name[0] + " and " + name[1] + ".";
        } else if (name.length > 2){

            List<String> normalNames = new ArrayList<>();
            List<String> shoutingNames = new ArrayList<>();


            for( int i = 0; i < name.length; i++){
                if(isUpperCase(name[i])){
                    shoutingNames.add(name[i]);
                }else{
                    normalNames.add(name[i]);
                }
            }

            StringBuilder normalNameBuilder = new StringBuilder();
            for (int i = 0; i < normalNames.size() -1; i++){
                normalNameBuilder.append(name[i]).append(", ");
            }

            StringBuilder shoutingNamesBuilder = new StringBuilder();
            for (int i = 0; i < shoutingNames.size() -1; i++){
                shoutingNamesBuilder.append(name[i]).append(", ");
            }


            if(normalNames.size() > 1){
                normalNameBuilder.append("and ");
            }
            if(normalNames.size() > 0) {
                normalNameBuilder.append(normalNames.get(normalNames.size() - 1));
            }

            if(shoutingNames.size() > 1){
                shoutingNamesBuilder.append("and ");
            }
            if(shoutingNames.size() > 0) {
                shoutingNamesBuilder.append(shoutingNames.get(shoutingNames.size() - 1));
            }

            String greeting =  "Hello, "+ normalNameBuilder.toString() + ".";
            if(shoutingNames.size() > 0){
                greeting = greeting + " AND HELLO " + shoutingNamesBuilder.toString() + "!";
            }
            return greeting;
        }
        return "";
    }
}
