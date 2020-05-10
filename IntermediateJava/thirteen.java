package IntermediateJava;

import java.util.Stack;

public class thirteen {
    public static void main(String[] args) {
        
        Stack <String> stack = new Stack <String> ();
        
        stack.push("Lolz");
        printStack(stack);
        stack.push("re");
        printStack(stack);
        stack.push("gg");
        printStack(stack);
        stack.pop();
        printStack(stack);

    }

    private static void printStack(Stack <String> stack)
    {
        if (stack.isEmpty())
        {
            System.out.println("Empty stack\n");
        }
        else

            System.out.printf("%s  <- Top of stack.\n", stack);
    }

}