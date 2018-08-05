/**
 * 
 * @author William Chad Brown
 * 
 * Date: June, 2017
 * 
 * Description:	Driver class that is used to parse the information in the file, movies.csp
 * 				and place the information into the desired data structures. In this case the 
 * 				program will use a HashMap with a key of a char and the values will be an ArrayList
 * 				of type String. The Key is used to store movies titles in alphabetical order. and the
 * 				values is a list of all the movies who's title starts with that letter. This program does
 * 				not take into account "The" in a title. So all movies starting with "The" will be stored 
 * 				under the key value of 'T'. 
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Main {
	
	public static ArrayList<Movie> movieList = new ArrayList<Movie>();
	public static HashMap<Character, ArrayList<String>> movieMap = new HashMap<Character, ArrayList<String>>();
	public static String filename = "topmovies.csv";

	//Calls each method needed to grab the movies, then print the movies as required.
	public static void main(String[] args) {
		
		
		//pulls the information for the provided file and places the information in the data structures
		parseMovie();
		//Prints out the list information by year descending order
		System.out.println("Movies Listed by Year in Descending Order");
		printYearDecendingOrder();
		//Prints out the list where movies are listed by the fist letter, no order.
		System.out.println("Movies listed by the first letter of there title");
		printMoviesAlphbeticly();

	}
	
	//opens the file provided and grabs the information in the file, after information is passed to 
	//two different data structures. One is stored in an ArrayList, the other is a HashMap with an
	//ArrayList as the value and a key of a Character
	public static void parseMovie(){
	      // Lets make sure the file path is not empty or null
        if (filename == null || filename.isEmpty()) {
               System.out.println("Invalid File Path");
               return; }
        String filePath = System.getProperty("user.dir") + "/" + filename;
        BufferedReader inputStream = null;
        // We need a try catch block so we can handle any potential IO errors
        try {
               try {
                      inputStream = new BufferedReader(new FileReader(filePath));
                      String lineContent = null;
                      // Loop will iterate over each line within the file.
                      // It will stop when no new lines are found.
                      while ((lineContent = inputStream.readLine()) != null) {
                    	  //Calls the method that puts the information in the data structures
                    	  addMovies(lineContent);
                          //System.out.println("Found the line: " + lineContent);
                      } 
                    }
               // Make sure we close the buffered reader.
               finally {
                      if (inputStream != null)
                            inputStream.close();
               }
        	} 
        	catch (IOException e) {
               e.printStackTrace();
        	}// end 
		
	}


	private static void addMovies(String lineContent) {
		//Stores passed information in a String array. information is split a the token ','
		String[] resultingInformation = lineContent.split(",");
		//if statement to skip the first line of information
		if(!resultingInformation[0].equals("Year")){
			//takes the string array and trims the extra white space and stores the 
			//information in separate variables bases off the information value.
			int year = Integer.parseInt(resultingInformation[0].trim());
			String title = resultingInformation[1].trim();
			int sales = Integer.parseInt(resultingInformation[2].trim());
			//Creates the key needed for the HashMap
			Character key = new Character(title.charAt(0));
			//Adds the information to the ArraryList
			movieList.add(new Movie(year, title, sales));
			//Adds the information to the HashMap 
			if(movieMap.get(key) == null){
				//Creates the key value pair if not already created
				movieMap.put(key, new ArrayList<String>());
				
			}
			//Adds another value to the key if already created. 
			movieMap.get(key).add(title);
			
		}
		
	}
	
	//Sorts the ArrayList in descending order and prints the information
	private static void printYearDecendingOrder(){
		
		//uses the Collections.sort, calls the compareTo method in the Movie Class
		Collections.sort(movieList);
		//for loop that prints the information
		for(Movie str: movieList){
			
			System.out.println(str);
			
		}
	}
	
	//Prints the HashMap to the screen with the key. 
	private static void printMoviesAlphbeticly() {
		//for loop that prints the key then the information in the ArraryList
		
		for(Map.Entry<Character, ArrayList<String>> movie : movieMap.entrySet()){
			String key = movie.getKey().toString().toUpperCase();
			System.out.print(key + ": ");
			ArrayList<String> movieTitle = movie.getValue();
			//if there is more than one item in the ArrayList then this for loop prints all items.
			if(movieTitle.size() > 0){
				for(String str: movieTitle){
				
				System.out.print(str + ", ");
				}
			//If only one item this will print just the one item
			}else{
				System.out.print(movieTitle.get(0));
			}
			//Formatting, adds lines to make it easier to read. 
			System.out.print("\n");
		}
		
	}

}
