package HackerRank.Easy;

public class Formatting {

    public static void main(String[] args) {

        System.out.println("================================");
        
        shit("java", 100);
        shit("cpp", 65);
        shit("python", 50);

        System.out.println("================================");
    }


    public static void shit(String s1, int x)
    {
     


            String padding = "%" + (15 - s1.length()) + "d\n";

            if (x < 100)
            {
                System.out.printf("%s" + padding, s1, x);
            }

            else if (x > 99)
            {
            System.out.printf("%s%15d\n", s1, x);
            }


    }        
}