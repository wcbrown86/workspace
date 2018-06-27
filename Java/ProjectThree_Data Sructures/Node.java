
public class Node {
	
	public Node left; 
	public Node right;
	public String data;
	
	public Node(String nodeData){
		
		data = nodeData;
		left = null;
		right = null;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public String getData(){
		return data;
	}

}
