package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;

public class FormingMagicSquare 
{
    public static void main(String[] arguments) 
    {
        int [] [] s = new int [] [] { {5, 3, 4}, {1, 5, 8}, {6, 4, 2} };
        System.out.println(formingMagicCircle(s));
        System.exit(0);
    }

    //We define a magic square to be an  matrix of distinct positive
     //integers from  to  where the sum of any row, column, or diagonal 
     //of length  is always equal to the same number: the magic constant
    private  static int formingMagicCircle(int [] [] s)
    {
        int tempCollector = 0;
        int one = 0;
        int two = 0;
        int three= 0;

        List <Integer> rowResult = new ArrayList<Integer>();
        List <Integer> columnResult = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length; i++)
        {
            for (int j = 0; j < s.length; j++)
            {
                tempCollector += s[i][j];
                if (j == 0)
                {
                    one += s[i][j];
                }
                else if (j == 1)
                {
                    two += s[i][j];
                }
                else if (j == 2)
                {
                    rowResult.add(tempCollector);
                    tempCollector = 0;
                    three += s[i][j];
                }
            }
        }
        columnResult.add(one);
        columnResult.add(two);
        columnResult.add(three);

        System.out.println("Results of row sums:");
        for (int i : rowResult)
        {
            System.out.println(i + " ");
        }

        System.out.println();

        System.out.println("Results of column sums:");
        for (int i : columnResult)
        {
            System.out.println(i + " ");
        }

        System.out.println();
 
        numInCommon(rowResult, columnResult);
        //Checking for most common number sum
        
        return 0;

    }   

    public static void numInCommon(List <Integer> rowResult, List <Integer> columnResult)
    {
        IntSummaryStatistics stats = rowResult.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println((int) rowResult.stream().distinct().filter(i -> columnResult.contains(i)).count());





        
    }













}