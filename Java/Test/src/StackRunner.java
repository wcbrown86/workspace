import java.util.LinkedList;
import java.util.Stack;
public class StackRunner
{
   public static void main(String[] args)
   {
       LinkedList<String> myLinkedList1 = new LinkedList<String>();
       myLinkedList1.add("aaa");
       myLinkedList1.add("bbb");
       myLinkedList1.add("ccc");
       myLinkedList1.add("ddd");
       myLinkedList1.add("eee");
       // print the first linked list
       System.out.println("My Linked List 1:");
       
       for(String item: myLinkedList1){
    	   System.out.print(item + " ");
       }
       Stack<String> myStack = new Stack<String>();
       //Iterate through elements in the linked list (don't remove them), but 
       // push all the elements onto the stack
       
       for(String item: myLinkedList1){
    	   
    	   myStack.push(item);
       }

       //Pop all the stack elements off the stack and add them to
       // a new linked list
       LinkedList<String> list2 = new LinkedList<String>();
       
       while(!myStack.empty()){
    	   list2.add(myStack.pop());
       }

       //print the second linked list
       System.out.println("My LinkedList 2:");

       for(String item: list2){
    	   System.out.print(item + " ");
       }
   }
 }
