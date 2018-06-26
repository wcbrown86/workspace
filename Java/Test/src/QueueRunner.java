import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner
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
       
       System.out.println("");
       Queue<String> queue = new LinkedList<String>();
       
       for(String item: myLinkedList1){
    	   
    	   queue.add(item);
       }
       
       LinkedList<String> list2 = new LinkedList<String>();
       
       while(!queue.isEmpty()){
    	   
    	   list2.add(queue.remove());

       }
       
       for(String item: list2){
    	   System.out.print(item + " ");
       }
       
       
       
   }
}
   