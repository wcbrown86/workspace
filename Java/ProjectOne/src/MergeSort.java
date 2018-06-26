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
 * using the merge sort method. A runtime is shown in seconds. Then the sorted array 
 * is placed back into a text file with the same format. 
 */
public class MergeSort 
{
	
	public static void  main(String[] arrgs) throws IOException{
		
		//Change text file as needed 
		String fileName ="RandomNumber1000000.txt";
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
		mergeSort(array,0,array.length);
		//Saves the end time 
		long end = System.currentTimeMillis();
		//Takes the start time and end time prints out in the seconds format
		System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
		//Writes the array back to a file.
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter("MergeSort"+ array.length + ".txt"));

		for(int i = 0; i < array.length; i ++){
			output.write(Integer.toString(array[i]));
			output.newLine();
		}
	}
	
	//Sorts the array with a recursive call on mergeSort to make the array smaller
	public static void mergeSort(int[] arr, int low, int high){
		//Finds the size of the array
		int N = high - low;        
		//Base case
		if (N <= 1) 
			return;
		//Splits the array
		int mid = low + N/2; 
		
		//Calls mergeSort with smaller array until only one element is in the array
		mergeSort(arr, low, mid); 
		mergeSort(arr, mid, high); 
		
		//Takes the smaller parts of the array and places them back in the array in a sorted order. 
		int[] temp = new int[N];
		int i = low, j = mid;
		for (int k = 0; k < N; k++){
			if (i == mid)  
				temp[k] = arr[j++];
			else if (j == high) 
				temp[k] = arr[i++];
			else if (arr[j]<arr[i]) 
				temp[k] = arr[j++];
			else 
				temp[k] = arr[i++];
		}    
		for (int k = 0; k < N; k++) 
			arr[low + k] = temp[k];         
	}

}