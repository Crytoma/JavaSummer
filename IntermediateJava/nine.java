package IntermediateJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nine {
    public static void main(String[] args) {
        
        String [] crap = {"crap", "stuff", "juicy lemons", "geese", "jainme"};
        List <String> l1 = Arrays.asList(crap);
        
        Collections.sort(l1);

        System.out.printf("%s\n", l1);

        Collections.sort(l1, Collections.reverseOrder());
        System.out.printf("%s\n", l1);

        
    }

}