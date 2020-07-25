import com.sun.xml.internal.ws.util.StringUtils;

public class Greeting {

    public static String greet() {
        return null;

    }

    public static String greet(String name) {
        if (name==null){
            return "Hello, my friend.";
        }
        if(name.equals(name.toUpperCase())){
            return "HELLO "+name+"!";
        }
        return "Hello, " + name + ".";

    }

    public static String greet(String[] name) {
        if (name==null){
            return "Hello, my friend.";
        }
        if(name.length == 2){
            return  "Hello, " + name[0] + " and " + name[1] + ".";
        }
        return "";
    }
}
