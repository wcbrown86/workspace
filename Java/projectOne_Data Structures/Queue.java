public class Queue{
    
    public Customer first; 
    public Customer last; 
    public int count;
    
    public Queue(){
        first = null;
        last = null;
        count = 0;
    }
    
    public void addCustomer(Customer c){
        if(isEmpty())
            first = c;
        else
            last.setNext(c);
            
        last = c;
        count++;
    }
    
    public void removeCustomer(){
    
      if(!isEmpty()){
         first = first.getNext();
         count--;
      }
         
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
}