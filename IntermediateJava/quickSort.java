package IntermediateJava;

import java.util.List;
import java.util.Arrays;
/*
To find the middle pivot and put anything 
> pivot to the right and 
< pivot to the left.
Repeat the same to both sides pivots.
*/
import java.util.Collections;

public class quickSort 
{

    public static void main(String[] arguments) 
    {

    int [] numberArray = new int [] {2, 5, 4, 2, 99, 4314, 431, 7, 93};
    
    //Initialise postion of middle pivot
    int countRight = 0;
    int countLeft = 0;
    int pivotPos = 0;
    int middlePos = numberArray.length/2;
    //Create a new array to store one side of the sorted pivot.
    int [] tempArrayRight = new int[numberArray.length];
    int [] tempArrayLeft = new int[numberArray.length];


        for (int i = 0; i >= numberArray.length; i ++)
        {
            
            if ((numberArray[i]) >= (numberArray[middlePos]))
            {
                tempArrayRight[countRight] = numberArray[i];
                countRight += 1;
            }
            else
            {
                tempArrayLeft[countLeft] = numberArray[i];
                countLeft += 1;
            }

        }

        printIntArray(numberArray);

        printIntArray(tempArrayRight);
        System.out.println(numberArray[numberArray.length/2]);
    }


    public static int [] sortArray(int [] a)
    {
        int [] sortedArray = new int [a.length];

        return sortedArray;
    }

    public static void printIntArray(int [] a)
    {
        for (int i : a)
        {
            System.out.printf("%s ", i);
        }
        System.out.println();
    }



    public static void quickerSort(int [] a)
    {



    }

}