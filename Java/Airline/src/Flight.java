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
		
		while(!command.equalsIgnoreCase("quit")){
			System.out.println("Please enter one of the following commands");
			System.out.println("Add Passenger. ");
			System.out.println("Show seating. ");
			System.out.println("Quit.");
			
			command = userInput.nextLine();
			command = command.toLowerCase();
					
			switch(command){
			case "add passenger": 
				System.out.println("PLease enter the class: First or economy");
				String seatClass = userInput.nextLine();
				if(seatClass.equals("economy"))
				{
					System.out.println("Please enter the number of passengers traveling together up to 3 passengers:");
					int passengers = Integer.parseInt(userInput.nextLine());
					System.out.println("PLease enter the seating preference: Aisle, Middle, or Window.");
					String seating = userInput.nextLine();
					System.out.println(plane.findSeatsEconomy(passengers, seating));
				}
				else{
					
					System.out.println("Please enter the number of passengers traveling together up to 2 passengers:");
					int passengers = Integer.parseInt(userInput.nextLine());
					System.out.println("PLease enter the seating preference: Aisle or Window.");
					String seating = userInput.nextLine();
					System.out.println(plane.findSeatsFirst(passengers, seating));
				}
				break;
			
			case "show seating":
				flight.printSeating();
				break; 
				
			case "quit":
				break;
			
			default:
				System.out.println("Please enter a vaild command.");
				break;
			}
			
		}
		
		
	}

	private void printSeating() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < SEAT; i++){
			for(int j = 0; j < ROW; j++){
				System.out.print(plane.getSeat(i,j));
			}
			System.out.println("");
		}
		
	}

}
