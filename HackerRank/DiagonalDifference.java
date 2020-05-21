package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference 
{
    public static void main(String [] arguments) 
    {
        List<List<Integer>> listArray = new ArrayList<List<Integer>>();


        ArrayList<Integer> list0 = new ArrayList <Integer>();
        list0.add(3);
        listArray.add(list0);

        ArrayList<Integer> list1 = new ArrayList <Integer>();
        list1.add(11);
        list1.add(2);
        list1.add(4);
        listArray.add(list1);

        ArrayList<Integer> list2 = new ArrayList <Integer>();
        list1.add(4);
        list1.add(5);
        list1.add(6);
        listArray.add(list2);

        ArrayList<Integer> list3 = new ArrayList <Integer>();
        list1.add(10);
        list1.add(8);
        list1.add(-12);
        listArray.add(list3);

        //System.out.println(diagonalDifference(listArray));
        //int [] [] array = {{3}, {11,2,4}, {4,5,6}, {10,8,-12} };

        System.out.println(diagonalDifference(listArray));

        System.exit(0); 
    }

    //Given a square matrix, calculate the absolute difference
    //between the sums of its diagonals.
    private static int diagonalDifference(List<List<Integer>> arr)
    {
        int leftToRightDiagonalSum = 0;
        int rightToLeftDiagonalSum = 0;
        for (int i = 1; i < arr.size(); i++)
        {//Magic was using j += 4 to move 4 places.
            for (int j = 0; j < arr.get(i).size(); j+=4)
            {
                leftToRightDiagonalSum += arr.get(i).get(j);
            }
        }   
        for (int i = 0; i < arr.size(); i++)
        {//Magic was using j += 4 to move 4 places.
            for (int j = 2; j < arr.get(i).size() - 2; j+=2)
            {
                rightToLeftDiagonalSum += arr.get(i).get(j);
            }
        }
        return Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
    }





    private static int diagonal2DArray(List<List<Integer>> arr)
    {
        int [] [] array = new int [][] { 
        {arr.get(0).get(0)},
        {arr.get(1).get(0), arr.get(1).get(1), arr.get(1).get(2)}, 
        {arr.get(2).get(0), arr.get(2).get(1), arr.get(2).get(2)}, 
        {arr.get(3).get(0), arr.get(3).get(1), arr.get(3).get(2)}};
        
        int leftDiag = 0;
        int rightDiag = 0;
        int column = 1;
        int row = 2;
        for (int i = 0; i < array.length - 1; i++)
        {
            //System.out.println(arr[column][i]);
            leftDiag += array[column][i];
            column += 1;
        }
        for (int i = 1; i < array.length; i++)
        {
           // System.out.println(arr[i][row]);
            rightDiag += array[i][row];
            row -= 1;
        }
        System.out.println();
        return Math.abs(leftDiag - rightDiag);
    }
}




