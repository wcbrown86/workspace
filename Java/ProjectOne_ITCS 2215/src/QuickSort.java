
public class QuickSort {

    int[] array;

    public QuickSort(String fileName){

        try{
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
			array = new int[lines];
			
			//Places the numbers in the text file in an array
			for(int i = 0; i < array.length; i++){

				array[i] = file.nextInt();
			}

			// Closes the file scanner object to maintain a lower memory useage.
			file.close();
			fileSize.close();


			//Saves the start time before running the sort
			long start = System.currentTimeMillis();
            System.out.println("Runing Quick Sort");
            
			//Runs the sort
            QuickSort();
            
			//Saves the end time 
            long end = System.currentTimeMillis();
            
			//Takes the start time and end time prints out in the seconds format
			System.out.println(TimeUnit.MILLISECONDS.toMinutes(end - start) + " Minutes");
			System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + " Seconds");
			System.out.println(TimeUnit.MILLISECONDS.toMillis(end - start) + " Milliseconds\n");
			
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
		} catch (Exception e){
			System.out.println(e.toString());
			System.exit(0);
		}
    }

    public void quickSort(){

    }

    public int[] getArray(){

        return array;

    }

}
