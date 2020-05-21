public class lengthEncryption 
{

    public static void main(String[] args) 
    {
        String inputText = "76f4<9=7";
        char [] outputText = new char [inputText.length()];

        for (int i = 0; i < inputText.length(); i++)
        {
            outputText[i] = (char)((int)inputText.charAt(i)-i);
        }

        for (char i : outputText)
        {
            System.out.print(i + "");
        }
    }   
}

