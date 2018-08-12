
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "     ";
		// Write your code here.
		s = s.trim();
		if(!s.isEmpty()){
        	String[] arr = s.split("\\s*[^a-zA-Z]+\\s*");
        	System.out.println(arr.length);
        	for(int i = 0; i < arr.length; i++)
				System.out.println(arr[i]);
		} else
			System.out.println("0");
		
	}

}
