import java.util.Scanner;

/**
 * @author williambrown
 *
 * Discription:	This is a program that will implement the A Star search algorithm.
 * 				This search will be preformed on a 2d Node array. When the program 
 * 				starts a default board of 15x15 with a set start and goal location.
 * 				The user is then prompted to either change the start/goal, both, or 
 * 				continue. 
 * 
 * TODO:		1. Implement A Start search algorithm.....
 * 
 * 				2. Update menu to allow the user to set the size of the grid and a 
 * 				   start and goal location. Or to create a random one of size 15. 
 */
public class A_Star {

	private static int size = 15;
	public static GameBoard board; 
	
	/**
	 * Main method for the program. A new board of size 15x15 is created. The 
	 * board is printed and then the menu is shown to the user. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		board = new GameBoard(size);
		board.print();
		showMenu();
		
	}

	/**
	 * The show menu function is used to allow the user to change the start, end, or both locations. 
	 * If the user does not want to change any other the locations then the user can select continue. 
	 * If the user continues the search will start. 
	 */
	public static void showMenu(){
		char cont = 'N';
		
		while(cont == 'N'){
			
			System.out.println("Start Node " + board.getStart().getCol() + ", " + board.getStart().getRow());
			System.out.println("Goal Node " + board.getGoal().getCol() + ", " + board.getGoal().getRow());
			System.out.println("Would you like to set a new start and/or goal location?"
					+ "\n  1. Set new start location."
					+ "\n  2. Set new goal location."
					+ "\n  3. Set new start and goal location."
					+ "\n  4. Continue with current locations.");
			
			Scanner scanner = new Scanner(System. in); 
			String input = scanner.nextLine();
			
			try{
				int x = 0;
				int y = 0;
				
				switch (Integer.parseInt(input)){
					case 1: 
						
						System.out.println("Please enter a new starting x location.");
						input = scanner.nextLine();
						x = Integer.parseInt(input);
						
						System.out.println("Please enter a new starting y location.");
						input = scanner.nextLine();
						y = Integer.parseInt(input);
						
						if((x < size) && (x >= 0) && (y < size) && (y >= 0)){
							board.setStart(new Node(x,y,0));
						} else {
							System.out.println("Invalid number/s entered please enter a number between 0 and " + size);
						}
						
						cont = 'y';
						
						board.print();
						System.out.println("Start Node " + board.getStart().getCol() + ", " + board.getStart().getRow());
						System.out.println("Goal Node " + board.getGoal().getCol() + ", " + board.getGoal().getRow());
						
						break;
					case 2: 
						
						System.out.println("Please enter a new goal x location.");
						input = scanner.nextLine();
						x = Integer.parseInt(input);
						
						System.out.println("Please enter a new goal y location.");
						input = scanner.nextLine();
						y = Integer.parseInt(input);
						
						if((x < size) && (x >= 0) && (y < size) && (y >= 0)){
							board.setGoal(new Node(x,y,0));
						} else {
							System.out.println("Invalid number/s entered please enter a number between 0 and " + size);
						}
						
						cont = 'y';
						
						board.print();
						System.out.println("Start Node " + board.getStart().getCol() + ", " + board.getStart().getRow());
						System.out.println("Goal Node " + board.getGoal().getCol() + ", " + board.getGoal().getRow());
						
						break;
						
					case 3:
						
						System.out.println("Please enter a new starting x location.");
						input = scanner.nextLine();
						x = Integer.parseInt(input);
						
						System.out.println("Please enter a new starting y location.");
						input = scanner.nextLine();
						y = Integer.parseInt(input);
						
						if((x < size) && (x >= 0) && (y < size) && (y >= 0)){
							board.setStart(new Node(x,y,0));
						} else {
							System.out.println("Invalid number/s entered please enter a number between 0 and " + size);
						}
						
						System.out.println("Please enter a new goal x location.");
						input = scanner.nextLine();
						x = Integer.parseInt(input);
						
						System.out.println("Please enter a new goal y location.");
						input = scanner.nextLine();
						y = Integer.parseInt(input);
						
						if((x < size) && (x >= 0) && (y < size) && (y >= 0)){
							board.setGoal(new Node(x,y,0));
						} else {
							System.out.println("Invalid number/s entered please enter a number between 0 and " + size);
						}
						
						cont = 'y';
						
						board.print();
						System.out.println("Start Node " + board.getStart().getCol() + ", " + board.getStart().getRow());
						System.out.println("Goal Node " + board.getGoal().getCol() + ", " + board.getGoal().getRow());
						
						break;
					case 4:
						
						cont = 'y';
						break;
						
					default:
						System.out.println("Invalid input entered, please enter a number from 1-4.");
						break; 
						
						
				}
				
			} catch(Exception e){
				System.out.println("Invalid input entered, please enter a number from 1-4.");
			}
			
			scanner.close();
		}

	}

}
