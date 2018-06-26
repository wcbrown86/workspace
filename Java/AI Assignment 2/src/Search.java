import java.util.HashSet;
import java.util.PriorityQueue;

public class Search {
	
	private PriorityQueue<Node> openList; 
	private HashSet<Node> closedList;
	GameBoard board;

	
	public Search(int size, GameBoard board){
		
		this.board = board; 
		
		openList = new PriorityQueue<Node>(size);
		closedList = new HashSet<Node>();
		
	}
}
