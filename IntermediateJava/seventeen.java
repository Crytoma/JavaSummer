package IntermediateJava;

public class seventeen {
    public static void main(String[] args) {
        Integer [] integerArray = {1,2,3,4};
        String [] stringArray = {"stuff", "string", "cut"};
       

        printMe(integerArray);
        printMe(stringArray);

        System.out.println(maxComparison(2421,2142,12321));
        System.out.println(maxComparison('v','f','g'));


    }

    //Generic method.
    public static <T> void printMe(T [] integerArray)
    {
        for (T x : integerArray)
        {
            System.out.printf("%s, ", x);
        }
        System.out.println();
    }

    //Generic method that returns generic data.
    public static <T extends Comparable<T>>  T maxComparison(T a, T b, T c)
    {
        T largestVariable = a;

        if (b.compareTo(a) > 0)
        {
            largestVariable = b;
        }
        if (c.compareTo(largestVariable) > 0)
        {
            largestVariable = c;
        }
        return largestVariable;
    }

}