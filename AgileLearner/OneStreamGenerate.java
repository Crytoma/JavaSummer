package AgileLearner;

import java.util.*;
import java.util.stream.Stream;

public class OneStreamGenerate 
{
    public static void main(String[] args) 
    {
        Random random = new Random();
        //Infinite amount of elements here.
        Stream <Integer> stream = Stream.generate(() -> random.nextInt());
        printSize(stream);
    }

    public static void printSize(Stream <Integer> stream)
    {
        System.out.println(stream.count());
    }
}
