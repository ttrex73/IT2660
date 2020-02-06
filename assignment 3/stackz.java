import java.io.*;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class stackz
{
   static void stack_push(Stack<Integer> stack, int a)
   {
     stack.push(new Integer(a)); 
     System.out.println("push(" + a + ")");
     System.out.println("stack: " + stack);
      
      
     }
   static void stack_peek(Stack<Integer> stack)
   {
      Integer element=(Integer) stack.peek();
      System.out.println("the element on top of the stack is: " + element);   
   }
   static void stack_pop(Stack<Integer> stack)
   {
      System.out.println("pop: ");
      Integer y = (Integer) stack.pop();
      System.out.println(y);
      System.out.println("stack: " + stack);
     
   }
  static void stack_search(Stack<Integer> stack, int element)
  {
   int pos= (Integer) stack.search(element);
   if(pos== -1)
         System.out.println("the element is not found");
   else
      System.out.println("the element is not found at the position " + pos);
}

   public static void main (String[] args) 
    { 
        Stack<Integer> stack = new Stack<Integer>(); 
  
        stack_push(stack, 42); 
        stack_push(stack, 55); 
        stack_push(stack, 72); 
        stack_peek(stack);
        stack_pop(stack);
        stack_pop(stack);
        stack_pop(stack);
        
        stack_search(stack, 2); 
        stack_search(stack, 6); 
    } 
} 