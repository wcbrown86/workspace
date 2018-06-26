/*
 * Student: William Chad Brown
 * ID: 800816688
 * Date: 01/25/2016
 * Section: ITCS-3112-091
 * 
 */
public class Ticket {
	
	String number;
	String name;
	String winner;
	

	public Ticket(String ticketNumber, String holderName){
		
		number = ticketNumber;
		name = holderName;
		winner = "No Prize Due";
	}
	
	public String getName(){
		return name; 
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String newNumber){
		number = newNumber;
	}
	
	public String getWinner(){
		return winner;
	}
	
	public void setWinner(String setWinner){
		winner = setWinner;
	}
}
