package IntermediateJava;
import java.util.*;
import java.util.ArrayList;

public class five {
    public static void main(String[] args) {
        String [] things = {"apple", "rowers", "linkEdlist", "feta cheese"};
        List <String> list1 = new LinkedList <String>();

        for (String thing : things)
        {
            list1.add(thing);
        }

        String [] things2 = {"sauce", "boss", "nobueno", "Gato Barbieri", "feta cheese"};
        List <String> list2 = new LinkedList <String>();

        for (String thing : things2)
        {
            list2.add(thing);
        }

        //Built in method linking list.
        list1.addAll(list2);
        list2 = null;

        printMe(list1);
        removeThings(list1, 2,5);

        printMe(list1);

        reverseMe(list1);

    }

    private static void printMe(List <String>list1)
    {
        for (String s : list1)
        {
            System.out.println(s);
        }
    }

    private static void removeThings(List <String> list1, int lowerBound, int higherBound)
    {
        list1.subList(lowerBound, higherBound).clear();
    }

    private static void reverseMe(List <String> list1)
    {
        ListIterator <String> iterator = list1.listIterator(list1.size());
        while (iterator.hasPrevious())
        {
            System.out.printf("%s ", iterator.previous());

        }
    }
}