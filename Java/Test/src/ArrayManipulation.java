public class ArrayManipulation
{
   public static void main(String[] args)
   {
      Integer[] a = { 1, 2, 3, 4, 5, 6, 7 };
      Character[] b = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
      Double[] c = { 1.0, 2.0, 3.3, 4.4, 5.9, 8.7 };
      print(a);
      reverse(a);
      print(a);
      print(b);
      reverse(b);
      print(b);
      print(c);
      reverse(c);
      print(c);
   }

   public static <T> void print(T[] x)
   {
	   String print = "";
      // Fill in your code here
	   for(int i = 0; i < x.length; i ++){
		   
		   print += x[i].toString() +  " ";
		   
	   }
	   
	   System.out.println(print);
   }

   // Add a reverse method here 
   public static <T> void reverse(T[] x){
	   
	   for(int i = 0; i < x.length / 2; i++){
		   
		   T temp = x[i];
		   x[i] = x[x.length - 1 - i];
		   x[x.length - 1 - i] = temp;
	   }
	   
   }
}