import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractice 
{
    public static void main(String[] args) 
    {
        List <Integer> listOfNumbers = Arrays.asList(1,2,3,4,5, 1, 1);

        List <Integer> square = listOfNumbers
        .stream()
        .map(x -> x * x)
        .collect(Collectors.toList());

        System.out.println(square);



        listOfNumbers
        .stream()
        .map(x -> x * x)
        .forEach(System.out :: print);


        int even = 
        listOfNumbers
        .stream()
        .filter(x -> x % 2 == 0)
        .reduce(0, (ans, i) -> ans + 1);

        System.out.println(even);

        System.exit(0);
    }
}