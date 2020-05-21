package CSDojo;

import java.util.*;
import java.util.stream.Collectors;

public class Problems
{
    public static void main(String[] args) 
    {

        int [] a = new int [] {-1,3,8,2,9,5};
        int [] b = new int [] {4,1,2,10,5,20};
        int target = 24;


        //closestToTarget(a, b, target);
        findBetterSolution(a, b, target);
        System.exit(0);
    }

    //Naive solution 0(n^2)
    //Find a pair from two array that is closest to desired target. 
    private static void closestToTarget(int [] a, int [] b, int target)
    {

        int [] closestPairA = new int [2];
        int [] closestPairB = new int [2];
        int tempA = a[0];
        int tempB = b[0];
        int tempC = a[0];
        int tempD = b[0];
        int sum = 0;
        int sumB = 0;
        int differenceB = 0;
        int difference = 0;

        for (int i = 0; i < a.length; i ++)
        {
            for (int j = 0; j < b.length; j++)
            {
                //Sum starts with -1 and 4 = 3
                sum = tempA + tempB;
                
                //Difference is 24 - 3  = 21
                difference = sum - target;

                //If current i + b - sum 
                if (a[i] + b[j] - difference > difference)
                {
                    tempA = a[i];
                    tempB = b[j];
                }
                System.out.println("A: " + tempA +  " " + "B: "+ tempB + " Sum: " + sum);

            }
        }


// If the difference from the sum of A  of sum B is smaller than it is now temp c and temp d become that pair.

for (int i = 0; i < a.length; i ++)
{
    for (int j = 0; j < b.length; j++)
    {
                // = 3
                sumB = tempC + tempD;

                //difference is 24 - 3 = 21
                differenceB = sum - target;

                //if current is less than 25 and it is greater than the previous we change.
                if (a[i] + b[j] > sumB && a[i] + a[j] != sum && a[i] + a[j] - differenceB <= target)
                {
                    tempC = a[i];
                    tempD = b[j];
                }
                System.out.println("C: " + tempC +  " " + "D: "+ tempD + " Sum: " + sumB);
            }
        }

        System.out.println();
        closestPairA[0] = tempA;
        closestPairA[1] = tempB;
        sum = tempA + tempB;

        System.out.println(closestPairA[0] + " " + closestPairA[1] + " Sum: " +  sum);

        System.out.println();

        closestPairB[0] = tempC;
        closestPairB[1] = tempD;
        sumB = tempC + tempD;
        System.out.println(closestPairB[0] + " " + closestPairB[1] + " Sum: " +  sumB);

    }

    public static void findBetterSolution(int [] a, int [] b, int target)
    {
        //Find a pair who's sum == 24.

        List <Integer> arrayA = Arrays
        .stream(a)
        .boxed()
        .collect(Collectors.toList());

        //Converting to List
        List <Integer> arrayB = Arrays
        .stream(b)
        .boxed()
        .collect(Collectors.toList());

        Arrays.sort(a);
        Arrays.sort(b);

        
        //Is there a pair that adds to 24.
        //How about 25 or 23?


        






    
        int i = 0;
        int j = 0;

        while (i < j)
        {
            if (arrayA.get(i) + arrayB.get(j) == target)
            {
                System.out.println(i + "" + j);
            }
            else if (arrayA.get(i) + arrayB.get(j) < target)
            {
                i += 1;
            }
            else if (arrayA.get(i) + arrayB.get(j) > target)
            {
                j -= 1;
            }
            else
            {
                System.out.println("Not found");
            }
        }

        
            
        }
    

}