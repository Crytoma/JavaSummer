package Algorithms.SortingAlgorithms;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort 
{
    public static void main(String[] args) 
    {
        int [] unsortedArray = new int [] {3,5,8,1,2,9,4,7,6};
        quickSort(unsortedArray);
        System.exit(0);
    }

    private static void quickSort(int [] unsortedArray)
    {
        int length = unsortedArray.length;
        int pivot = ThreadLocalRandom.current().nextInt(0, length);
        int leftMarker = unsortedArray[0];
        int rightMarker = unsortedArray[length - 1];
        boolean sorted = false;
        int temp = 0;

        if (leftMarker == pivot)
        {
            leftMarker = unsortedArray[pivot + 1];
        }

        if (rightMarker == pivot)
        {
            rightMarker = unsortedArray[pivot - 1];
        }


        while (sorted != true)
        {
            for (int i = 0; i > length; i++)
            {//When the left marker reaches a number than is <= pivot
                while (!(unsortedArray[leftMarker] >= unsortedArray[pivot]))
                {
                    if (unsortedArray[leftMarker] == unsortedArray[rightMarker])
                    {
                        temp = unsortedArray[leftMarker];
                        unsortedArray[leftMarker] = unsortedArray[pivot];
                        unsortedArray[pivot] = temp;   
                    }
                    else
                    {
                    leftMarker += 1;
                    }
                        //If num at right marker is less than the pivot point it stops.
                        while(!(unsortedArray[rightMarker] > unsortedArray[pivot]))
                        {
                            if (unsortedArray[leftMarker] == unsortedArray[rightMarker])
                            {
                                temp = unsortedArray[leftMarker];
                                unsortedArray[leftMarker] = unsortedArray[pivot];
                                unsortedArray[pivot] = temp;   
                            }
                            else
                            {
                                rightMarker -= 1;
                            }
                        }
                temp = unsortedArray[leftMarker];
                unsortedArray[leftMarker] = unsortedArray[rightMarker];
                unsortedArray[rightMarker] = temp;
                sorted = true;
                    }
                }
            }
        }
}