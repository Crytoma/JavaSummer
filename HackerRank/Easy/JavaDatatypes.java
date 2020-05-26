package HackerRank.Easy;

public class JavaDatatypes 
{
    public static void main(String[] args) 
    {

        
        checkFit(-150);
        checkFit(150000);
        checkFit(-1500000000);
     
        checkFit(-100000000000000l);

    }
        public static void checkFit(long x)
        {

            try
            {
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if (x >= -32768 && x <= 32767)System.out.println("* short");
                if (x >= - 2147483648l  && x <= 2147483647l)System.out.println("* int");
                if (x >= 9223372036854775807L  && x <= 9223372036854775807L)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(x+" can't be fitted anywhere.");
            }
    }

}