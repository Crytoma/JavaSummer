package IntermediateJava;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ten {
    public static void main(String[] args) {
        Character [] ray = {'p', 'w', 'o'};

        List <Character> characterList = Arrays.asList(ray);
        

        System.out.println("List items are: ");

        output(characterList);

        //Reverse and print list
        Collections.reverse(characterList);

        System.out.println("Reversed list is: ");

        output(characterList);

        //Create a new list and array
        Character [] newRay = new Character[3];

        List <Character> listCopy = Arrays.asList(newRay);
        
        //Copy contents of list
        Collections.copy(listCopy, characterList);
        System.out.println("Copied list contains: ");
        output(listCopy);

        //Fill collection with crap
        Collections.fill(characterList, 'X');
        System.out.println("New filled list is: ");
        output(listCopy);

    }

    private static void output(List <Character> list)
    {
        for (Character thing : list)
        {
        System.out.printf("%s ", thing);
        }
    System.out.println();
    }

    


}