

/*
 * Author: W. Chad Brown
 * Company: Brown Sound Inc.
 * Date: 06/06/13.
 * Version: 1.0.
 * 
 * This class keeps track of the show that are still current while removing the shows that 
 * have already past or that have been canceled.
 *  
 */
public class Shows {

	private String date;
	private String venue;
	private String [] otherBands;
	private boolean canceled; 
	private String time;
	
	public Shows(String date, String time, String venue, String [] otherBands, boolean canceled)
	{
		this.setDate(date); 
		this.setVenue(venue);
		this.setOtherBands(otherBands);
		this.setCanceled(canceled);
		this.setTime(time);
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String [] getOtherBands() {
		return otherBands;
	}

	public void setOtherBands(String [] otherBands) {
		this.otherBands = otherBands;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
