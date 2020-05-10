package IntermediateJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sixteen {
    public static void main(String[] args) {
        
        String [] things = {"apple", "steve", "jeeve", "apple", "steve"};
        List <String> list = Arrays.asList(things);



        System.out.printf("%s ", list);
        System.out.println();

        //Sets cannot have duplicates.
        Set <String> set = new HashSet<String>(list);
        //Output will be without duplicates.
        System.out.printf("%s ", set);

        
        
    }

}