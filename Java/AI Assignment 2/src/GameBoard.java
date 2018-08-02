import java.util.Random;

/**
 * @author William Chad Brown
 *
 * Discription:	The GameBoard class is responsible for creating, maintaining, and printing the board. 
 * 				At the start of the program a random board is set. Then the user is given the chance 
 * 				to change the start and goal locations. The board is labeled with 'S', 'G', and '1'. 'S'
 * 				denotes the starting location of the program, 'G' denotes the goal location. Then 
 * 				'1' denotes obsticales that the progam must avoid. The borad is created with 10% of 
 * 				the board is obsticals that must be navigate around. Each of the locations also have
 * 				a huristic applied using the Manahattan method. This huristic is used be the A Star 
 * 				search algorithim to find the best path. 
 * 
 * TODO: 		1. Change the generate board function. The use of nested for loop is slow. Change to 
 * 				a system that will generate random numbers and check if that combination is open. Then 
 * 				repeat this the number of times required. 
 * 
 * 				2. Add better formatting to the print function to help with the visual looks and readablility
 * 				   of the printed board. 
 * 
 */

public class GameBoard {
	
	//Global variables. 
	private Node[][] board; 
	private Node start, goal;
	private Random random; 
	
	/**
	 * Constructor, this is called at the start of the game and will randomly 
	 * set the start and goal locations. 
	 * 
	 * @param size is used to deturmine the size of the nxn game board. 
	 * Currently this size is set to a default of 15. 
	 * 
	*/
	public GameBoard (int size) {

		// The board is a 2d array of class Node
		board = new Node[size][size];

		// Creates a random number generator to create the start and goal location
		random = new Random();
		
		// Creation of the start and goal location. 
		start = new Node(random.nextInt(size), random.nextInt(size), 0);
		goal = new Node(random.nextInt(size), random.nextInt(size), 0);
		
		// Calls the generateBoard function to create the locations of 
		// obsticals and adds the labels to each location for printing. 
		generateBoard(size); 
	}

	/** 
	 * The function deturmines how many blocked locations need to be added 
	 * and then rnadomly places these locations on the board. The other parts
	 * of the board are set to '0'. 
	 * 
	 * @param size is the same size from the constructor. This size is used to 
	 * deturmine the number of blocked locations that must be created. 
	 */
	private void generateBoard(int size) {
		// block stores the number of location that can not be passed over
		// the current number of blocked location is 10% opf the nxn locations.
		int blocked = (int)((size*size) * .1); 

		// random number generator. 
		random = new Random();
		int rand= 0;
		
		// Nested for loop that cycles through the grid and places the obsticals
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				// generates a random number between 0 and 99, and if that number is divisible 
				// by 6 then a obstical is placed in this location. 
				rand = random.nextInt(100);
				if((rand % 6 == 0) && (blocked > 0) && 
						(start.getRow() != i && start.getCol() != j) &&
						 (goal.getRow() != i && goal.getCol() != j)){
					board[i][j] = new Node(i,j,1);
					blocked--;
				}
				else
					// Sets all other locations to '0'
					board[i][j] = new Node(i,j,0);
				//setting hurisic for the node, using the Manhattan method. 
				board[i][j].setH((Math.abs(goal.getCol() - i)) + (Math.abs(goal.getRow() - j)));
			}
		}
		//System.out.println(blocked);
	}
	
	/** 
	 * Print board function. It looks at each not and prints the grid to the screen. I will check 
	 * for the start, goal, and obstical locations and prints the correct symbol for each location. 
	 */
	public void print(){
		
		// Nested for loop that looks at each location and prints to the screen.
		for(int i = -1; i < board.length; i++ ){
			if(i >= 0)
				//Prints the index of each row to help with visual locations.
				System.out.print(i);
			for(int j = 0; j < board.length; j++){
				
				// Prints the colum location to help with visual locations. 
				if(i == -1){
					System.out.print("  " + j);
				// Checks to see if the location is an obstical. and prints a '1'.
				} else if(board[i][j].getType() == 1){
					System.out.print(" 1 ");
				// Checks to see if the location is the start location and prints 'S'.
				} else if(i == start.getCol() && j == start.getRow()){
					System.out.print(" S ");
				// Checks to see if the location is the goal location and prints 'G'.
				} else if (i == goal.getCol() && j == goal.getRow()){
					System.out.print(" G ");
				// All other locations are printed as a '0'.
				} else {
					System.out.print(" 0 ");
				}
			}
			// Creates a newline charater for screen formatting. 
			System.out.println("");
		}
	}

	// Get Start location node method.
	public Node getStart() {
		return start;
	}

	/**
	 * Set start location method.
	 * 
	 * @param start is a node ojbect that will need to contain the x, y, and charater 
	 * information. 
	 */
	public void setStart(Node start) {
		this.start = start;
	}

	// get goal loaction node metod. 
	public Node getGoal() {
		return goal;
	}

	/**
	 * Set goal location method.
	 * 
	 * @param start is a node ojbect that will need to contain the x, y, and charater 
	 * information. 
	 */
	public void setGoal(Node goal) {
		this.goal = goal;
	}	
}
