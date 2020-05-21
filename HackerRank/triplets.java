package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triplets 
{
    public static void main(String[] args) 
    {
        Integer [] aliceArray = new Integer [] {17 , 28 , 30 };
        Integer [] bobArray = new Integer [] {99, 16 , 8 };

        List<Integer> alice = Arrays.asList(aliceArray);
        List <Integer> bob = Arrays.asList(bobArray);

        System.out.println(compareTriplets(alice, bob));
    }

    public  static List <Integer> compareTriplets(List <Integer> a, List <Integer> b)
    {
        Integer [] aliceBobArray = new  Integer[] {0, 0};
        int aliceTemp = 0;
        int bobTemp = 0;

        for (int i = 0; i < a.size(); i++)
        {
            aliceTemp = a.get(i);
            bobTemp = b.get(i);

            if (aliceTemp > bobTemp)
            {
                aliceBobArray[0] += 1;
            }
            if (aliceTemp < bobTemp)
            {
                aliceBobArray[1] += 1;
            }
        }
        
        List <Integer> finalScore = Arrays.asList(aliceBobArray);
        
        return finalScore;

    }
    
}