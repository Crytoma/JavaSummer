package HackerRank;

public class AVeryBigSum 
{
    public static void main(String[] args)
    {
        long [] ar = new long [] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        System.out.println(aVeryBigSum(ar));
        System.exit(0);
    }
    
    //Calculate and print the sum of the elements in an array, 
    //keeping in mind that some of those integers may be quite large.
    public static long aVeryBigSum(long [] ar)
    {
        long sum = 0;
        for (int i = 0; i < ar.length; i++)
        {
            sum += ar[i];
        }
        return sum;
    }
}