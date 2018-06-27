import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * This Class takes as an input a text file of numbers with each number on
 * a separate file. This file is read in and put into an array, then sorted 
 * using the insertion sort method. A runtime is shown in seconds. Then the sorted array 
 * is placed back into a text file with the same format. 
 */
public class InsertionSort {

	public static void  main(String[] arrgs) throws IOException{
		
		//Change text file as needed 
		String fileName ="RandomNumber100000.txt";
		//The file to be read
		Scanner file = new Scanner(new File(fileName));
		//The file used to find out how large of an array to make
		Scanner fileTest = new Scanner(new File(fileName));

		//Reads the number of lines in the file
		int lines = 0;
		while (fileTest.hasNextLine()){ 
			lines++;
			fileTest.nextLine();
		}
		//Makes the Array
		int[] array = new int[lines];
		
		//Places the numbers in the text file in an array
		for(int i = 0; i < array.length; i++){

			array[i] = file.nextInt();
		}
		//Saves the start time before running the sort
		long start = System.currentTimeMillis();
		//Runs the sort
		intsertionSort(array);
		//Saves the end time 
		long end = System.currentTimeMillis();
		//Takes the start time and end time prints out in the seconds format
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
		
		//Writes the array back to a file.
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter("InsertionSort"+ array.length + ".txt"));

		for(int i = 0; i < array.length; i ++){
			output.write(Integer.toString(array[i]));
			output.newLine();
		}
	}

	public static void intsertionSort(int[] arr){

		for(int i = 1; i < arr.length; i++){

			int temp = arr[i];
			int j;

			for(j = i - 1; j >= 0 && temp < arr[j]; j--){

				arr[j + 1] = arr[j];
			}

			arr[j + 1] = temp;

		}

	}

}
