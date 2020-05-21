package Java8;

import java.util.*;
import java.util.function.Consumer;

public class TasteOfLambdas 
{
    public static void main(String[] args) 
    {
        //Function usually has 4 things
        //1. name
                //2. Parameter list
                //3. body
        //4. return type

        //Now we have a function with the most important bits. A paramter list and body.
        Thread th = new Thread(() ->  System.out.println(" In another thread"));
        th.start();

        System.out.println("In main");

        //When you create a lambda expression it automatically gets invokedynamic 
        //when you call it.


        //imperitive way
        List <Integer> numbers = Arrays.asList(1, 2 , 3, 4, 5, 6, 7, 8, 9 , 10);

        //external iterators. //Familiar for - loop not a simple for loop.
        for (int i =0; i < numbers.size(); i++)
        {
            System.out.println(numbers.get(i));
        }

        //external iterator also. //external as you control the iteration.
        for (int i : numbers)
        {
            System.out.println(i);
        }

        //internal iterator.  //polymorphism hide the iteration method.
        numbers.forEach(new Consumer <Integer>()
        {
            public void accept(Integer value)
            {
                System.out.println(value);
            }
        });


        //internal iterator on autopilot. //never to say what's obvious in life.
        numbers.forEach((Integer value) -> System.out.println(value));


        //Java 8 has type interaface, for lambda expressions!!
        numbers.forEach((value) -> System.out.println(value));
        

         //parenthesis is optional, but only for ONE parameter lambdas. 
        numbers.forEach(value -> System.out.println(value));


        //Java programmers never write stupid code. Always invent IDE's to vomit stupid code.
        numbers.forEach(System.out :: println);
        // :: is method reference syntax. 


        //While lambdas are cute keep them that way. Do not overcomplicate them.
    

        //Lambdas are glue code!!!! Two lines may be too many.
        //The point is a mess can be made out of the code if it is too complicated with lambdas.
            //1. Code becomes hard to read!.
            //2. It's noisy and cluttery.
            //3. Leads to duplication.
            //4. Becomes really hard to test with logic in lambda. Have logic in function.

        

        




    }
}