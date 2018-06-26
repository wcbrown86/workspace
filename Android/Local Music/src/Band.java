
/*
 * Author: W. Chad Brown
 * Company: Brown Sound Inc.
 * Date: 06/06/13.
 * Version: 1.0.
 * 
 * This class sets up the parameters for the band with a HashMap of all the shows
 * that the band currently has lister. Then a arrayList of any up coming items.
 */

public class Band 
{
	private String bandName;
	private String genre;
	private String webSite;
	
	/*
	 * Constructor. Takes two parameters both strings. Sets up the name of the 
	 * band and the genre. Makes the HashMap of shows and the arrayList of 
	 * upcoming events. 
	 */
	public Band(String name, String gen, String web)
	{
		bandName = name;
		genre = gen;
		webSite = web;
	}
	
	/*
	 * 
	 */
	public void setName(String name)
	{
		bandName = name;
	}
	
	/*
	 * 
	 */
	public void setGenre(String gen)
	{
		genre = gen;
	}
	
	
	/*
	 * 
	 */
	public String getName()
	{
		return bandName;
	}
	
	/*
	 * 
	 */
	public String getGenre()
	{
		return genre;
	}
	
	/*
	 * 
	 */
	public String getWeb()
	{
		return webSite;
	}
	
	/*
	 * 
	 */
	public void setWeb(String web)
	{
		webSite = web;
	}

}
