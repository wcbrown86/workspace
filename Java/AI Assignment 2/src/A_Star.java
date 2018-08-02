import java.util.Scanner;

/**
 * @author williambrown
 *
 */
public class A_Star {

	private static int size = 15;
	public static GameBoard board; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		board = new GameBoard(size);
		board.print();
		showMenu();
		
	}

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
