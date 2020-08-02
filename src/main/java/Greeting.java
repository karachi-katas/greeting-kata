public class Greeting {

    private String greetOne(String name) {
        if (guest(name)) {
            return "Hello, my friend.";
        }
        if (shoutAt(name)) {
            return "HELLO {name}!".replace("{name}", name);
        }
        return "Hello, {name}.".replace("{name}", name);
    }

    private boolean shoutAt(String name) {
        return name.toUpperCase().equals(name);
    }

    private boolean guest(String name) {
        return name == null;
    }

    public String to(String... names) {
        if (names == null) {
            return "Hello, my friend.";
        }

        if (names.length == 1) {
            return greetOne(names[0]);
        }

        if (names.length == 3) {
            return "Hello, {name1}, {name2}, and {name3}."
                    .replace("{name1}", names[0])
                    .replace("{name2}", names[1])
                    .replace("{name3}", names[2]);
        }

        if (names.length == 4) {
            return "Hello, {name1}, {name2}, {name3}, and {name4}."
                    .replace("{name1}", names[0])
                    .replace("{name2}", names[1])
                    .replace("{name3}", names[2])
                    .replace("{name4}", names[3]);
        }

        return "Hello, {name1} and {name2}."
                .replace("{name1}", names[0])
                .replace("{name2}", names[1]);
    }
}
