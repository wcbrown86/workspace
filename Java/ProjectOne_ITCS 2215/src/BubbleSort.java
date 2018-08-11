/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This Class takes as an input a text file of numbers with each number on
 * 				a separate file. This file is read in and put into an array, then sorted 
 * 				using the bubble sort method. A runtime is shown in minutes and seconds. 
 * 				Then the sorted array is placed back into a text file with the same format. 
 *
 */

// Imports used for reading the file and creating a file.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Import used to track the time it takes for the program to run. 
import java.util.concurrent.TimeUnit;


public class BubbleSort {

	public static void  main(String[] arrgs) throws IOException{
		
		//Change text file as needed 
		String fileName ="RandomNumber100000.txt";
		//The file to be read
		Scanner file = new Scanner(new File(fileName));
		Scanner fileSize = new Scanner(new File(fileName));
  
		//Reads the number of lines in the file
		int lines = 0;
		while (fileSize.hasNextLine()){ 
			lines++;
			fileSize.nextLine();
		}
		//Makes the Array that is used to store the random numbers.
		int[] array = new int[lines];
		
		//Places the numbers in the text file in an array
		for(int i = 0; i < array.length; i++){

			array[i] = file.nextInt();
		}

		// Closes the file scanner object to maintain a lower memory useage.
		file.close();
		fileSize.close();


		//Saves the start time before running the sort
		long start = System.currentTimeMillis();
		System.out.println("Runing Sort");
		//Runs the sort
		bubbleSort(array);
		//Saves the end time 
		long end = System.currentTimeMillis();
		//Takes the start time and end time prints out in the seconds format
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
		
		//Writes the array back to a file.
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter("BubbleSort"+ array.length + ".txt"));

		// Writes the array to the file line by line.
		for(int i = 0; i < array.length; i ++){
			output.write(Integer.toString(array[i]));
			output.newLine();
		}
		

		// Clears the output stream and closes the file. 
		output.flush();
		output.close();
		
	}
	
	//Sorts the array using the bubble algorithm 
	public static void bubbleSort(int[] arr){
		int temp;

		for(int i = 0; i <arr.length - 1; i++){
			for(int j = 1; j < arr.length - i; j++){
				if(arr[j-1] > arr[j]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
