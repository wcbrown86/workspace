import java.util.Comparator;

public class Node implements Comparator<Node>{
	
	private int row, col, f, g, h, type;
	private Node parent;
   
	public Node(int r, int c, int t){
		row = r;
		col = c;
		//type 0 is traverseable, 1 is not
		setType(t);
		parent = null;
		
	}
	
	//mutator methods to set values
	public void setF(){
		f = g + h;
	}
	public void setG(int value){
		g = value;
	}
	public void setH(int value){
		h = value;
	}
	public void setParent(Node n){
		parent = n;
	}
	
	//accessor methods to get values
	public int getF(){
		return f;
	}
	public int getG(){
		return g;
	}
	public int getH(){
		return h;
	}
	public Node getParent(){
		return parent;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	
	public boolean equals(Object in){
		//typecast to Node
		Node n = (Node) in;
		
		return row == n.getRow() && col == n.getCol();
	}
   
	public String toString(){
		return "Node: " + row + "_" + col;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
