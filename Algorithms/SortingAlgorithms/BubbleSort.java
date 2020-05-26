package Algorithms.SortingAlgorithms;



public class BubbleSort 
{
    public static void main(String [] arguments)
    {
        int [] unsortedArray = new int [] {4,21,32,1,2,4,5,6,432,2,2,2};
        int n = unsortedArray.length;
        
        System.out.println(optimizedBubbleSort(unsortedArray, n));

        System.exit(0);
    }

    //
    //An algorithm to sort a sequence of elements
    public static void myBubbleSort(int [] unsortedArray)
    {
        for (int i = 0; i < unsortedArray.length - 1; i++)
        {
            for (int j = 0; j < unsortedArray.length - i - 1; j++)
            {
                if (unsortedArray[j] > unsortedArray[j+1])
                {
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j+1];
                    unsortedArray[j+1] = temp;
                }
            }
        }
    }

    public static int [] optimizedBubbleSort(int [] arr, int n)
    {
        int i = 0;
        int j = 0;
        int temp = 0;
        boolean swapped = false;

        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = true;
            }
        }
        return arr;
    }
}




