import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class RandomGenerator {
	
	
	
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of random Integers you would like.");
		int number = in.nextInt();
		
		
		arr = randomGenerator(number);
		makeTextFile(arr);
		System.out.println("The file RandomNumber" + arr.length + ".txt was created");
	}
	
	private static void makeTextFile(int[] arr2) throws IOException {
		
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter("RandomNumber"+ arr2.length + ".txt"));

		for(int i = 0; i < arr2.length; i ++){
			output.write(Integer.toString(arr2[i]));
			output.newLine();
		}
		
		output.flush();
		output.close();
		
		
	}

	public static int[] randomGenerator(int numb){
	
		Random rand = new Random();
		arr = new int[numb];
		for(int i = 0; i < numb; i++){
			
			arr[i] = rand.nextInt(1000);
		}
		
		return arr;
	}
}
