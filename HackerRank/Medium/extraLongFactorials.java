package HackerRank.Medium;

import java.math.BigInteger;
//Medium done on 20/05/2020
public class extraLongFactorials 
{
    
    public static void main(String[] args) 
    {
        
        getFactorial(30);

        System.exit(0);   
    }

    private  static  void getFactorial(int n)
    {
        BigInteger factorial = new BigInteger(String.valueOf(n));

        for (int i = n-1; i > 0; i--)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);

    }
}