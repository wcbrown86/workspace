/**
 * @author William Chad Brown
 * 
 * Description:	This class is used to store the information about each location on the grid.
 * 				the node stores x, y, huristic information, and type. 
 */
import java.util.Comparator;

public class Node implements Comparator<Node>{
	
	// Global variables
	private int row, col, f, g, h, type;
	// Parent is used for the trace back of the path found. 
	private Node parent;
   
	// Constructor that asks for x, y, and type.
	public Node(int r, int c, int t){
		row = r;
		col = c;
		//type 0 is traverseable, 1 is not
		setType(t);
		parent = null;
		
	}
	
	// Set f function calculates huristic information. 
	public void setF(){
		f = g + h;
	}
	
	/**
	 * Set method for G, this information is used for 
	 * calculating the huristic information. 
	 * 
	 * @param value - is the value of G.
	 */
	public void setG(int value){
		g = value;
	}

	/**
	 * Set H method. This information is used to calculate the 
	 * final huristic information. 
	 * 
	 * @param value - the value of H as deturmed by the manhattan method. 
	 */
	public void setH(int value){
		h = value;
	}

	/**
	 * Set parent method is used to back trace the path that was found with the 
	 * search function of A Star.
	 * 
	 * @param n - is the node information from the node behind it. 
	 */
	public void setParent(Node n){
		parent = n;
	}
	
	// Get Method for F
	public int getF(){
		return f;
	}
	//Get method for G
	public int getG(){
		return g;
	}
	// Get method for H
	public int getH(){
		return h;
	}
	// Get method for Parent Node
	public Node getParent(){
		return parent;
	}
	// Get method for Row
	public int getRow(){
		return row;
	}
	// Get method for Colum. 
	public int getCol(){
		return col;
	}
	
	@Override
	// override equals method from super. 
	public boolean equals(Object in){
		//typecast to Node
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	// toString method used for printing information about the node
	public String toString(){
		return "Node: " + row + "_" + col;
	}

	// Returns the type of the node. 
	public int getType() {
		return type;
	}

	/**
	 * Set type method, this is used to deturmine if the node is traversable. 
	 * 
	 * @param type - this type can be two items. either 0 for traversable and 1 for blocked. 
	 */
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compare(Node o1, Node o2) {
		return 0;
	}
	
}
