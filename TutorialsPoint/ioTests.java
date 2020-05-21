package TutorialsPoint;

import java.io.*;

public class ioTests
{
    public static void main(String[] args)  throws IOException
    {
        //Stream:
        FileInputStream input = null;
        FileOutputStream output = null;

        try
        {
            input = new FileInputStream("C:/JavaSummer/TutorialsPoint/inputFile.txt");
            output = new FileOutputStream("C:/JavaSummer/TutorialsPoint/outputFile.txt");

            int character;
            while ((character = input.read()) != -1)
            {
                output.write(character);
            }
        }
        finally
        {
            if (input != null)
            {
                input.close();
            }
            if (output != null)
            {
                output.close();
            }
        }

    }
}
