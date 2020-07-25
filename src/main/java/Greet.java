public class Greet {

//    public String greet(String name) {
//        if (name == null) {
//            return "Hello, my friend.";
//        }
//        if (isUpperCase(name)){
//            return "HELLO " + name + "!";
//        }
//        return "Hello, " + name + ".";
//    }

    public String greet (String... names){

        if (names == null) {
            return "Hello, my friend.";
        }
        if (names.length == 1 && isUpperCase(names[0])){
            return "HELLO " + names[0] + "!";
        }

        if (names.length == 1){
            return "Hello, " + names[0] + ".";
        }

        return greetMultipleNames(names);
    }

    private String greetMultipleNames(String[] names) {
        StringBuilder greeting = new StringBuilder("Hello");

        for (int i = 0; i < names.length - 1; i++){
            greeting.append(", " +names[i]);
        }

        greeting.append(" and " + names[names.length-1] + '.');

        return greeting.toString();
    }

    private boolean isUpperCase(String text) {
        return text.equals(text.toUpperCase());
    }
}
