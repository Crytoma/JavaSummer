package HackerRank.Medium;

import java.util.Arrays;


/*
DATE: 20/05/2020
Purpose: Calculate and return the two largest valid pliuses that can be drawn on good cells in the newGrid + 
return an integer denoting the maximum product of the areas of the pluses. 
Author: Kacper M Rajchel
*/
public class EmmasSuperComputer
{
    public static void main(String [] arguments) 
    {
        String [] startingGrid2 = new String [] {

            "6",  "6",
    "BGBBGB",
    "GGGGGG",
    "BGBBGB",
    "GGGGGG",
    "BGBBGB",
    "BGBBGB"
            };


            String [] startingGrid1 = new String [] {

                "5", "6",
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
    
            };
    
        //System.out.println(twoPluses(newGrid));

        System.out.println(pluses(startingGrid2));

        System.exit(0);
    }

/*
NOTES::

    Grid size = n * m
    Valid Plus = "Crossing of two segments h, v of equal lengths with odd lengths."
    AKA: Built a program that justifies an expanding net from the center square in 4 sides good or bad.

                    +
    Good = +++
                    +

                    +
    Bad = ++++
                    +

    Goal: Find the two largest "pluses" and return an integer denoting the maximum product of their areas. 
    Eg.. Largest pluses may be of area 5 (example Good above) and 9 being bigger...
    Product  = 5x9 = 45.
    If char[i] == g its good else bad.
    NOTE: Two pluses cannot overlap and their product areas should be maximal.

*/


    private static int pluses(String [] grid)
    {
            //New grid without numbers.
        String [] newGrid = Arrays.copyOfRange(grid, 2, grid.length);
        
        int height  = Integer.parseInt(grid[0]);
        int width  = Integer.parseInt(grid[1]);


        char [] [] newCharGrid = new char [height] [width]; 

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                newCharGrid[i][j] = newGrid[i].charAt(j);
                System.out.print(newGrid[i].charAt(j));
            }   
            System.out.println(); 
        }
        System.out.println();

 /*       int plusSpan = 0;
        int plusArea = 0;
        int largestPlus = 1;
        int secondLargestPlus = 0;
        int x = 0;
        int y = 0;


        for (int i = 0 + plusSpan; i < height - plusSpan; i++)
        {
            for (int j = 0 + plusSpan; j < width - plusSpan; j++)
            {
                if (newCharGrid[i][j] == 'G')
                {
                    if (newCharGrid[i-plusSpan][j] == 'G' && newCharGrid[i+plusSpan][j] == 'G' && newCharGrid[i][j-plusSpan] == 'G' && newCharGrid[i][j+plusSpan] == 'G')
                    {
                        plusArea = ((plusSpan) * 4  + 1);
                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);

                      
                                boolean succeed = true;

                                while (succeed)
                                {
                                    int forceSpan = 0;

                                    if (newCharGrid[i-forceSpan][j] == 'G' && newCharGrid[i+forceSpan][j] == 'G' && newCharGrid[i][j-forceSpan] == 'G' && newCharGrid[i][j+forceSpan] == 'G')
                                    {
                                        plusArea = ((plusSpan) * 4  + 1);
                                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);
                                        forceSpan += 1;
                                    }
                                    else
                                    {
                                        succeed = false;
                                    }
                                }
                                
                     
                        if (plusArea > largestPlus)
                        {
                            largestPlus = plusArea;
                            x = j;
                            y = i;
                        }
                    }
                }
            }
        }


*/




int plusSpan = 0;
int plusArea = 0;
int largestPlus = 1;
int secondLargestPlus = 0;
int x = 0;
int y = 0;


        
        for (int i = 0 + plusSpan; i < height - plusSpan; i++)
        {
            for (int j = 0 + plusSpan; j < width - plusSpan; j++)
            {
                if (newCharGrid[i][j] == 'G')
                {

                   

                    while (plusSpan != 15)
                    {
                                        
                                    if (newCharGrid[i-plusSpan][j] == 'G' && newCharGrid[i+plusSpan][j] == 'G' && newCharGrid[i][j-plusSpan] == 'G' && newCharGrid[i][j+plusSpan] == 'G')
                                    {
                                        plusArea = ((plusSpan) * 4  + 1);
                                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);
                                        
                                    }

                                    plusSpan += 1;
                                
                                
                    }  
                     

                        if (plusArea > largestPlus)
                        {
                            largestPlus = plusArea;
                            x = j;
                            y = i;
                        }
                    }
                }
            }

        System.out.println();
        
        return 0;
    }    
}//End of EmmasSuperComputer class.



