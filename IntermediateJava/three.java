package IntermediateJava;

public class three {
    public static void main(String[] args) {

        int n = 5;
        System.out.println(n + " factorial is " + factorial(n));

    }

    public static long factorial(long n)
    {
        //Base case
        if (n <= 1)
        {
            return 1;
        }
        else
        {
            return n * factorial(n - 1);
        }
    }

}