package IntermediateJava;
//Collections

//34/04/2020

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class four {
    public static void main(String[] args) {
        String [] things = {"eggs", "lasers", "hats", "pictures"};
        String [] things2 = {"eggs", "carbs", "mugs", "pictures"};

        List <String>  thingList = new ArrayList<String>();

        List <String> thingList2 = new ArrayList<String>();


        //Adding array Items
        for (String thing : things)
        {
            thingList.add(thing);

        }

        for (String thing : things2)
        {
            thingList2.add(thing);
        }

        System.out.println(thingList);

        //Normal loop
        for (int i = 0; i < thingList.size(); i ++)
        {
            System.out.printf("%s ", thingList.get(i));
        }
        System.out.println();

        editList(thingList, thingList2);
    }


    //Use to find in text based game.
        public static void editList(Collection <String> list1, Collection <String> list2) 
        {
            Iterator <String> iterator = list1.iterator();
            while (iterator.hasNext())
            {
                if (list2.contains(iterator.next()))
                iterator.remove();
            }
            System.out.println(list1);
        }

    }

    