
public class Temp {

	public Temp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(tempConverson("32C"));

	}
	
	
	public boolean isValid(String check){
		
		return check.matches("[\\d]*[CF]");
	}
	
	public static double tempConverson(String input){
		int temp = Integer.parseInt(input.substring(0, input.length() -1));
		char degree = input.charAt(input.length() -1);
		double total = 0;
		
		switch (degree){
		case 'C':
			total = (temp * 1.8) + 32;
			break;
		case 'F':
			total = (temp - 32) / 1.8;
		}
		return total; 
	}
}
