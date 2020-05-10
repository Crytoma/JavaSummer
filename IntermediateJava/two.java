package IntermediateJava;

public class two {
    public static void main(String[] args) {
        String string = "helowmyfirendhowareyoudoingthsiusitpedusingaqwertykeyboard";

        int startIndexOfQwerty = string.indexOf("qwerty");
        int endIndexOfQwerty = string.lastIndexOf("y");

        String a = "Wow";
        String b = "                                       Now";

        System.out.println(startIndexOfQwerty);
        System.out.println(endIndexOfQwerty);
        System.out.println(string.substring(startIndexOfQwerty, endIndexOfQwerty));


        System.out.println(a.concat(" " + b.trim()));

        System.out.println(a.replace("ow", "owzers"));

        System.out.println(a.replace("ow", "owzers").toUpperCase());

        System.out.println(b.trim());

    }

}