package HackerRank.Easy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class JavaStaticBlockInitializer {
    public static boolean flag;
    public static int B;
    public static int H;

//Write your code here
static 
{
    Scanner sc = new Scanner(System.in);
    
                B = sc.nextInt();
                H = sc.nextInt();
                if (B > 0 && H > 0)
                {
                flag = true;
                }
    
            else 
            {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
            }
           
}



public static void main(String[] args)
{
        if(flag)
        {
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

