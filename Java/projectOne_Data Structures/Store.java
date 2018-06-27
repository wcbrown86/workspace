import java.util.Random;

public class Store{
   
   
   
   public static void main(String[] args){
      Queue q = new Queue();
      int count = 0;
      Random rand = new Random();
      
      do{
      
         if(rand.nextInt(4)+1 == 1){
            q.addCustomer(new Customer());
            System.out.println("New Customer Added, there are currently " + q.count + " customers in line");
         }
         
         if(q.first != null){
            if(q.first.getServiceTime() < 0){
               q.removeCustomer();
               System.out.println("Customer served there are currently " + q.count + " customers in line");
            }else
               q.first.decServiceTime(); 
         }      
         
         System.out.println("----------------");
         count++;
      }while(count < 60);  
   }
}