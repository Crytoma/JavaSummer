import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamJava8 
{
    
    public static void main(String[] args) 
    {
        
        //1. Integer streams.
        IntStream.range(0, 10).forEach(System.out :: print);
        
        //2. Integer Stream with skip
        IntStream.range(0, 10).skip(7).forEach(x -> System.out.println(x));

        //3. Integer stream with sum
        System.out.println(IntStream.range(0, 10).sum());

        //4. Stream.of, sorted and findFirst. Can pass in own comparator for sorted function too
        Stream.of("Chocolate", "Cucumber", "Jefferson Plane").sorted().findFirst().ifPresent(System.out :: println);

        //5.  Stream from array sort, filter and print.
        String [] things = {"Jeff", "Prisma", "Sony Tri-Master", "ROM CHIP", "Defunct"};
        Arrays.stream(things).filter(x -> x.startsWith("S")).sorted().forEach(System.out :: println);

        //6. Average of squares of an int array.
        Arrays.stream(new int [] {3,4,5,6,4,3,6,3,6,8,5,3})
        .map(x -> x * x)
        .average()
        .ifPresent(System.out :: println);
    
        //Stream from a List, filter and print
        List <String> things2 = Arrays.asList("Chocolate", "triangles", "tesselation", "void");
        things2
        .stream()
        .map(String :: toLowerCase)
        .filter(x -> x.startsWith("v"))
        .forEach(System.out :: println);

        //Short cut to get statistics off of a List.
        List <Integer> data = Arrays.asList(3,5,654345,5643532,43425,25,65363,764745,6523432);
        IntSummaryStatistics stats = data
        .stream().mapToInt((x) -> x).summaryStatistics();
        
        System.out.println((int) data
        .stream()
        .distinct()
        .filter(i -> data
        .contains(i))
        .count());

        System.out.println("Sum = " + stats.getAverage());

    }

}