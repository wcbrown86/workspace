import java.util.Random;

public class Store{
   
   
   
   public static void main(String[] args){
      PriorityQueue q = new PriorityQueue();
      int count = 0;
      Random rand = new Random();
      
      do{
      
         if(rand.nextInt(4)+1 == 1){
            q.add(new PriorityCustomer());
            System.out.println("New Customer Added, there are currently " + q.size() + " customers in line");
         }
         
         if(q.size() != 0){
            if(q.current().getServiceTime() < 0){
               q.remove();
               System.out.println("Customer served there are currently " + q.size() + " customers in line");
            }else
               q.current().decServiceTime(); 
         }      
         
         System.out.println("----------------");
         count++;
      }while(count < 60);  
   }
}