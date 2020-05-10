package IntermediateJava;

public class one
{
    public static void main(String [] arguments)
    {
        String [] words = {"funk", "ball", "wow", "kalishko", "fumes", "pork", "coconut"};

        for (String w : words)
        {
            if (w.startsWith("fu"))
            {
                System.out.println(w + " starts with fu");
            }
        }

        for (String w : words)
        {
            if (w.endsWith("k"))
            {
                System.out.println(w + " ends with k");
            }
        }
    }
}