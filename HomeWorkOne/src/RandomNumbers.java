import java.util.*; 
public class RandomNumbers {

	
	
	public static void main(String[] args){
		
		Random r = new Random();
		int[] num = new int[50];
		String[] count = {"","","","","","","","","","",};
		String[] range = {"1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60",
				"61 - 70", "71 - 80", "81 - 90", "91 - 100"};
		 
		for(int i = 0; i < num.length; i++){
			
			num[i] = r.nextInt(100)+1;
			
			if(num[i] > 0 && num[i] < 11)
				count[0] += "*";
			else if(num[i] > 10 && num[i] < 21)
				count[1] += "*";
			else if(num[i] > 20 && num[i] < 31)
				count[2] += "*";
			else if(num[i] > 30 && num[i] < 41)
				count[3] += "*";
			else if(num[i] > 40 && num[i] < 51)
				count[4] += "*";
			else if(num[i] > 50 && num[i] < 61)
				count[5] += "*";
			else if(num[i] > 60 && num[i] < 71)
				count[6] += "*";
			else if(num[i] > 70 && num[i] < 81)
				count[7] += "*";
			else if(num[i] > 80 && num[i] < 91)
				count[8] += "*";
			else
				count[9] += "*";
			
		}
		
		for(int i = 0; i < range.length; i++){
			
			String space = "";
			
			for(int j = range[i].length(); j < 11; j++){
				
				space += " ";
			}
			
			System.out.println(range[i] + space + " |    " + count[i]);
			
		}
		
		
	}
}
