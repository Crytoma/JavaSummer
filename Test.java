import java.util.*;

public class Test
       {
           public static void main(String[] arguments) 
           {
               int socks = 9;
               int [] colorArray = new int [] {10,20,20,10,10,30,50,10,20};
               System.out.println(sockMerchant(socks, colorArray));
               System.exit(0);
           }

           //If the element is present in the array at an even amount we add 1
           private static int sockMerchant(int n, int [] ar)
           {
               int amountOfSocks = n;
               int socksToSell = 0;
               int count = 0;

               List <Integer> soc = new ArrayList <Integer>();

                for (int i = 0; i < ar.length; i ++)
                {
                    for (int j = 0; j < ar.length; j ++)
                    {
                        if (ar[i] == ar[j])
                        {
                            count += 1;
                        }
                    }
                }

            return soc.size();

            }
}