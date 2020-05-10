package IntermediateJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class twelve 
{
    public static void main(String[] args) 
    {

        String[] stuff = { "Stuff", "oranges", "banans", "pineapples", "chocolate Rain" };

        List<String> stringList = Arrays.asList(stuff);

        ArrayList <String> arrayList = new ArrayList<String>();

        arrayList.add("Stuff");
        arrayList.add("y-combinator");
        arrayList.add("googleer");

        for (String x : arrayList)
        {
            System.out.printf("%s ", x);
        }
        System.out.println();

        Collections.addAll(arrayList, stuff);

        for (String x : arrayList)
        {
            System.out.printf("%s ", x);
        }
        System.out.println();

        //Checks frequency of element in list.
        System.out.println(Collections.frequency(arrayList, "Stuff"));


        //Checks for common elements between two lists.
        boolean disjointBool = Collections.disjoint(stringList, arrayList);

        System.out.println(disjointBool);

        if (disjointBool)
        {
            System.out.println("These lists do not have anyhting in common");
        }
        if (!disjointBool)
        {
            System.out.println("These lists have an element in common.");
        }

    }

}