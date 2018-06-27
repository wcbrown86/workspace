
public class BinarySerachTree {
	
	public Node root;
	
	public BinarySerachTree(){
		root = null;

	}

	public void insert(String string) {
		// TODO Auto-generated method stub
		
		if(root == null && string != null)
			root = new Node(string);
		else if(string != null)
			root = add(root, string);
		
	}


	private Node add(Node root2, String string) {
		if (root.data.compareTo(string) > 0) {
		    if (root2.left != null) {
		        root2.left = add(root2.left, string);
		    } else {
		        root2.left = new Node(string);
		    }
		}
		else if (root.data.compareTo(string) < 0) {
		    if (root2.right != null) {
		        root2.right = add(root2.right, string);
		    } else {
		        root2.right = new Node(string);
		    }
		}

		return root2;
	}

	public String search(String string) {
		   if (root == null)
		        return "Empty Tree";

		    Node node = root;
		    int compareResult;
		    while ((compareResult = node.data.compareTo(string)) != 0) {
		        if (compareResult > 0) {
		            if (node.left != null)
		                node = node.left;
		            else
		                return null;
		        } else {
		            if (node.right != null)
		                node = node.right;
		            else
		                return null;
		        }
		    }
		    return node.data;
		
	}

	public void printPreOrder() {
		// TODO Auto-generated method stub
		
	}

	public void printInOrder() {
		// TODO Auto-generated method stub
		
	}

	public void printPostOrder() {
		// TODO Auto-generated method stub
		
	}

}
