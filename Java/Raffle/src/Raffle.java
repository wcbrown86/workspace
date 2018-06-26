/*
 * A driver (main class) as well as a programmer-defined class must be used.
 * The main program (driver) should ask the user to enter the winning 6 digit number. 
 * Do this only once. Input from the keyboard, the ticket holder’s name and his/her six 
 * digit ticket number. Analyze the ticket to see if it is a winner using the rules for winning above. 
 * If the ticket is a winner, display a message indicating the prize winner and the holder’s name. 
 * Continue to process tickets until there are no more. 
 * 
 * When all tickets have been processed, display the total number of first prize winners, 
 * second prize winners, and third prize winners.
 * 
 * Student: William Chad Brown
 * ID: 800816688
 * Date: 01/25/2016
 * Section: ITCS-3112-091
 * 
 */
import java.util.Scanner;

public class Raffle {
	
	static Ticket[] ticketArray = new Ticket[100]; 
	static Scanner userInput = new Scanner(System.in);
	static int index = 0;
	
	//The winning number must be set here. 
	static String winningNumber = "123456";
	
	//Asks the user for the ticket information, continues this loop until the user is done
	//Once the user is done the system will check the numbers for winners, then prints 
	//This information. 
	public static void main(String[] args) {
		
		char cont = 'Y';

		
		while (cont == 'Y'){
			
			System.out.println("PLease enter the ticket number!");
			String ticketNumber = userInput.nextLine();
			
			System.out.println("Please enter the ticket holders name!");
			String holdersName = userInput.nextLine();
			
			if(index < ticketArray.length)
				ticketArray[index] = new Ticket(ticketNumber, holdersName);
			else{
				increaseSize();
				ticketArray[index] = new Ticket(ticketNumber, holdersName);
			}
				
			
			index++;
			
			System.out.println("Do you have more teckets to check? Y/N");
			cont = userInput.nextLine().toUpperCase().charAt(0);
		}
		
		index = 0;
		for(int i = 0; i < ticketArray.length && ticketArray[i] != null; i++)
			checkWinner(ticketArray[i]);
		
		printArray();

	}
	
	//Prints the Ticket numbers and if a prize is due to the console.
	private static void printArray() {
		
		for(int i = 0; i < ticketArray.length && ticketArray[i] != null; i++){
			System.out.println("Name: " + ticketArray[i].getName() + ", Ticket Number: "
					+ ticketArray[i].getNumber() + ", Prize: " + ticketArray[i].getWinner());
		}
		
	}

/*
 * First Prize – The six digit number on the ticket exactly matches the winning number.
 * Example: If the number on the ticket is 123456, it is a winner if the winning number is 123456.
 * 
 * Second Prize – The reverse of the 6 digit number on the ticket exactly matches the winning number.
 * Example: If the number on the ticket is 654321, it is a winner if the winning number is 123456. 
 */
	private static void checkWinner(Ticket check) {
		
		String number = check.getNumber();
		if(number.equals(winningNumber))
			check.setWinner("First Prize");
		else if(number.equals(stringReverse(winningNumber)))
			check.setWinner("Second Prize");
		else if(thirdPrize(check))
			check.setWinner("Third Prize");
		
	}
	/*
 	* Third Prize – Any 3 sequential digits of the 6 digit number on the ticket exactly matches 3 sequential 
 	* digits in the same position of the winning ticket.
 	* Example: If the number on the ticket is 123456, it is a winner if the winning number has 123 in 
 	* positions 1 – 3, 234 in positions 2 – 4, 345 in positions 3 – 5, or 456 in positions 4 – 6.
 	*/

	private static boolean thirdPrize(Ticket check) {
		
		char[] temp = check.getNumber().toCharArray();
		char[] winner = winningNumber.toCharArray();
		for(int i = 1; i <= 4; i++){
			boolean isWinner = false; 
			for(int j = i; j < (i+3) && j < temp.length + 1; j++){
				if(winner[j-1] != temp[j-1]){
					isWinner = false;
					break;
				}
				else
					isWinner = true;
				
				
			}
			if(isWinner)
				return true;
		}
		return false;
	}
	
	//Reverse the ticket number, then returns this number
	private static String stringReverse(String winning) {
		char[] tempArray = winning.toCharArray();
		String temp = ""; 
		
		for(int i = tempArray.length - 1; i >= 0; i--){
			temp += "" + tempArray[i];
		}
		return temp;
	}
	
	//Grows the size of the array if needed. Double each time.
	private static void increaseSize() {
		
		Ticket[] temp = new Ticket[ticketArray.length * 2];
		
		for(int i = 0; i < ticketArray.length; i++){
			temp[i] = ticketArray[i];
		}
		
		ticketArray = temp;
		
	}

}
