package Edabit;

public class Challenges 
{
    public static void main(String [] arguments) 
    {


        
        System.exit(0);
    }




    //Create a method that takes an array of integers and returns a new array, sorted in ascending order (smallest to biggest).
    //Sort integer array in ascending order.
    //If the function's argument is null, an empty array, or undefined; return an empty array.
    //Return a new array of sorted numbers.
    /*
go through array once
pick the first number in array. If it is smaller than another number in the array put it in the start of new array
or at  i. 
else carry on with the loop. Pickup second number etc until you get to the end.
*/
    public static void sortNumsAscending(int [] nums)
    {
        
    }




    //Check for a consecucutive character in String.
    public static boolean doubleLetters(String word)
    {
        boolean consecutiveLetters = false;
        for (int i = 0; i < word.length() -1; i++)
        {
            if (word.charAt(i) == word.charAt(i + 1))
            {
                consecutiveLetters = true;
            }
        }
        return consecutiveLetters;
    }
    

    //Create a function that takes three integer arguments (a, b, c) and returns 
    //the amount of integers which are of equal value.
    public static int equal(int a, int b, int c)
    {
        int occurence = 0;
        //Three shift of integers for comparison.
        if (a == b && a == c)
        {
            occurence = 3;
        }
        else if (a != b && a != c && b != c)
        {
            occurence = 0;
        }
        else
        {
            occurence = 2;
        }

        return occurence;
        
    }

    //Format a phone number properly.
    public static String formatPhoneNumber(int [] nums)
    {
        String front = "";
        String preEnd = "";
        String endEnd = "";

        for (int i = 0; i < nums.length; i++)
        {
            if (i < 3)
            {
                front += nums[i];
            }
            else if (i < 6)
            {
                preEnd += nums[i];
            }
            else if (i < 10)
            {
                endEnd += nums[i];
            }
        }
        return "("+front+")" + " " + preEnd + "-" + endEnd;
    }

    /*
    Create a function that takes a string, checks if it has the 
    same number of x's and o's and returns either true or false.
    Return a boolean value (true or false).
    The string can contain any character.
    When no x and no o are in the string, return true.
    */
    public static boolean getXO (String str)
    {
        int o_Count = 0;
        int x_Count = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'x' || str.charAt(i) == 'X')
            {
                x_Count += 1;
            }
            else if (str.charAt(i) == 'o' || str.charAt(i) == 'O')
            {
                o_Count += 1;
            }
        }
        if (o_Count == 0 && x_Count == 0)
        {
            return true;
        }
        else if (o_Count == x_Count)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    //Create a method that takes a string and returns the 
    //word count. The string will be a sentence.
    public static int countWords(String s)
    {
        int wordCount = 1;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                wordCount += 1;
            }
        }
        return wordCount;
    
    }



    //Create a method that accepts a string (of a person's first and last name) 
    //and returns a string with the first and last name swapped.
    public static String nameShuffle(String s)
    {
        String firstName = "";
        String lastName = "";
        String shuffledName = "";
        boolean firstNameFinished = false;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ' && !firstNameFinished )
            {
                firstName += s.charAt(i);
            }
            else if (s.charAt(i) == ' ')
            {
               firstNameFinished = true;
                continue;
            }
            else 
            {
                lastName += s.charAt(i);
            }

        }
        shuffledName += lastName + " " + firstName;
        return shuffledName;
    }


    //Create a function that takes a string 
    //and returns a string with spaces in between all of the characters.
    //NOTE: Treat a space as its own character (i.e. leave three spaces between words).
    public static String spaceMeOut(String str)
    {
        String spacedString = "";
        char space = ' ';
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != space && i != str.length() - 1)
            {
            spacedString += str.charAt(i);
            spacedString += space;
            }
            else if (str.charAt(i) == space)
            {
                spacedString += space;
                spacedString += space;
            }
            else
            {
                spacedString += str.charAt(i);
            }
        }

        return spacedString;
     
    }



    //Reverses a given String.
    public  static String reverseStringMethod(String str)
    {
        char [] charArray = new char [str.length()];
        int position = 0;
        for (int i = charArray.length - 1; i >= 0;  i--)
        {
            charArray[position] = str.charAt(i);
            position += 1;
        }
        String reversedStr = String.copyValueOf(charArray);
        return reversedStr;
    }

    
    //If the first string ends with the second return true else false
    public static boolean checkEnding(String a, String b)
    {
        if (a.endsWith(b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Return true if two rooks can capture each other by sharing either a column or row
    //Assuming no pieces are blocking one another.
    public static boolean canCapture(String [] rooks)
    {
        String rook1 = rooks[0];
        String rook2 = rooks[1];

        if ( rook1.substring(0, 1).equals(rook2.substring(0,1)) || rook1.substring(1, 2).equals(rook2.substring(1,2)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}