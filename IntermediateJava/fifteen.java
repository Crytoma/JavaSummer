package IntermediateJava;

import java.util.PriorityQueue;

public class fifteen {
    public static void main(String[] args) {
        
        PriorityQueue <String> q = new PriorityQueue<String>();

        q.offer("first");
        q.offer("second");
        q.offer("third");

        System.out.printf("%s ", q);
        System.out.println();

        //Find what the highest priority element is.
        System.out.printf("%s ", q.peek());
        System.out.println();

        //Removes highest priority item.
        q.poll();
        System.out.printf("%s ", q);


    }

}