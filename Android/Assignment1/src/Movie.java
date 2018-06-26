/*
 * Assignment 1
 * William Chad Brown
 * 
 * Movie Class, this object holds the information from the file.
 * the information is stored in variables relating to the information needed
 * 
 * overrides:
 * 		compareTo()
 * 		toString() 
 */
public class Movie implements Comparable<Movie>{
	
	private String title;
	private int year, grossingSales;
	
	public Movie(int movieYear, String movieTitle, int movieSales) {
		
		year = movieYear;
		title = movieTitle;
		grossingSales = movieSales; 
		
	}
	
	public void addYear(int movieYear){
		year = movieYear;
	}
	
	public int getYear(){
		
		return year;
	}
	
	public void addTitle(String movieTitle){
		
		title = movieTitle;
		
	}
	
	public String getTitle(){
		
		return title;
		
	}
	
	public void addSales(int movieSales){
		
		grossingSales = movieSales;
	}
	
	public int getSales(){
		
		return grossingSales;
		
	}
	

	@Override
	//Override the compareTo method to have it compare the year in descending order
	public int compareTo(Movie compareMovie) {
		//grabs the year information to be compared 
		int compareYear = compareMovie.getYear();
		//compares the information in descending order.
		return compareYear-this.year;
		
	}
	
	@Override
	//Override of the toString Method to help with printing. 
	public String toString(){
		
		return "Year: " + year + " Title: " + title + " Sales: " + grossingSales;
	}

}
