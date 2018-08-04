import java.util.Scanner;

public class Flight {

	static Scanner userInput = new Scanner(System.in);
	static Airplane plane;
	public static final int ROW = 20;
	public static final int SEAT = 8;
	
	public Flight() {
		// TODO Auto-generated constructor stub
		plane = new Airplane();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flight flight = new Flight();
		String command ="";
		
		while(!command.equalsIgnoreCase("quit") && !command.equals("3")){
			System.out.println("Please enter one of the following commands");
			System.out.println("1. Add Passenger. ");
			System.out.println("2. Show seating. ");
			System.out.println("3. Quit.");
			
			command = userInput.nextLine();
			command = command.toLowerCase();
			clear();
			
			switch(command){
			case "add passenger":
			case "1":
				boolean correctClass = false;
				while(!correctClass) {
				System.out.println("PLease enter the class: First or economy");
					String seatClass = userInput.nextLine();
					if(seatClass.equals("economy") || seatClass.equals("1")){	
						correctClass = true;
						boolean correctNumPassengers = false;
						
						do {
							System.out.println("Please enter the number of passengers traveling together up to 3 passengers:");
							int passengers = parseInt(userInput.nextLine());
							if(passengers != -1 && passengers <= 3 && passengers > 0) {
								correctNumPassengers = true;
								System.out.println("PLease enter the seating preference: Aisle, Middle, or Window.");
								String seating = userInput.nextLine();
								System.out.println(plane.findSeatsEconomy(passengers, seating.toUpperCase().charAt(0)));
							} else
								System.out.println("Incorrect selection.");
								
						}while(!correctNumPassengers);
						
					}else{
						
						correctClass = true;
						System.out.println("Please enter the number of passengers traveling together up to 2 passengers:");
						int passengers = parseInt(userInput.nextLine());
						if(passengers != -1 && passengers <= 2 && passengers > 1) {
							System.out.println("PLease enter the seating preference: Aisle or Window.");
							String seating = userInput.nextLine().trim();
							if(seating.toUpperCase().equals("WINDOW") || seating.toUpperCase().equals("AISLE"))
								System.out.println(plane.findSeatsFirst(passengers, seating.toUpperCase().charAt(0)));

							else
								System.out.println("Incorrect selection.");
						
						}else if(passengers == 1)
							System.out.println(plane.findSeatsFirst(passengers, 'A'));
						else
							System.out.println("Incorrect selection.");
					}
				}
				break;
			
			case "show seating":
			case "2":
				flight.printSeating();
				break; 
				
			case "quit":
			case "3":
				System.out.println("Good Bye!");
				break;
			
			default:
				System.out.println("Please enter a vaild command.");
				break;
			}
			
		}
		
		
	}

	/**
	 * This function is used to show the current state of the planes seating.
	 * This function can be called by the user from the main screen. 
	 * When the information is printed to the screen it is formatted in a way 
	 * that it will show the plane with row numbers along the top and first class 
	 * on the right of the screen. 
	 */
	private void printSeating() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < SEAT; i++){
			for(int j = 0; j < ROW; j++){
				System.out.print(plane.getSeat(i,j));
			}
			System.out.println("");
		}
		
	}
	
	/**
	 * This function is used to clear the screen after the user enters the required information.
	 * It is intended to keep the console screen neat and easier to read.
	 * 
	 * TODO: 1. The function does not currently work with the current code. fix the function to 
	 * 			resolve this issue.
	 */
	private static void clear() {
		System.out.printf("\033[H\033[2J");
	}
	
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	private static int parseInt(String i) {
		int num = 0;
		
		try {
			num = Integer.parseInt(i);
			return num;
			
		} catch(Exception e) {
			return -1;
		}
	}

}
