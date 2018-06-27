import java.util.Random;

/**
 * @author williambrown
 *
 */
public class GameBoard {
	
	private Node[][] board; 
	private Node start, goal;
	private Random random; 
	
	
	public GameBoard (int size) {

		board = new Node[size][size];
		random = new Random();
		
		start = new Node(random.nextInt(size), random.nextInt(size), 0);
		goal = new Node(random.nextInt(size), random.nextInt(size), 0);
		
		generateBoard(size); 
	}

	private void generateBoard(int size) {
		// TODO Auto-generated method stub
		int blocked = (int)((size*size) * .1); 
		random = new Random();
		int rand= 0;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				rand = random.nextInt(100);
				if((rand % 6 == 0) && (blocked > 0) && 
						(start.getRow() != i && start.getCol() != j) &&
						 (goal.getRow() != i && goal.getCol() != j)){
					board[i][j] = new Node(i,j,1);
					blocked--;
				}
				else
					board[i][j] = new Node(i,j,0);
				//setting hurisic for the node, using the Manhattan method. 
				board[i][j].setH((Math.abs(goal.getCol() - i)) + (Math.abs(goal.getRow() - j)));
			}
		}
		//System.out.println(blocked);
	}
	
	public void print(){
		
		for(int i = 0; i < board.length; i++ ){
			for(int j = 0; j < board.length; j++){
				if(board[i][j].getType() == 1){
					System.out.print(" 1 ");
				} else if(i == start.getCol() && j == start.getRow()){
					System.out.print(" S ");
				} else if (i == goal.getCol() && j == goal.getRow()){
					System.out.print(" G ");
				} else {
					System.out.print(" 0 ");
				}
			}
			System.out.println("");
		}
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getGoal() {
		return goal;
	}

	public void setGoal(Node goal) {
		this.goal = goal;
	}	
}
