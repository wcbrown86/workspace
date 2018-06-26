import java.util.ArrayList;
import java.util.HashMap;

/*
 * Author: W. Chad Brown
 * Company: Brown Sound Inc.
 * Date: 06/06/13.
 * Version: 1.0.
 * 
 */

public class BandProfile 
{
	private HashMap<String,Shows> showList;
	private ArrayList<Upcoming> upcomingList;
	private Band band;
	private Shows shows;
	private Upcoming upcoming;
	
	/*
	 * 
	 */
	public BandProfile(String name, String gen, String web)
	{
		band = new Band(name,gen,web);
		showList = new HashMap<String, Shows>();
		upcomingList = new ArrayList<Upcoming>();
		
	}
	
	/*
	 * 
	 */
	public void setShows()
	{
		showList = Shows.scan(band.getWeb());
	}

}
