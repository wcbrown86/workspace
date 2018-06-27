import java.io.*;
import java.util.Scanner;
public class SortingTest {
	
	public static void  main(String[] arrgs) throws FileNotFoundException{
		
		String fileName ="";
		Scanner file = new Scanner(new File(fileName));
		
		int lines = 0;
		while (file.hasNext() != false) lines++;
		
		int[] array = new int[lines]; 
		
		for(int i = 0; i < array.length; i++){
			
			array[i] = file.nextInt();
			
			long start = System.currentTimeMillis();
			
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			
			start = System.currentTimeMillis();
			
			end = System.currentTimeMillis();
			System.out.println(end - start);
			
			start = System.currentTimeMillis();
			
			end = System.currentTimeMillis();
			System.out.println(end - start);
		}
	}

}
