package HackerRank.Easy;

public class JavaLoopsII 
{
    public static void main(String[] args) 
    {
        //Amount of queries in the form...
        int a = 5;
        int b = 3;
        //Limit on the series
        int n= 5;

        for (int i = 0; i < n; i++)
        {
            a += b;
            System.out.print(a + " ");
            b *= 2;
        }
    }    
}