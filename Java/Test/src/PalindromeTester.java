import java.util.Stack;

public class PalindromeTester {

	
	public boolean isPalindrome(String string) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < string.length(); i++){
			
			stack.push(string.charAt(i));
		}
		
		String pal = "";
		
		while(!stack.isEmpty()){
			pal += stack.pop();
		}
		
		if(string.equals(pal))
			return true;
		
		return false;
	}

}
